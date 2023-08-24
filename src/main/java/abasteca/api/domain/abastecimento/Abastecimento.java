package abasteca.api.domain.abastecimento;

import java.math.BigDecimal;

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

    public void excluir() {
        this.ativo = false;
    }
}