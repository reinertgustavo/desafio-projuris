package desafio.projuris.dev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import desafio.projuris.dev.entities.Ordem;

@Repository
public interface ordemRepository extends JpaRepository<Ordem, Long> {
}