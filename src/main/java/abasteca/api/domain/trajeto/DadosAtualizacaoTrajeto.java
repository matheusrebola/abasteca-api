package abasteca.api.domain.trajeto;

import java.math.BigDecimal;

public record DadosAtualizacaoTrajeto(
        Long id,
        BigDecimal longitude,
        BigDecimal latitude
){}