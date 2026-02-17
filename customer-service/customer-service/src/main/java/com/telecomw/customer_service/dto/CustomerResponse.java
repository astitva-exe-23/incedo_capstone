package com.telecomw.customer_service.dto;

public class CustomerResponse {

    private Long customerId;
    private String email;
    private Double walletBalance;

    // getters & setters

    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Double getWalletBalance() {
        return walletBalance;
    }
    public void setWalletBalance(Double walletBalance) {
        this.walletBalance = walletBalance;
    }
}
