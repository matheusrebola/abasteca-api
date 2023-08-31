package abasteca.api.domain.trajeto;

import java.math.BigDecimal;

public record DadosListagemTrajeto(
        Long id,
        BigDecimal longitude,
        BigDecimal latitude
){
    public DadosListagemTrajeto(Trajeto trajeto){
        this(trajeto.getId(), trajeto.getLongitude(), trajeto.getLatitude());
    }
}