package abasteca.api.domain.veiculo;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosAtualizacaoVeiculo(
        @NotNull
        Long id,
        String marca,
        String modelo,
        String versao,
        String ano,
        String motor,
        BigDecimal peso
) {
}
