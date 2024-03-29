package abasteca.api.repository;

import abasteca.api.domain.abastecimento.Abastecimento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Long> {
    Page<Abastecimento> findAllByAtivoTrue(Pageable paginacao);
}