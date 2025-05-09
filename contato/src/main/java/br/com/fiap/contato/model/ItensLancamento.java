package br.com.fiap.contato.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_itens_lancamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ItensLancamento {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ITENS_LANCAMENTO_SEQ"
    )
    @SequenceGenerator(
            name = "ITENS_LANCAMENTO_SEQ",
            sequenceName = "ITENS_LANCAMENTO_SEQ",
            initialValue = 1,
            allocationSize = 50
    )
    private Long itemlancamentoid;

    private Double porcao;

    @Column(name = "total_calorias")
    private Double totalCalorias;
}
