package br.com.fiap.contato.controllers;

import br.com.fiap.contato.model.Contato;
import br.com.fiap.contato.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {

    @Autowired
    private ContatoService service;

    @PostMapping("/contatos")
    @ResponseStatus(HttpStatus.CREATED)
    public Contato gravarContato(@RequestBody Contato contato){
        return service.gravar(contato);
    }

    @GetMapping("/contatos")
    @ResponseStatus(HttpStatus.OK)
    public List<Contato> listarContatos(){
        return service.buscarTodosOsContatos();
    }

    @GetMapping("/contatos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Contato buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @DeleteMapping("/contatos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Contato deleteContato(@PathVariable Long id){
        return service.deletar(id);
    }

    @PutMapping("/contatos")
    @ResponseStatus(HttpStatus.OK)
    public Contato atualizarContato(@RequestBody Contato contato){
        return service.atualizar(contato);
    }

    @GetMapping("/contatos/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public Contato buscarPorNome(@PathVariable String nome){
        return service.buscarContatoPorNome(nome).get();
    }

    @GetMapping("/contatos/{dataInicial}/{dataFinal}")
    @ResponseStatus(HttpStatus.OK)
    public List<Contato> buscarAniversariantes(@PathVariable LocalDate dataInicial,
                                               @PathVariable LocalDate dataFinal){
        return service.mostrarAniversariantes(dataInicial, dataFinal);

    }
}
