package desafio.projuris.dev.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import desafio.projuris.dev.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "id")
public class Ordem {

  @Id
  @GeneratedValue
  private Long id;
  private String problema;

  @Enumerated(EnumType.STRING)
  private Status status = Status.ABERTO;

  @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
  @JoinTable(name = "equipamento_ordem", joinColumns = @JoinColumn(name = "equipamento_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ordem_id", referencedColumnName = "id"))
  private List<Equipamento> equipamentos;

  @ManyToOne
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;

  @ManyToOne
  @JoinColumn(name = "funcionario_id")
  private Funcionario funcionario;

}