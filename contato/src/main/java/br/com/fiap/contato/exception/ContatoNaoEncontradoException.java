package br.com.fiap.contato.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContatoNaoEncontradoException extends RuntimeException {

    //Criacao do construtor
    public ContatoNaoEncontradoException(String message){
        super(message);
    }

}
