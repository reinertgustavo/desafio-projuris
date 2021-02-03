package desafio.projuris.dev.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Funcionario {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "funcionario")
    private List<Ordem> ordens;

}