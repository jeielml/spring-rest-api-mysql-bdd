package br.com.logonconsulting.erp.fornecedor.representation;

import br.com.logonconsulting.erp.fornecedor.model.Fornecedor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class FornecedorDto {
    private Long id;
    private String nome;
    private String cnpj;

    public static FornecedorDto toRepresentation(Fornecedor fornecedor) {
        return FornecedorDto.builder()
                .id(fornecedor.getId())
                .nome(fornecedor.getNome())
                .cnpj(fornecedor.getCnpj())
                .build();
    }
}
