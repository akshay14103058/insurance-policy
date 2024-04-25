package com.verarc.insurancepolicy.entity;

import com.verarc.insurancepolicy.domain.PolicyStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "Policies")
public class InsurancePolicyDO {

    @Id
    @GeneratedValue
    private Integer policyId;

    @NotNull
    private String  policyName;

    @NotNull
    private PolicyStatus status;

    @NotNull
    private LocalDate coverageStartDate;

    @NotNull
    private LocalDate coverageEndDate;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
