package desafio.projuris.dev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import desafio.projuris.dev.entities.Funcionario;

@Repository
public interface funcionarioRepository extends JpaRepository<Funcionario, Long> {
}