package abasteca.api.repository;

import abasteca.api.domain.motorista.Motorista;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Long> {
    Page<Motorista> findAllByAtivoTrue(Pageable paginacao);
}