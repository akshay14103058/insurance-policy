package com.verarc.insurancepolicy.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.verarc.insurancepolicy.domain.PolicyStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class PolicyResponse {
    private Integer policyId;
    private String  policyName;
    private PolicyStatus status;
    private LocalDate coverageStartDate;
    private LocalDate coverageEndDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String error;
}
