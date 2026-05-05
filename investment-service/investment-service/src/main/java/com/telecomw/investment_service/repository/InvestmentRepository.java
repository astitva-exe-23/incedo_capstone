package com.telecomw.investment_service.repository;

import com.telecomw.investment_service.entity.Investment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {

    List<Investment> findByCustomerId(Long customerId);
}

