package desafio.projuris.dev.controllers;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import desafio.projuris.dev.entities.Funcionario;
import desafio.projuris.dev.repositories.funcionarioRepository;

@RestController
@RequestMapping("/funcionarios")
public class funcionariosController {

    @Autowired
    private funcionarioRepository funcionarioRepository;

    @GetMapping()
    public List<Funcionario> retornaTodos() {
        return funcionarioRepository.findAll();
    }

    @PostMapping()
    public ResponseEntity<Object> criarFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(funcionarioSalvo.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}