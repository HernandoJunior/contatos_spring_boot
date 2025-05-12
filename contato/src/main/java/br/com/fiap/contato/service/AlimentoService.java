package br.com.fiap.contato.service;

import br.com.fiap.contato.dto.AlimentoAtualizacaoDto;
import br.com.fiap.contato.dto.AlimentoCadastroDto;
import br.com.fiap.contato.dto.AlimentoExibicaoDto;
import br.com.fiap.contato.model.Alimento;
import br.com.fiap.contato.repository.AlimentoRepository;
import br.com.fiap.contato.repository.ContatoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//Classe reponsavel pela injeção de dependencias da interface repository
@Service
public class AlimentoService {

    @Autowired //Anotação usada para fazer a instanciação automaticamente
    private AlimentoRepository alimento;

    public AlimentoExibicaoDto gravar(AlimentoCadastroDto alimentoCadastroDto){
        Alimento alimentoObjeto = new Alimento();
        BeanUtils.copyProperties(alimentoCadastroDto, alimentoObjeto);

        alimentoObjeto.setTotalCalorias(
                calcularCalorias(
                        alimentoObjeto.getQtdeProteinas(),
                        alimentoObjeto.getQtdeCarboidratos(),
                        alimentoObjeto.getQtdeGorduras()
                )
        );

        Alimento alimentoSalvo = alimento.save(alimentoObjeto);
        return new AlimentoExibicaoDto(alimento.save(alimentoSalvo));
    }

    public AlimentoExibicaoDto buscarPorId(Long id){
        Optional<Alimento> alimentoOptional = alimento.findById(id);

        if (alimentoOptional.isPresent()){
            return new AlimentoExibicaoDto(alimentoOptional.get());
        } else {
            throw new RuntimeException("Alimento não encontrado");
        }
    }

    public List<AlimentoExibicaoDto> listarTodosAlimentos(){
        //Fazendo a mudança de tipo dos alimentos com o map para o toList
        return alimento.findAll()
                .stream()
                .map(AlimentoExibicaoDto::new)
                .toList();
    }

    public Alimento deletar(Long id){
        Optional<Alimento> alimentoObjeto = alimento.findById(id);

        if (alimentoObjeto.isPresent()){
            alimento.delete(alimentoObjeto.get());
        } else {
            throw new RuntimeException("Alimento não encontrado");
        }
        return null;
    }

    public AlimentoExibicaoDto atualizar(AlimentoAtualizacaoDto alimentoAtualizacao){
        Alimento alimentoObjeto = new Alimento();
        Optional<Alimento> alimentoOptional = alimento.findById(alimentoObjeto.getAlimentoid());

        if (alimentoOptional.isPresent()){
            BeanUtils.copyProperties(alimentoAtualizacao, alimentoOptional);
            return new AlimentoExibicaoDto(alimento.save(alimentoOptional.get()));
        } else {
            throw new RuntimeException("Alimento não encontrado");
        }


    }

    public Double calcularCalorias(Double proteinas, Double carboidratos, Double gorduras){
        return (proteinas* 4) + (carboidratos * 4) + (gorduras * 9);
    }
}
