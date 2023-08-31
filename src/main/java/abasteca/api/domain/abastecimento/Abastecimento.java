package abasteca.api.domain.abastecimento;

import java.math.BigDecimal;
import java.math.BigInteger;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "abastecimentos")
@Entity(name = "Abastecimento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Abastecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String combustivel;
    private BigDecimal quantidade;

    private Boolean ativo;

    public Abastecimento (DadosCadastroAbastecimento dados){
        this.ativo = true;
        this.combustivel = dados.combustivel();
        this.quantidade = dados.quantidade();
    }

    public void atualizarInformacoes(DadosAtualizacaoAbastecimento dados){
        if (dados.combustivel() != null){
            this.combustivel = dados.combustivel();
        }
        if (dados.quantidade() != null){
            this.quantidade = dados.quantidade();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}