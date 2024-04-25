package com.verarc.insurancepolicy.dto;

import com.verarc.insurancepolicy.domain.PolicyStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraintvalidation.SupportedValidationTarget;
import lombok.Getter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
public class PolicyRequest {

    @NotBlank(message = "Policy name should have some value associated ")
    private String policyName;

    @NotBlank(message = "You need to provide policy status either ACTIVE/INACTIVE")
    private String status;

    @NotNull(message = "Start date should not be null")
    @FutureOrPresent(message = "Start Date should not be in past")
    private LocalDate coverageStartDate;

    @NotNull(message = "End date should not be null")
    @FutureOrPresent(message = "End Date should not be in past")
    private LocalDate coverageEndDate;

    @CreatedDate
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
