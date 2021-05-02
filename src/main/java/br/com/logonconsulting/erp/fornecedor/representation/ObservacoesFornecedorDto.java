package br.com.logonconsulting.erp.fornecedor.representation;

import br.com.logonconsulting.erp.fornecedor.model.Fornecedor;
import br.com.logonconsulting.erp.fornecedor.model.ObservacoesFornecedor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ObservacoesFornecedorDto {
    private Set<ObservacaoFornecedorDto> obsercacoes;

    public static ObservacoesFornecedorDto toRepresentation(Fornecedor fornecedor) {
        return ObservacoesFornecedorDto.builder()
                .obsercacoes(fornecedor.getObsercacoes()
                        .stream()
                        .map(ObservacaoFornecedorDto::toRepresentation)
                        .collect(Collectors.toSet()))
                .build();
    }
}
