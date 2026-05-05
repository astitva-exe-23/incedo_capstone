package com.telecomw.telecom_usage_service.repository;

import com.telecomw.telecom_usage_service.entity.RechargeTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RechargeTransactionRepository
        extends JpaRepository<RechargeTransaction, Long> {

    List<RechargeTransaction> findByCustomerId(Long customerId);
}
