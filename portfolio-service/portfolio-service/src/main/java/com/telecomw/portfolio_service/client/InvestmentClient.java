package com.telecomw.portfolio_service.client;


import com.telecomw.portfolio_service.dto.InvestmentSummaryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="investment-service")
public interface InvestmentClient {

    @GetMapping("/investments/{customerId}")
    InvestmentSummaryDTO getInvestmentSummary(@PathVariable Long customerId);
}
