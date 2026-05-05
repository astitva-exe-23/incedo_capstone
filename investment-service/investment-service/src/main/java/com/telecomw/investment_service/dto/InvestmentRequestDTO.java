package com.telecomw.investment_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InvestmentRequestDTO {

    @NotNull
    private Long customerId;

    @NotNull
    private Long planId;

    @NotNull
    @Min(1)
    private Double amount;
}
