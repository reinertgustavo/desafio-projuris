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
import desafio.projuris.dev.entities.Ordem;
import desafio.projuris.dev.repositories.ordemRepository;
import desafio.projuris.dev.repositories.clienteRepository;

@RestController
public class ordensController {

    @Autowired
    private ordemRepository ordemRepository;
    @Autowired
    private clienteRepository clienteRepository;

    @GetMapping("/ordens")
    public List<Ordem> retornaTodos() {
        return ordemRepository.findAll();
    }

    @PostMapping("/ordens")
    public ResponseEntity<Object> criarOrdem(@RequestBody Ordem ordem) {
        Ordem ordemSalva = ordemRepository.save(ordem);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ordemSalva.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
