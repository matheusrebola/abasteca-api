package abasteca.api.domain.consumo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consumo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal kmPrevista;
    private Boolean ativo;

    public Consumo(DadosCadastroConsumo dados){
        this.kmPrevista = dados.kmPrevista();
    }

    public void atualizarInformacoes(DadosAtualizacaoConsumo dados){
        if (dados.kmPrevista() != null){
            this.kmPrevista = dados.kmPrevista();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
