package com.verarc.insurancepolicy.mapper;

import com.verarc.insurancepolicy.domain.InsurancePolicy;
import com.verarc.insurancepolicy.dto.PolicyRequest;
import com.verarc.insurancepolicy.entity.InsurancePolicyDO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InsurancePolicyMapper {

    List<InsurancePolicy> mapToPolicies(List<InsurancePolicyDO> insurancePoliciesDO);
    InsurancePolicy mapToPolicy(InsurancePolicyDO insurancePolicyDO);
    InsurancePolicyDO mapToDO(InsurancePolicy insurancePolicy);
    InsurancePolicy mapRequestToPolicy(PolicyRequest request);
}