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

    /***
     * TODO: usar builder da entidade
     * @param entity
     */
    public void updateEntity(Fornecedor entity){
        entity.setNome(this.nome);
    }
}
