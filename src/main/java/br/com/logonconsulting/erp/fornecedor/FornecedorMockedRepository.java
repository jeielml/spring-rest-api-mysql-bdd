package br.com.logonconsulting.erp.fornecedor;

import br.com.logonconsulting.erp.fornecedor.model.Fornecedor;
import br.com.logonconsulting.erp.fornecedor.representation.FornecedorUpdateIntent;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.DoubleStream;

@Service
public class FornecedorMockedRepository {

    private List<Fornecedor> fornecedores = Arrays.asList(Fornecedor.builder().id(1l).nome("jeiel").cnpj("").build());

    public List<Fornecedor> findAll() {
        return fornecedores;
    }

    public Optional<Fornecedor> findById(Long id) {
        return this.fornecedores.stream().filter(fornecedor -> fornecedor.getId().equals(id)).findFirst();
    }
    public Fornecedor update(Fornecedor intent) {
        /*findById(intent.getId())
                .ifPresent(fornecedor -> fornecedor.setNome(intent.getNome()));
        return this.findById(intent.getId()).get();*/
        return intent;
    }

    public Fornecedor create(Fornecedor candidate) {
        Long maxId = this.fornecedores.stream().max(Comparator.comparing(Fornecedor::getId)).map(Fornecedor::getId).orElse(0L);

        Fornecedor toPersist = Fornecedor.builder()
                .id(maxId + 1)
                .nome(candidate.getNome())
                .cnpj(candidate.getCnpj())
                .build();

//        this.fornecedores.add(toPersist);

        return toPersist;
    }
}
