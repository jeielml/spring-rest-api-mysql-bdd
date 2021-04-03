package br.com.logonconsulting.erp.fornecedor.representation;

import br.com.logonconsulting.erp.fornecedor.model.Fornecedor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class FornecedorCreateIntent {
    private String nome;
    private String cnpj;

    public Fornecedor toEntity() {
        return Fornecedor.builder()
                .nome(this.nome)
                .cnpj(this.cnpj)
                .build();
    }
}
