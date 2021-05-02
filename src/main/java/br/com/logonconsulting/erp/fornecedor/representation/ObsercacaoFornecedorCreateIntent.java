package br.com.logonconsulting.erp.fornecedor.representation;

import br.com.logonconsulting.erp.fornecedor.model.Fornecedor;
import br.com.logonconsulting.erp.fornecedor.model.ObservacoesFornecedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ObsercacaoFornecedorCreateIntent {
    private String obsercacao;

    public Fornecedor updateEntity(Fornecedor entity){
        return entity.toBuilder()
                .obsercacao(ObservacoesFornecedor.builder().observacao(this.obsercacao).build())
                .build();
    }
}
