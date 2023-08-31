package abasteca.api.domain.trajeto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "Trajetos")
@Entity(name = "Trajeto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Trajeto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private Boolean ativo;

    public Trajeto(DadosCadastroTrajeto dados){
        this.ativo = true;
        this.latitude = dados.latitude();
        this.longitude = dados.longitude();
    }
    public void atualizarInformacoes(DadosAtualizacaoTrajeto dados){

    }
    public void excluir() {
        this.ativo = false;
    }
}
