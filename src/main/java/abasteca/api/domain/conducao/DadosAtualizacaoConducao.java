package abasteca.api.domain.conducao;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoConducao(
        @NotNull
        Long id,
        Avatar avatar,
        EstiloDirecao estiloDirecao
){

}