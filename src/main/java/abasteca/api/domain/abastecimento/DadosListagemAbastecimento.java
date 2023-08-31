package abasteca.api.domain.abastecimento;

import java.math.BigDecimal;

public record DadosListagemAbastecimento(
    Long id,
    String combustivel,
    BigDecimal quantidade
){
    public DadosListagemAbastecimento (Abastecimento abastecimento){
        this(abastecimento.getId(), abastecimento.getCombustivel(), abastecimento.getQuantidade());
    }
}