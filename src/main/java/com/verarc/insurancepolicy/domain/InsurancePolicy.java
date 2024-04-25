package com.verarc.insurancepolicy.domain;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
public class InsurancePolicy {

    private Integer policyId;

    @NotNull
    private String  policyName;

    @NotNull
    private PolicyStatus status;

    @NotNull
    private LocalDate coverageStartDate;

    @NotNull
    private LocalDate coverageEndDate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
