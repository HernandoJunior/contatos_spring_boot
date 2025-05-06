package br.com.fiap.contato.repository;

import br.com.fiap.contato.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//A interface Contato, herda JpaRepository do tipo contato e o tipo do id da entidade
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    //Não precisamos implementar a função, apenas informar ao Spring o que procurar
    public Optional<Contato> findByNome(String nome);

    public List<Contato> findByDataNascimentoBetween(LocalDate dataNascimentoAfter, LocalDate dataNascimentoBefore);


}
