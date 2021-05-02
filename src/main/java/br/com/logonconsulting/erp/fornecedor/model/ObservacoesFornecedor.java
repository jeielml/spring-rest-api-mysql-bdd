package br.com.logonconsulting.erp.fornecedor.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "observacoes_fornecedor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode(of = {"id"})
public class ObservacoesFornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String observacao;

}
