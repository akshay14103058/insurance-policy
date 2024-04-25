package com.verarc.insurancepolicy.validations;

import com.verarc.insurancepolicy.comman.ErrorConstant;
import com.verarc.insurancepolicy.domain.PolicyStatus;
import com.verarc.insurancepolicy.dto.PolicyRequest;
import com.verarc.insurancepolicy.exception.EndDateIsSmallerThanStartException;
import com.verarc.insurancepolicy.exception.ErrorDetails;
import com.verarc.insurancepolicy.exception.NotValidValueException;
import org.springframework.stereotype.Component;


@Component
public class InsuranceValidation {
    public void validate(PolicyRequest request)  {
        try {
            Enum.valueOf(PolicyStatus.class,request.getStatus());
        } catch (Exception ex) {
            throw new NotValidValueException(ErrorConstant.notValidEnum);
        }
        if(!request.getCoverageEndDate().isAfter(request.getCoverageStartDate()))
            throw new EndDateIsSmallerThanStartException(ErrorConstant.notValidEndDate);
    }
}
