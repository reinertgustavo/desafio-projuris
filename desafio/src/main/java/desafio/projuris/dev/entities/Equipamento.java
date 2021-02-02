package desafio.projuris.dev.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Equipamento {

    @Id
    @GeneratedValue
    private Long id;
    private String tipo;
    private String marca;
    private String descricao;

    @ManyToMany(mappedBy = "equipamentos")
    private List<Ordem> ordens;

}