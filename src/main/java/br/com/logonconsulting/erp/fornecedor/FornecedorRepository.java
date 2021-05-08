package br.com.logonconsulting.erp.fornecedor;

import br.com.logonconsulting.erp.fornecedor.model.Fornecedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FornecedorRepository extends PagingAndSortingRepository<Fornecedor, Long> {

}
