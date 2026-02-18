package com.telecomw.portfolio_service.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PortfolioResponse {
    private String customerName;
    private Double walletBalance;
    private Double totalRecharge;
    private Double totalInvestment;
    private Integer activePlans;
}
