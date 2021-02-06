package desafio.projuris.dev.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "id")
public class Equipamento {

    @Id
    @GeneratedValue
    private Long id;
    private String tipo;
    private String marca;
    private String descricao;

    @ManyToMany(mappedBy = "equipamentos", fetch=FetchType.EAGER)
    private List<Ordem> ordens;

}