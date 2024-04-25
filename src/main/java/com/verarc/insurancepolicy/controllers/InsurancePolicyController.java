package com.verarc.insurancepolicy.controllers;

import com.verarc.insurancepolicy.domain.InsurancePolicy;
import com.verarc.insurancepolicy.dto.PolicyRequest;
import com.verarc.insurancepolicy.dto.PolicyResponse;
import com.verarc.insurancepolicy.mapper.InsurancePolicyMapper;
import com.verarc.insurancepolicy.mapper.ResponseMapper;
import com.verarc.insurancepolicy.services.InsurancePolicyServiceImp;
import com.verarc.insurancepolicy.validations.InsuranceValidation;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InsurancePolicyController {
    @Autowired
    private InsurancePolicyServiceImp insurancePolicyService;
    @Autowired
    private InsurancePolicyMapper insurancePolicyMapper;

    @Autowired
    private InsuranceValidation insuranceValidation;

    @GetMapping(path = "/policies")
    public ResponseEntity<List<PolicyResponse>> fetchPolicies() {
        List<InsurancePolicy> policies = insurancePolicyService.fetchAllPolicies();
        return new ResponseEntity<>(ResponseMapper.mapPolicyResponse(policies), HttpStatus.OK);
    }

    @GetMapping(path = "/policies/{policyId}")
    public ResponseEntity<Object> fetchPolicy(@PathVariable("policyId") Integer policyId) {
        return new ResponseEntity<>(ResponseMapper.mapPolicyResponse(insurancePolicyService.fetchPolicyById(policyId)), HttpStatus.OK);
    }

    @PostMapping(path = "/policies")
    public ResponseEntity<PolicyResponse> createPolicy(@RequestBody @Valid PolicyRequest request) {
        insuranceValidation.validate(request);
        InsurancePolicy policy = insurancePolicyService.createPolicy(insurancePolicyMapper.mapRequestToPolicy(request));
        PolicyResponse response = ResponseMapper.mapPolicyResponse(policy);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(path = "/policies/{policyId}")
    public ResponseEntity<Object> updatePolicy(@RequestBody @Valid PolicyRequest request, @PathVariable(value = "policyId") Integer policyId) {
        insuranceValidation.validate(request);
        InsurancePolicy modifiedPolicy = insurancePolicyMapper.mapRequestToPolicy(request);
        modifiedPolicy.setPolicyId(policyId);
        return new ResponseEntity<>(ResponseMapper.mapPolicyResponse(insurancePolicyService.updatePolicy(modifiedPolicy)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/policies/{policyId}")
    public HttpStatus deletePolicy(@PathVariable(value = "policyId") Integer policyId) {
        insurancePolicyService.deletePolicy(policyId);
        return HttpStatus.OK;
    }


}
