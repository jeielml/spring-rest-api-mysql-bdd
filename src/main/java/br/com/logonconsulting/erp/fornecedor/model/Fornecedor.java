package br.com.logonconsulting.erp.fornecedor.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Fornecedor {
    private Long id;
    @Setter
    private String nome;
    private String cnpj;
}
