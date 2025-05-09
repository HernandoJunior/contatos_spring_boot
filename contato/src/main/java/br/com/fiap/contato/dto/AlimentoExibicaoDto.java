package br.com.fiap.contato.dto;

import br.com.fiap.contato.model.Alimento;

public record AlimentoExibicaoDto (
        Long id,
        String nome,
        String porcao,
        Double qtdeProteinas,
        Double qtdeCarboidratos,
        Double qtdeGorduras,
        Double totalCalorias
) {
    public AlimentoExibicaoDto(Alimento alimento){
        this(
                alimento.getAlimentoid(),
                alimento.getNome(),
                alimento.getPorcao(),
                alimento.getQtdeProteinas(),
                alimento.getQtdeCarboidratos(),
                alimento.getQtdeGorduras(),
                alimento.getTotalCalorias()
        );
    }
}
