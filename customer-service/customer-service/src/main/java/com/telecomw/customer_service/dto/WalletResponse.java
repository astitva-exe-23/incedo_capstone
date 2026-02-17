package com.telecomw.customer_service.dto;

public class WalletResponse {

    private Long customerId;
    private Double walletBalance;

    public WalletResponse() {}

    public WalletResponse(Long customerId, Double walletBalance) {
        this.customerId = customerId;
        this.walletBalance = walletBalance;
    }

    // getters & setters

    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public Double getWalletBalance() {
        return walletBalance;
    }
    public void setWalletBalance(Double walletBalance) {
        this.walletBalance = walletBalance;
    }
}
