package com.telecomw.investment_service.repository;

import com.telecomw.investment_service.entity.InvestmentPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvestmentPlanRepository extends JpaRepository<InvestmentPlan, Long> {

    Optional<InvestmentPlan> findByPlanName(String planName);
}

