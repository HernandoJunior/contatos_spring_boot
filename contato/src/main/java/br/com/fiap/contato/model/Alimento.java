package br.com.fiap.contato.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_alimentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Alimento {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ALIMENTO_SEQ"
    )
    @SequenceGenerator(
            name = "ALIMENTO_SEQ",
            sequenceName = "ALIMENTO_SEQ",
            initialValue = 1,
            allocationSize = 50
    )
    private Long alimentoid;

    private String nome;
    private String porcao;

    @Column(name = "qtde_proteinas")
    private double qtdeProteinas;

    @Column(name = "qtde_carboidratos")
    private double qtdeCarboidratos;

    @Column(name = "qtde_gorduras")
    private double qtdeGorduras;

    @Column(name = "qtde_calorias")
    private double totalCalorias;

}
