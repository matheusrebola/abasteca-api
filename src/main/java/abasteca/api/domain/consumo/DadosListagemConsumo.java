package abasteca.api.domain.consumo;

import java.math.BigDecimal;

public record DadosListagemConsumo(Long id, BigDecimal kmPrevista){
    public DadosListagemConsumo(Consumo consumo){
        this(consumo.getId(), consumo.getKmPrevista());
    }
}