package com.verarc.insurancepolicy.mapper;


import com.verarc.insurancepolicy.domain.InsurancePolicy;
import com.verarc.insurancepolicy.dto.PolicyResponse;

import java.util.ArrayList;
import java.util.List;

public class ResponseMapper {
    public static PolicyResponse mapPolicyResponse(InsurancePolicy insurancePolicy){
        PolicyResponse policyResponse = new PolicyResponse();
        if(insurancePolicy != null){
            policyResponse.setPolicyId(insurancePolicy.getPolicyId());
            policyResponse.setPolicyName(insurancePolicy.getPolicyName());
            policyResponse.setStatus(insurancePolicy.getStatus());
            policyResponse.setCoverageStartDate(insurancePolicy.getCoverageStartDate());
            policyResponse.setCoverageEndDate(insurancePolicy.getCoverageEndDate());
            return policyResponse;
        } else{
            policyResponse.setError("Policy Not Found");
        }
        return policyResponse;
    }

    public static List<PolicyResponse> mapPolicyResponse(List<InsurancePolicy> insurancePolicies){
        List<PolicyResponse> policyResponses = new ArrayList<>();
        for(InsurancePolicy policy : insurancePolicies){
            policyResponses.add(mapPolicyResponse(policy));
        }
        return policyResponses;
    }


}
