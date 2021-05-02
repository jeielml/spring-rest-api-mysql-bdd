package br.com.logonconsulting.erp.fornecedor.representation;

import br.com.logonconsulting.erp.fornecedor.model.Fornecedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class FornecedorUpdateIntent {
    private String nome;

    public Fornecedor updateEntity(Fornecedor entity){
        return entity.toBuilder()
                .nome(this.nome)
                .build();

    }
}
