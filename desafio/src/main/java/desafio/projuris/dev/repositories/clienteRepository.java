package desafio.projuris.dev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import desafio.projuris.dev.entities.Cliente;
    
@Repository
public interface clienteRepository extends JpaRepository<Cliente, Long>{
}