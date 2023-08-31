package abasteca.api.domain.motorista;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAtualizacaoMotorista(
        @NotNull
        Long id,
        LocalDateTime dataNascimento,
        Sexo sexo
){}