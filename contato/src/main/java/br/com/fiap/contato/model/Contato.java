package br.com.fiap.contato.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_contatos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Contato {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CONTATOS_SEQ"
    )
    @SequenceGenerator(
            name = "CONTATOS_SEQ",
            sequenceName = "CONTATOS_SEQ",
            initialValue = 1,
            allocationSize = 50
    )

    private Long id;
    private String nome;
    private String email;
    private String senha;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

}
