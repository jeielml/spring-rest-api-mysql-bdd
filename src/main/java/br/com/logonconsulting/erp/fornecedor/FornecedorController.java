package br.com.logonconsulting.erp.fornecedor;

import br.com.logonconsulting.erp.fornecedor.model.Fornecedor;
import br.com.logonconsulting.erp.fornecedor.representation.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {

    /**
     * É possível alternar entre FornecedorMockedRepository e o FornecedorRepository do MySQL
     *
     * @return
     */
    @Autowired
    private FornecedorRepository repository;
//    private FornecedorMockedRepository repository;

    @ResponseStatus(OK)
    @GetMapping
    public ResponseEntity<Page<FornecedorDto>> findAll(Pageable pageable) {
        Page<Fornecedor> fornecedorPage = this.repository.findAll(pageable);
        List<FornecedorDto> pageDto = fornecedorPage.getContent().stream().map(FornecedorDto::toRepresentation)
                .collect(Collectors.toUnmodifiableList());
        Page<FornecedorDto> pages
                = new PageImpl<>(pageDto, pageable, fornecedorPage.getTotalElements());
        return ResponseEntity.ok(pages);
    }

    @ResponseStatus(OK)
    @GetMapping("{id}")
    @NotFound(action = NotFoundAction.IGNORE)
    public ResponseEntity<FornecedorDto> find(@PathVariable("id") Long id) {
        return ResponseEntity.of(repository.findById(id)
                .map(FornecedorDto::toRepresentation));
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("{id}")
    @NotFound(action = NotFoundAction.IGNORE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("{id}")
    @NotFound(action = NotFoundAction.IGNORE)
    public ResponseEntity<FornecedorDto> update(@PathVariable("id") Long id, @RequestBody FornecedorUpdateIntent updateIntent) {
        Optional<FornecedorDto> body = repository.findById(id)
                .map(updateIntent::updateEntity)
                .map(repository::save)
                .map(FornecedorDto::toRepresentation);
        return ResponseEntity.of(body);
    }

    @PostMapping()
    @NotFound(action = NotFoundAction.IGNORE)
    public ResponseEntity<FornecedorDto> create(@RequestBody FornecedorCreateIntent createIntent) {
        Fornecedor candidate = createIntent.toEntity();
        Fornecedor persisted = repository.save(candidate);
        return ResponseEntity.ok(FornecedorDto.toRepresentation(persisted));
    }

    @PostMapping("{id}/observacao")
    @NotFound(action = NotFoundAction.IGNORE)
    public ResponseEntity<ObservacoesFornecedorDto> createObsercacao(@PathVariable("id") Long id, @RequestBody FornecedorUpdateIntent updateIntent) {
        Optional<ObservacoesFornecedorDto> body = repository.findById(id)
                .map(updateIntent::updateEntity)
                .map(repository::save)
                .map(ObservacoesFornecedorDto::toRepresentation);
        return ResponseEntity.of(body);
    }

    @PutMapping("{fornecedorId}/observacao/{obsercacaoId}")
    @NotFound(action = NotFoundAction.IGNORE)
    public ResponseEntity<ObservacoesFornecedorDto> updateObsercacao(@PathVariable("fornecedorId") Long fornecedorId,
                                                                     @PathVariable("obsercacaoId") Long obsercacaoId,
                                                                     @RequestBody ObsercacaoFornecedorUpdateIntent updateIntent) {
        Optional<ObservacoesFornecedorDto> body = repository.findById(fornecedorId)
                .map(fornecedor -> updateIntent.updateEntity(obsercacaoId, fornecedor))
                .map(repository::save)
                .map(ObservacoesFornecedorDto::toRepresentation);
        return ResponseEntity.of(body);
    }

    @DeleteMapping("{fornecedorId}/observacao/{obsercacaoId}")
    @NotFound(action = NotFoundAction.IGNORE)
    public ResponseEntity<ObservacoesFornecedorDto> updateObsercacao(@PathVariable("fornecedorId") Long fornecedorId,
                                                                     @PathVariable("obsercacaoId") Long obsercacaoId) {
        Optional<ObservacoesFornecedorDto> body = repository.findById(fornecedorId)
                .map(fornecedor -> ObsercacaoFornecedorDeleteIntent.updateEntity(obsercacaoId, fornecedor))
                .map(repository::save)
                .map(ObservacoesFornecedorDto::toRepresentation);
        return ResponseEntity.of(body);
    }

}
