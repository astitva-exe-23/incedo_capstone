package com.telecomw.telecom_usage_service.dto;

public class UsageSummaryDTO {

    private Long customerId;
    private Double totalRecharged;
    private Double totalUsed;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Double getTotalRecharged() {
        return totalRecharged;
    }

    public void setTotalRecharged(Double totalRecharged) {
        this.totalRecharged = totalRecharged;
    }

    public Double getTotalUsed() {
        return totalUsed;
    }

    public void setTotalUsed(Double totalUsed) {
        this.totalUsed = totalUsed;
    }
}
