package abasteca.api.domain.conducao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "Conducoes")
@Entity(name = "Conducao")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conducao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Avatar avatar;
    private EstiloDirecao estiloDirecao;

    private Boolean ativo;

    public Conducao(DadosCadastroConducao dados) {
        this.ativo = true;
        this.avatar = dados.avatar();
        this.estiloDirecao = dados.estiloDirecao();
    }

    public void atualizarInformacoes(DadosAtualizacaoConducao dados){
        if(dados.avatar() != null){
            this.avatar = dados.avatar();
        }
        if(dados.estiloDirecao() != null){
            this.estiloDirecao = dados.estiloDirecao();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
