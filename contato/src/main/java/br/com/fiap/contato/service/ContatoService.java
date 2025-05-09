package br.com.fiap.contato.service;

import br.com.fiap.contato.dto.ContatoAtualizacaoDto;
import br.com.fiap.contato.dto.ContatoCadastroDto;
import br.com.fiap.contato.dto.ContatoExibicaoDto;
import br.com.fiap.contato.model.Contato;
import br.com.fiap.contato.repository.ContatoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public ContatoExibicaoDto gravar(ContatoCadastroDto ContatoCadastroDto){
        Contato contato = new Contato();
        //Convertendo o dto em um contato
        BeanUtils.copyProperties(ContatoCadastroDto, contato);
        return new ContatoExibicaoDto(contatoRepository.save(contato));
    }

    public ContatoExibicaoDto buscarPorId(Long id){
        Optional<Contato> contatoOptional = contatoRepository.findById(id);

        if (contatoOptional.isPresent()){
            return new ContatoExibicaoDto(contatoOptional.get());
        } else {
            throw new RuntimeException("Contato não encontrado");
        }
    }

    public List<ContatoExibicaoDto> buscarTodosOsContatos() {
        List<Contato> contatos = contatoRepository.findAll();
        //Convertemos a lista de contatos em uma Strwm
        return contatos.stream()
                .map(ContatoExibicaoDto::new)
                .collect(Collectors.toList());
    }

    public Contato deletar(Long id){
        Optional<Contato> contatoOptional = contatoRepository.findById(id);

        if (contatoOptional.isPresent()){
            contatoRepository.delete(contatoOptional.get());
        } else {
            throw new RuntimeException("Contato não encontrado");
        }
        return null;
    }

    public List<Contato> mostrarAniversariantes(LocalDate dataInicial, LocalDate dataFinal){
        return contatoRepository.findByDataNascimentoBetween(dataInicial, dataFinal);
    }

    public ContatoExibicaoDto atualizar(ContatoAtualizacaoDto contatoDto){
        //Passando o contato pelo Id
        Contato contato = new Contato();
        Optional<Contato> contatoOptional = contatoRepository.findById(contato.getId());

        BeanUtils.copyProperties(contatoDto, contato);
        if (contatoOptional.isPresent()){
            //O save atualiza e cria automaticamente
            return new ContatoExibicaoDto(contatoRepository.save(contato));
        } else {
            throw new RuntimeException("Contato não encontrado");
        }
    }

    public Optional<Contato> buscarContatoPorNome(String nome){
        Optional<Contato> contatoOptional = contatoRepository.findByNome(nome);

        if (contatoOptional.isPresent()){
            return contatoOptional;
        } else {
            throw new RuntimeException("Contato não encontrado");
        }
    }
}
