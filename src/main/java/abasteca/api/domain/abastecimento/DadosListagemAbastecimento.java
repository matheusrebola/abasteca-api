package abasteca.api.domain.abastecimento;

public record DadosListagemAbastecimento(
    Long id,
    String combustivel,
    BigDecimal quantidade
){}