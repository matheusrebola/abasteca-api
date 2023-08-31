package abasteca.api.domain.motorista;

import java.time.LocalDateTime;

public record DadosListagemMotorista(
        Long id,
        LocalDateTime dataNascimento,
        Sexo sexo
){
    DadosListagemMotorista(Motorista motorista){
        this(motorista.getId(), motorista.getDataNascimento(), motorista.getSexo());
    }
}