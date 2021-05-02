package br.com.logonconsulting.erp.fornecedor.model;

import lombok.*;

import javax.persistence.*;
import javax.sql.rowset.serial.SerialArray;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "fornecedor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode(of = {"id"})
public class Fornecedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(length = 14)
    private String cnpj;

    @Builder.Default
    private long criado_em = System.currentTimeMillis();

    @OneToMany
    @Singular(value = "obsercacao")
    private Set<ObservacoesFornecedor> obsercacoes;

}
