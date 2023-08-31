package abasteca.api.repository;

import abasteca.api.domain.veiculo.Veiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    Page<Veiculo> findAllByAtivoTrue(Pageable paginacao);
}