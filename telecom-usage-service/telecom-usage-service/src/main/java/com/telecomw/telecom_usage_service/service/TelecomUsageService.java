package com.telecomw.telecom_usage_service.service;

import com.telecomw.telecom_usage_service.dto.RechargeRequestDTO;
import com.telecomw.telecom_usage_service.dto.UsageRequestDTO;
import com.telecomw.telecom_usage_service.dto.UsageSummaryDTO;

public interface TelecomUsageService {

    void rechargeWallet(RechargeRequestDTO request);

    void consumeUsage(UsageRequestDTO request);

    UsageSummaryDTO getUsageSummary(Long customerId);
}
