package com.telecomw.telecom_usage_service.controller;

import com.telecomw.telecom_usage_service.dto.*;
import com.telecomw.telecom_usage_service.service.TelecomUsageService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usage")
public class TelecomUsageController {

    private final TelecomUsageService telecomUsageService;

    public TelecomUsageController(TelecomUsageService telecomUsageService) {
        this.telecomUsageService = telecomUsageService;
    }

    @PostMapping("/recharge")
    public ResponseEntity<ApiResponse<Void>> recharge(
            @Valid @RequestBody RechargeRequestDTO request) {

        telecomUsageService.rechargeWallet(request);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Wallet recharged successfully", null)
        );
    }

    @PostMapping("/consume")
    public ResponseEntity<ApiResponse<Void>> consume(
            @Valid @RequestBody UsageRequestDTO request) {

        telecomUsageService.consumeUsage(request);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Usage recorded successfully", null)
        );
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<ApiResponse<UsageSummaryDTO>> getUsageSummary(
            @PathVariable Long customerId) {

        UsageSummaryDTO summary =
                telecomUsageService.getUsageSummary(customerId);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Usage summary fetched", summary)
        );
    }
}
