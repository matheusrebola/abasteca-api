package abasteca.api.domain.veiculo;

import java.math.BigDecimal;

public record DadosListagemVeiculo(
        Long id,
        String marca,
        String modelo,
        String versao,
        String ano,
        String motor,
        BigDecimal peso
) {
    public DadosListagemVeiculo(Veiculo veiculo){
        this(
                veiculo.getId(),
                veiculo.getMarca(),
                veiculo.getModelo(),
                veiculo.getVersao(),
                veiculo.getAno(),
                veiculo.getMotor(),
                veiculo.getPeso()
                );
    }
}
