package com.verarc.insurancepolicy.services;

import com.verarc.insurancepolicy.InsurancePolicyApplication;
import com.verarc.insurancepolicy.comman.ErrorConstant;
import com.verarc.insurancepolicy.domain.InsurancePolicy;
import com.verarc.insurancepolicy.entity.InsurancePolicyDO;
import com.verarc.insurancepolicy.exception.ErrorDetails;
import com.verarc.insurancepolicy.exception.PolicyNotFoundException;
import com.verarc.insurancepolicy.mapper.InsurancePolicyMapper;
import com.verarc.insurancepolicy.repositories.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class InsurancePolicyServiceImp implements InsurancePolicyService {

    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;

    @Autowired
    private InsurancePolicyMapper insurancePolicyMapper;

    @Override
    public List<InsurancePolicy> fetchAllPolicies() {
        List<InsurancePolicyDO> policiesDO = insurancePolicyRepository.findAll();
        return insurancePolicyMapper.mapToPolicies(policiesDO);
    }

    @Override
    public InsurancePolicy createPolicy(InsurancePolicy newPolicy) {
        InsurancePolicyDO createdPolicy = insurancePolicyRepository.save(insurancePolicyMapper.mapToDO(newPolicy));
        InsurancePolicy policy = insurancePolicyMapper.mapToPolicy(createdPolicy);
        return policy;
    }

    @Override
    public InsurancePolicy fetchPolicyById(Integer id) {
        Optional<InsurancePolicyDO> policyDO = insurancePolicyRepository.findById(id);
        if (!policyDO.isPresent())
            throw new PolicyNotFoundException(ErrorConstant.policyNotFound);
        InsurancePolicy policy = insurancePolicyMapper.mapToPolicy(policyDO.get());
        return policy;
    }

    @Override
    public InsurancePolicy updatePolicy(InsurancePolicy updatedInsurancePolicy) {
        Optional<InsurancePolicyDO> policyDO = insurancePolicyRepository.findById(updatedInsurancePolicy.getPolicyId());
        if (!policyDO.isPresent()) {
            throw new PolicyNotFoundException(ErrorConstant.policyNotFound);
        }
        InsurancePolicyDO updatedPolicyDO = insurancePolicyRepository.save(insurancePolicyMapper.mapToDO(updatedInsurancePolicy));
        return insurancePolicyMapper.mapToPolicy(updatedPolicyDO);
    }

    @Override
    public void deletePolicy(Integer id) {
        Optional<InsurancePolicyDO> policyDO = insurancePolicyRepository.findById(id);
        if (!policyDO.isPresent())
            throw new PolicyNotFoundException(ErrorConstant.policyNotFound);
        insurancePolicyRepository.deleteById(id);
    }

}
