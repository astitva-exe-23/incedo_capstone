package com.telecomw.telecom_usage_service.service;

import com.telecomw.telecom_usage_service.client.CustomerClient;
import com.telecomw.telecom_usage_service.dto.RechargeRequestDTO;
import com.telecomw.telecom_usage_service.dto.UsageRequestDTO;
import com.telecomw.telecom_usage_service.dto.UsageSummaryDTO;
import com.telecomw.telecom_usage_service.entity.RechargeTransaction;
import com.telecomw.telecom_usage_service.entity.UsageTransaction;
import com.telecomw.telecom_usage_service.repository.RechargeTransactionRepository;
import com.telecomw.telecom_usage_service.repository.UsageTransactionRepository;
import com.telecomw.telecom_usage_service.exception.CustomerServiceUnavailableException;
import com.telecomw.telecom_usage_service.exception.InsufficientBalanceException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelecomUsageServiceImpl implements TelecomUsageService {

    private final RechargeTransactionRepository rechargeRepo;
    private final UsageTransactionRepository usageRepo;
    private final CustomerClient customerClient;

    public TelecomUsageServiceImpl(RechargeTransactionRepository rechargeRepo,
                                   UsageTransactionRepository usageRepo,
                                   CustomerClient customerClient) {
        this.rechargeRepo = rechargeRepo;
        this.usageRepo = usageRepo;
        this.customerClient = customerClient;
    }

    @Override
    public void rechargeWallet(RechargeRequestDTO request) {
        RechargeTransaction tx = new RechargeTransaction();
        tx.setCustomerId(request.getCustomerId());
        tx.setAmount(request.getAmount());
        tx.setStatus("SUCCESS");

        rechargeRepo.save(tx);
    }

    @Override
    public void consumeUsage(UsageRequestDTO request) {
        try {
            customerClient.deductWallet(
                    request.getCustomerId(),
                    request.getUsageAmount()
            );
        } catch (Exception ex) {
            throw new CustomerServiceUnavailableException(
                    "Failed to deduct wallet balance");
        }

        UsageTransaction usage = new UsageTransaction();
        usage.setCustomerId(request.getCustomerId());
        usage.setUsageAmount(request.getUsageAmount());
        usage.setDescription(request.getDescription());

        usageRepo.save(usage);
    }

    @Override
    public UsageSummaryDTO getUsageSummary(Long customerId) {

        List<RechargeTransaction> recharges =
                rechargeRepo.findByCustomerId(customerId);

        List<UsageTransaction> usages =
                usageRepo.findByCustomerId(customerId);

        double totalRecharged = recharges.stream()
                .mapToDouble(RechargeTransaction::getAmount)
                .sum();

        double totalUsed = usages.stream()
                .mapToDouble(UsageTransaction::getUsageAmount)
                .sum();

        UsageSummaryDTO summary = new UsageSummaryDTO();
        summary.setCustomerId(customerId);
        summary.setTotalRecharged(totalRecharged);
        summary.setTotalUsed(totalUsed);

        return summary;
    }
}
