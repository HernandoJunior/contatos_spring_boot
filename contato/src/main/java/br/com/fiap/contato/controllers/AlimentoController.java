package br.com.fiap.contato.controllers;

import br.com.fiap.contato.dto.AlimentoAtualizacaoDto;
import br.com.fiap.contato.dto.AlimentoCadastroDto;
import br.com.fiap.contato.dto.AlimentoExibicaoDto;
import br.com.fiap.contato.model.Alimento;
import br.com.fiap.contato.service.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apialimento")
public class AlimentoController {

    @Autowired
    private AlimentoService service;

    @PostMapping("/alimentos")
    @ResponseStatus(HttpStatus.CREATED)
    public AlimentoExibicaoDto salvar(@RequestBody AlimentoCadastroDto alimentoDto){
        return service.gravar(alimentoDto);
    }

    @GetMapping("/alimentos")
    @ResponseStatus(HttpStatus.OK)
    public List<AlimentoExibicaoDto> listarAlimentos(){
        return service.listarTodosAlimentos();
    }

    @GetMapping("/alimentos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AlimentoExibicaoDto buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @DeleteMapping("alimentos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Alimento deleteAlimento(@PathVariable Long id){
        return service.deletar(id);
    }

    @PutMapping("/alimentos")
    @ResponseStatus(HttpStatus.OK)
    public AlimentoExibicaoDto atualizarAlimento(AlimentoAtualizacaoDto alimentoAtualizacao){
        return service.atualizar(alimentoAtualizacao);
    }
}
