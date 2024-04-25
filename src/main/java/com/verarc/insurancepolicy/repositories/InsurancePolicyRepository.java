package com.verarc.insurancepolicy.repositories;


import com.verarc.insurancepolicy.entity.InsurancePolicyDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicyDO,Integer> {
}
