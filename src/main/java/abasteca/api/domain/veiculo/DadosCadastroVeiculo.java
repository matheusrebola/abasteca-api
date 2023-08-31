package abasteca.api.domain.veiculo;

import java.math.BigDecimal;

public record DadosCadastroVeiculo(
        String marca,
        String modelo,
        String versao,
        String ano,
        String motor,
        BigDecimal peso
) {
}
