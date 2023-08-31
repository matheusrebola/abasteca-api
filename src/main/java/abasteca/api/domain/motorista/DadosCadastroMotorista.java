package abasteca.api.domain.motorista;

import java.time.LocalDateTime;

public record DadosCadastroMotorista(
        LocalDateTime dataNascimento,
        Sexo sexo
){}