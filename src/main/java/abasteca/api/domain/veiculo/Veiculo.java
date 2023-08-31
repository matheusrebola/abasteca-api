package abasteca.api.domain.veiculo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "Veiculos")
@Entity(name = "veiculo")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Veiculo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private String versao;
    private String ano;
    private String motor;
    private BigDecimal peso;
    private Boolean ativo;

    public Veiculo(DadosCadastroVeiculo dados){
        this.ativo = true;
        this.marca = dados.marca();
        this.modelo = dados.modelo();
        this.versao = dados.versao();
        this.ano = dados.ano();
        this.motor = dados.motor();
        this.peso = dados.peso();
    }

    public void atualizarInformacoes(DadosAtualizacaoVeiculo dados){
        if (dados.marca() != null){
            this.marca = dados.marca();
        }
        if (dados.modelo() != null){
            this.modelo = dados.modelo();
        }
        if (dados.versao() != null){
            this.versao = dados.versao();
        }
        if (dados.ano() != null){
            this.ano = dados.ano();
        }
        if (dados.motor() != null){
            this.motor = dados.motor();
        }
        if (dados.peso() != null){
            this.peso = dados.peso();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
