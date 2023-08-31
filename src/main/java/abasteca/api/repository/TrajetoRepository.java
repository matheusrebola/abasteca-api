package abasteca.api.repository;

import abasteca.api.domain.trajeto.Trajeto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajetoRepository extends JpaRepository<Trajeto, Long> {
    Page<Trajeto> findAllByAtivoTrue(Pageable paginacao);
}