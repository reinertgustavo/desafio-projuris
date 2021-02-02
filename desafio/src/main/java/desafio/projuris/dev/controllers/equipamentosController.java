package desafio.projuris.dev.controllers;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import desafio.projuris.dev.entities.Equipamento;
import desafio.projuris.dev.repositories.equipamentoRepository;

@RestController
public class equipamentosController {
	@Autowired
    private equipamentoRepository equipamentoRepository;

    @GetMapping("/equipamentos")
    public List<Equipamento> retornaTodos() {
	    return equipamentoRepository.findAll();
    }

    @PostMapping("/equipamentos")
    public ResponseEntity<Object> criarEquipamento(@RequestBody Equipamento equipamento) {
        Equipamento equipamentoSalvo = equipamentoRepository.save(equipamento);
    
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(equipamentoSalvo.getId()).toUri();
    
        return ResponseEntity.created(location).build();
    }

}
