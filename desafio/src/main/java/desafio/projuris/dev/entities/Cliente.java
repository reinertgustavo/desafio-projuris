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
public class Cliente {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;

    @OneToMany(mappedBy = "cliente")
    private List<Ordem> ordens;

}