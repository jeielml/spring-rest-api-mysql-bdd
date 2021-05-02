package br.com.logonconsulting.erp.fornecedor.representation;

import br.com.logonconsulting.erp.fornecedor.model.ObservacoesFornecedor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ObservacaoFornecedorDto {
    private Long id;
    private String obsercacao;

    public static ObservacaoFornecedorDto toRepresentation(ObservacoesFornecedor observacoesFornecedor) {
        return ObservacaoFornecedorDto.builder()
                .id(observacoesFornecedor.getId())
                .obsercacao(observacoesFornecedor.getObservacao())
                .build();
    }
}
