package br.com.fiap.contato.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_contatos")
public class Contato {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_CONTATOS"
    )
    @SequenceGenerator(
            name = "SEQ_CONTATOS",
            sequenceName = "SEQ_CONTATOS",
            allocationSize = 50
    )

    private Long id;
    private String nome;
    private String email;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
