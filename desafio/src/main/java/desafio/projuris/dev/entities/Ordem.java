package desafio.projuris.dev.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import desafio.projuris.dev.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ordem {

  @Id
  @GeneratedValue
  private Long id;
  private String problema;

  @Enumerated(EnumType.STRING)
  private Status status;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "equipamento_ordem", joinColumns = @JoinColumn(name = "equipamento_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ordem_id", referencedColumnName = "id"))

  private List<Equipamento> equipamentos;

  @ManyToOne
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;

}