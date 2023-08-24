package abasteca.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajetoRepository extends JpaRepository<Trajeto, Long> {}