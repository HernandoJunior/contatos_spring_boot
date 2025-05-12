package br.com.fiap.contato.dto;

import jakarta.validation.constraints.NotBlank;

public record AlimentoCadastroDto (
        Long alimentoid,

        @NotBlank(message = "Campo nome obrigatório")
        String nome,
        String porcao,
        Double qtdeProteinas,
        Double qtdeCarboidratos,
        Double qtdeGorduras
) {
}

/*
    Anotação @NotBlank para informar que o campo não pode ser nulo ou em branco

*/
