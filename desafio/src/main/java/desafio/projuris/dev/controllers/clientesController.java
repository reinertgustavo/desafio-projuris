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
import desafio.projuris.dev.entities.Cliente;
import desafio.projuris.dev.repositories.clienteRepository;

@RestController
public class clientesController {

	@Autowired
    private clienteRepository clienteRepository;

    @GetMapping("/clientes")
    public List<Cliente> retornaTodos() {
	    return clienteRepository.findAll();
    }

    @PostMapping("/clientes")
    public ResponseEntity<Object> criarCliente(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clienteRepository.save(cliente);
    
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(clienteSalvo.getId()).toUri();
    
        return ResponseEntity.created(location).build();
    }

}