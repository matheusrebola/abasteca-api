package abasteca.api.repository;

import abasteca.api.domain.consumo.Consumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo, Long> {
    Page<Consumo> findAllByAtivoTrue(Pageable paginacao);
}