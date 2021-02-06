package desafio.projuris.dev.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.projuris.dev.entities.Ordem;
import desafio.projuris.dev.repositories.equipamentoRepository;
import desafio.projuris.dev.repositories.ordemRepository;


@RestController
@RequestMapping("/ordens")
public class ordensController {

    @Autowired
    private ordemRepository ordemRepository;
    @Autowired
    private equipamentoRepository equipamentoRepository;

    public ordensController(ordemRepository ordemRepository) {
        super();
        this.ordemRepository = ordemRepository;
    }

    @PostMapping
    public ResponseEntity<Ordem> save(@RequestBody Ordem ordem) {
        ordemRepository.save(ordem);
        return new ResponseEntity<>(ordem, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Ordem>> getAll() {
        List<Ordem> ordens = new ArrayList<>();
        ordens = ordemRepository.findAll();
        return new ResponseEntity<>(ordens, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Ordem>> getById(@PathVariable Long id) {
        Optional<Ordem> ordem;
        try {
            ordem = ordemRepository.findById(id);
            return new ResponseEntity<Optional<Ordem>>(ordem, HttpStatus.OK);
        } catch (NoSuchElementException nsee) {
            return new ResponseEntity<Optional<Ordem>>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping(path = "/{id}/equipamentos/{idEquipamento}")
    public ResponseEntity<Ordem> saveEquipamento(@PathVariable Long id, @PathVariable Long idEquipamento) {
        if(!ordemRepository.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        var ordem = ordemRepository.findById(id).get();
        var equipamentos = ordem.getEquipamentos();
        equipamentos.add(equipamentoRepository.findById(idEquipamento).get());
        ordem.setEquipamentos(equipamentos);
        return ResponseEntity.ok().body(ordemRepository.save(ordem));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Optional<Ordem>> deleteById(@PathVariable Long id) {
        try {
            ordemRepository.deleteById(id);
            return new ResponseEntity<Optional<Ordem>>(HttpStatus.OK);
        } catch (NoSuchElementException nsee) {
            return new ResponseEntity<Optional<Ordem>>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Ordem> update(@PathVariable Long id, @RequestBody Ordem novaOrdem) {
        return ordemRepository.findById(id)
        .map(ordem -> {
            ordem.setCliente(novaOrdem.getCliente());
            ordem.setEquipamentos(novaOrdem.getEquipamentos());
            ordem.setProblema(novaOrdem.getProblema());
            ordem.setFuncionario(novaOrdem.getFuncionario());
            ordem.setStatus(novaOrdem.getStatus());
            Ordem ordemAtualizada = ordemRepository.save(ordem);
            return ResponseEntity.ok().body(ordemAtualizada);
       }).orElse(ResponseEntity.notFound().build());
    }
}