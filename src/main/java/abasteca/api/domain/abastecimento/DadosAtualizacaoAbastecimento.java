package abasteca.api.domain.abastecimento;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosAtualizacaoAbastecimento(
        @NotNull
        Long id,
        String combustivel,
        BigDecimal quantidade
) {
}
