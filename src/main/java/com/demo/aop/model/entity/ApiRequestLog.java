package com.demo.aop.model.entity;

import com.demo.aop.model.enums.ApiRequestLogStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "api_request_log")
public class ApiRequestLog extends AuditEntity {

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String payload;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ApiRequestLogStatus status;

    @Column
    private String errorMessage;
}
