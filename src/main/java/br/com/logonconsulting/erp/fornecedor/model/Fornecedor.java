package br.com.logonconsulting.erp.fornecedor.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "fornecedor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
@EqualsAndHashCode(of = {"id"})
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String nome;

    @Column(length = 14)
    private String cnpj;
}
