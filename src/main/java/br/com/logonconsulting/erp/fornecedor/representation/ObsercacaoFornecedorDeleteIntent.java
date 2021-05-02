package br.com.logonconsulting.erp.fornecedor.representation;

import br.com.logonconsulting.erp.fornecedor.model.Fornecedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ObsercacaoFornecedorDeleteIntent {

    public static Fornecedor updateEntity(Long obsercacaoId, Fornecedor entity){
        entity.getObsercacoes()
                .removeIf(observacoesFornecedor -> observacoesFornecedor.getId().equals(obsercacaoId));
        return entity;

    }
}
