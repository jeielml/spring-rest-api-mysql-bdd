package br.com.logonconsulting.erp.fornecedor.model;

import br.com.logonconsulting.erp.enterprise.LastModifiedAudit;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Table(name = "fornecedor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode(of = {"id"})
@EntityListeners(AuditingEntityListener.class)
public class Fornecedor extends LastModifiedAudit {

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

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private LocalDateTime createdDate;

}
