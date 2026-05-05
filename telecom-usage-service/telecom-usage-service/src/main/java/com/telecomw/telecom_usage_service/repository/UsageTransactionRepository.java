package com.telecomw.telecom_usage_service.repository;

import com.telecomw.telecom_usage_service.entity.UsageTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsageTransactionRepository
        extends JpaRepository<UsageTransaction, Long> {

    List<UsageTransaction> findByCustomerId(Long customerId);
}
