package br.com.fiap.contato.dto;

import java.time.LocalDate;

public record ContatoAtualizacaoDto (
        Long id,
        String nome,
        String email,
        String senha,
        LocalDate dataNascimento
) {
}
