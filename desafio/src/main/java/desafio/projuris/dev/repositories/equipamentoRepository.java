package desafio.projuris.dev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import desafio.projuris.dev.entities.Equipamento;
    
@Repository
public interface equipamentoRepository extends JpaRepository<Equipamento, Long>{
}