package abasteca.api.domain.trajeto;

import java.math.BigDecimal;

public record DadosCadastroTrajeto(
        BigDecimal longitude,
        BigDecimal latitude
){}