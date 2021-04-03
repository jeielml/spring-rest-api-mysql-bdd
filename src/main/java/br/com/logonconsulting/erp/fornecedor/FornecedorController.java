package br.com.logonconsulting.erp.fornecedor;

import br.com.logonconsulting.erp.enterprise.RecordNotFoundException;
import br.com.logonconsulting.erp.fornecedor.model.Fornecedor;
import br.com.logonconsulting.erp.fornecedor.representation.FornecedorCreateIntent;
import br.com.logonconsulting.erp.fornecedor.representation.FornecedorDto;
import br.com.logonconsulting.erp.fornecedor.representation.FornecedorUpdateIntent;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {

    @Autowired
    //TODO: replace my private FornecedorRepository repository;
    private FornecedorMockedRepository repository;


    @GetMapping
    public List<FornecedorDto> findAll() {
        return this.repository.findAll()
                .stream()
                .map(FornecedorDto::toRepresentation)
                .collect(Collectors.toUnmodifiableList());
    }

    @GetMapping("{id}")
    @NotFound(action = NotFoundAction.IGNORE)
    public FornecedorDto find(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(FornecedorDto::toRepresentation)
                .orElseThrow(() -> new RecordNotFoundException("This producer does not exists!"));
    }

    @PutMapping("{id}")
    @NotFound(action = NotFoundAction.IGNORE)
    public FornecedorDto update(@PathVariable("id") Long id, @RequestBody FornecedorUpdateIntent updateIntent) {
        return repository.findById(id)
                .map(fornecedor -> {
                    updateIntent.updateEntity(fornecedor);
                    return repository.update(fornecedor);
                })
                .map(FornecedorDto::toRepresentation)
                .orElseThrow(() -> new RecordNotFoundException("Este fornecedor não existe!"));
    }

    @PostMapping()
    @NotFound(action = NotFoundAction.IGNORE)
    public FornecedorDto create(@RequestBody FornecedorCreateIntent createIntent) {
        Fornecedor candidate = createIntent.toEntity();
        Fornecedor persisted = repository.create(candidate);
        return FornecedorDto.toRepresentation(persisted);
    }


}
