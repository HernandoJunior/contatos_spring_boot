package br.com.fiap.contato.dto;

public record AlimentoAtualizacaoDto (
        Long id,
        String nome,
        String porcao,
        Double qtdeProteinas,
        Double qtdeCarboidratos,
        Double qtdeGorduras,
        Double totalCalorias
) {
}
