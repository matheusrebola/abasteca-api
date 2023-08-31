package abasteca.api.domain.abastecimento;

import java.math.BigDecimal;

public record DadosCadastroAbastecimento(
    String combustivel,
    BigDecimal quantidade
){}