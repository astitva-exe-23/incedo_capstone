package com.telecomw.portfolio_service.service;


import com.telecomw.portfolio_service.client.CustomerClient;
import com.telecomw.portfolio_service.client.InvestmentClient;
import com.telecomw.portfolio_service.client.TelecomClient;
import com.telecomw.portfolio_service.dto.CustomerDTO;
import com.telecomw.portfolio_service.dto.InvestmentSummaryDTO;
import com.telecomw.portfolio_service.dto.PortfolioResponse;
import com.telecomw.portfolio_service.dto.UsageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PortfolioService {
    private final CustomerClient customerClient;
    private final TelecomClient telecomClient;
    private final InvestmentClient investmentClient;

    public PortfolioResponse getPortfolio(Long customerId){
        CustomerDTO customer = customerClient.getCustomer(customerId);

        UsageDTO usage = telecomClient.getUsage(customerId);

        InvestmentSummaryDTO investment = investmentClient.getInvestmentSummary(customerId);

        return PortfolioResponse.builder()
                .customerName(customer.getName())
                .walletBalance(customer.getWalletBalance())
                .totalRecharge(usage.getTotalRecharge())
                .totalInvestment(investment.getTotalInvestment())
                .activePlans(investment.getActivePlans())
                .build();
    }
}
