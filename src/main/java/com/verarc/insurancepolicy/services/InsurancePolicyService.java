package com.verarc.insurancepolicy.services;

import com.verarc.insurancepolicy.domain.InsurancePolicy;
import com.verarc.insurancepolicy.exception.PolicyNotFoundException;

import java.util.List;

public interface InsurancePolicyService {
    List<InsurancePolicy> fetchAllPolicies();
    InsurancePolicy createPolicy(InsurancePolicy insurancePolicy);
    InsurancePolicy fetchPolicyById(Integer id) throws PolicyNotFoundException;
    InsurancePolicy updatePolicy(InsurancePolicy policy) throws PolicyNotFoundException;
    void deletePolicy(Integer id) throws PolicyNotFoundException;
}
