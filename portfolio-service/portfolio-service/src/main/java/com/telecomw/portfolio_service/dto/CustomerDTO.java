package com.telecomw.portfolio_service.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private Double walletBalance;
}
