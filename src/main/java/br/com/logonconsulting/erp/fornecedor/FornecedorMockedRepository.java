package br.com.logonconsulting.erp.fornecedor;

import br.com.logonconsulting.erp.fornecedor.model.Fornecedor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FornecedorMockedRepository {

    private List<Fornecedor> fornecedores = Arrays.asList(Fornecedor.builder().id(1l).nome("jeiel").cnpj("").build());

    public Iterable<Fornecedor> findAllById(Iterable<Long> longs) {
        return null;
    }

    public long count() {
        return fornecedores.size();
    }

    public void deleteById(Long id) {
        this.findById(id)
                .ifPresent(this::delete);
    }

    public void delete(Fornecedor entity) {
        this.fornecedores.remove(entity);
    }

    public void deleteAll(Iterable<? extends Fornecedor> entities) {
        entities.forEach(this::delete);
    }

    public void deleteAll() {
        fornecedores.clear();
    }

    public Iterable<Fornecedor> saveAll(Iterable<Fornecedor> entities) {
        return StreamSupport.stream(entities.spliterator(), false)
                .map(this::save)
                .collect(Collectors.toUnmodifiableList());

    }

    public Optional<Fornecedor> findById(Long id) {
        return this.fornecedores.stream().filter(fornecedor -> fornecedor.getId().equals(id)).findFirst();
    }


    public boolean existsById(Long id) {
        return this.fornecedores.stream().anyMatch(fornecedor -> fornecedor.getId().equals(id));
    }

    public Iterable<Fornecedor> findAll() {
        return fornecedores;
    }


    public Fornecedor save(Fornecedor canidate) {
        return Objects.isNull(canidate.getId()) ? create(canidate) : update(canidate);
    }


    private Fornecedor update(Fornecedor intent) {
        /*findById(intent.getId())
                .ifPresent(fornecedor -> fornecedor.setNome(intent.getNome()));
        return this.findById(intent.getId()).get();*/
        return intent;
    }

    private Fornecedor create(Fornecedor candidate) {
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
