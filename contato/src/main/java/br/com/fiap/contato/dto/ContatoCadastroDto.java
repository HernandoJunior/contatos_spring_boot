package br.com.fiap.contato.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ContatoCadastroDto(
        Long id,

        @NotBlank(message = "Campo nome obrigatório!")
        String nome,

        @NotBlank(message = "Campo email obrigatório!")
        @Email(message = "Email incorreto, preencha novamente!")
        String email,

        @NotBlank(message = "Campo senha obrigatória!")
        @Size(min = 6, max = 10, message = "A senha deve conter entre 6 e 10 caracteres!")
        String senha,

        @NotNull(message = "Campo data de nascimento obrigatória!")
        LocalDate dataNascimento
) {
}

/*
    @NotBlank para informar que o campo não pode ser nulo ou em branco
    @Email para verificar se o campo do email foi enviado com as caracteristicas do email (campo, dominio, etc)
    @Size para definir um tamanho minimo de caracteres
    @NotNull usado para campos como Data, que não são do tipo string. A mesma função do NotBlank

    Anotações utilizadas pela dependencia Bean Validation
*/

