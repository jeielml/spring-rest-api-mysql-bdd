package br.com.logonconsulting.erp.fornecedor.representation;

import br.com.logonconsulting.erp.fornecedor.model.Fornecedor;
import br.com.logonconsulting.erp.fornecedor.model.ObservacoesFornecedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class FornecedorAdicionaObsercaoIntent {
    private String obsercacao;

    public Fornecedor updateEntity(Fornecedor entity){
        entity.getObsercacoes().add(ObservacoesFornecedor.builder().observacao(this.obsercacao).build());
        return entity;

    }
}
