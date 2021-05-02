package br.com.logonconsulting.erp.fornecedor.representation;

import br.com.logonconsulting.erp.fornecedor.model.Fornecedor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;

@NoArgsConstructor
@Getter
public class FornecedorCreateIntent {
    private String nome;
    private String cnpj;

    public Fornecedor toEntity() {
        return Fornecedor.builder()
                .nome(this.nome)
                .cnpj(this.cnpj)
                .obsercacoes(Collections.emptyList())
                .build();
    }
}
