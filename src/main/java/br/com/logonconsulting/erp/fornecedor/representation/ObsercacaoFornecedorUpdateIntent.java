package br.com.logonconsulting.erp.fornecedor.representation;

import br.com.logonconsulting.erp.fornecedor.model.Fornecedor;
import br.com.logonconsulting.erp.fornecedor.model.ObservacoesFornecedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ObsercacaoFornecedorUpdateIntent {
    private String obsercacao;

    public Fornecedor updateEntity(Long obsercacaoId, Fornecedor entity){
        entity.getObsercacoes()
                .stream()
                .filter(observacoesFornecedor -> observacoesFornecedor.getId().equals(obsercacaoId))
                .findFirst()
                .ifPresent(observacoesFornecedor -> {
                    observacoesFornecedor
                            .toBuilder()
                            .observacao(this.obsercacao)
                            .build();
                });
        return entity;

    }
}
