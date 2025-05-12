package br.com.fiap.contato.controllers;

import br.com.fiap.contato.dto.ContatoAtualizacaoDto;
import br.com.fiap.contato.dto.ContatoCadastroDto;
import br.com.fiap.contato.dto.ContatoExibicaoDto;
import br.com.fiap.contato.model.Contato;
import br.com.fiap.contato.service.ContatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ContatoController {

    @Autowired
    private ContatoService service;

    @PostMapping("/contatos")
    @ResponseStatus(HttpStatus.CREATED)
    public ContatoExibicaoDto gravarContato(@RequestBody @Valid ContatoCadastroDto contatoDto){
        return service.gravar(contatoDto);
    }

    @GetMapping("/contatos")
    @ResponseStatus(HttpStatus.OK)
    public List<ContatoExibicaoDto> listarContatos(){
        return service.buscarTodosOsContatos();
    }

    @GetMapping("/contatos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContatoExibicaoDto buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @DeleteMapping("/contatos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Contato deleteContato(@PathVariable Long id){
        return service.deletar(id);
    }

    @PutMapping("/contatos")
    @ResponseStatus(HttpStatus.OK)
    public ContatoExibicaoDto atualizarContato(@RequestBody ContatoAtualizacaoDto contatoAtualizacaoDto){
        return service.atualizar(contatoAtualizacaoDto);
    }

    @GetMapping("/nomecontatos/")
    @ResponseStatus(HttpStatus.OK)
    public Contato buscarPorNome(@RequestBody String nome){
        return service.buscarContatoPorNome(nome).get();
    }

    @GetMapping("/contatos/{dataInicial}/{dataFinal}")
    @ResponseStatus(HttpStatus.OK)
    public List<Contato> buscarAniversariantes(@PathVariable LocalDate dataInicial,
                                               @PathVariable LocalDate dataFinal){
        return service.mostrarAniversariantes(dataInicial, dataFinal);

    }
}

/*
    Anotações Bean Validation:
        @Valid é usado para informar que o objeto recebido deve ser validado com base nas anotações feitas no DTO

    Anotações Spring Web:

 */