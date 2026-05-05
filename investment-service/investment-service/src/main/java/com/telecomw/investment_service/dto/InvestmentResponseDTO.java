package com.telecomw.investment_service.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class InvestmentResponseDTO {

    private Long id;
    private Long customerId;
    private Long planId;
    private Double amount;
    private LocalDateTime investmentDate;
    private String status;
}
