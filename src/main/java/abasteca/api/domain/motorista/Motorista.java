package abasteca.api.domain.motorista;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Table(name = "motoristas")
@Entity(name = "Motorista")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Motorista {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataNascimento;
    private Sexo sexo;
    private Boolean ativo;

    public Motorista(DadosCadastroMotorista dados){
        this.ativo = true;
        this.dataNascimento = dados.dataNascimento();
        this.sexo = dados.sexo();
    }

    public void atualizarInformacoes(DadosAtualizacaoMotorista dados){
        if(dados.dataNascimento() != null){
            this.dataNascimento = dados.dataNascimento();
        }
        if (dados.sexo() != null){
            this.sexo = dados.sexo();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
