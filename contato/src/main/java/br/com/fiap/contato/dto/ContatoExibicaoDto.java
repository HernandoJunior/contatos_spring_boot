package br.com.fiap.contato.dto;

import br.com.fiap.contato.model.Contato;

import java.time.LocalDate;
import java.util.List;

public record ContatoExibicaoDto (
        Long id,
        String nome,
        String email,
        LocalDate dataNascimento
) {
   public ContatoExibicaoDto(Contato contato){
       this(
               contato.getId(),
               contato.getNome(),
               contato.getEmail(),
               contato.getDataNascimento()
       );
   }
}
