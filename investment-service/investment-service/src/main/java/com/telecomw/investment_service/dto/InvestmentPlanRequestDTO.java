package com.telecomw.investment_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InvestmentPlanRequestDTO {

    @NotBlank
    private String planName;

    @NotNull
    @Min(1)
    private Double minAmount;

    @NotNull
    @Min(0)
    private Double interestRate;

    @NotNull
    @Min(1)
    private Integer durationMonths;
}
