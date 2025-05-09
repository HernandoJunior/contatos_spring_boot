package br.com.fiap.contato.repository;

import br.com.fiap.contato.model.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlimentoRepository extends JpaRepository<Alimento, Long> {

//    public Optional<Alimento> findByNome(String nome);

}
