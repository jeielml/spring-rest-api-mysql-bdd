package br.com.logonconsulting.erp.enterprise;

import lombok.Getter;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class LastModifiedAudit {

    @LastModifiedBy
    private String lastModifiedBy;

    @Getter
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

}
