package abasteca.api.repository;

import abasteca.api.domain.conducao.Conducao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConducaoRepository extends JpaRepository<Conducao, Long> {
    Page<Conducao> findAllByAtivoTrue(Pageable paginacao);
}