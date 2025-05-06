package br.com.fiap.contato.service;

import br.com.fiap.contato.model.Contato;
import br.com.fiap.contato.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public Contato gravar(Contato contato){
        return contatoRepository.save(contato);
    }

    public Contato buscarPorId(Long id){
        Optional<Contato> contato = contatoRepository.findById(id);

        if (contato.isPresent()){
            return contato.get();
        } else {
            throw new RuntimeException("Contato não encontrado");
        }
    }

    public List<Contato> buscarTodosOsContatos(){
        return contatoRepository.findAll();

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

    public Contato atualizar(Contato contato){
        //Passando o contato pelo Id
        Optional<Contato> contatoOptional = contatoRepository.findById(contato.getId());

        if (contatoOptional.isPresent()){
            //O save atualiza e cria automaticamente
            return contatoRepository.save(contato);
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
