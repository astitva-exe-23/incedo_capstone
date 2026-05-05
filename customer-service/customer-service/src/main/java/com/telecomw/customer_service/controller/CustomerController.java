package com.telecomw.customer_service.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telecomw.customer_service.config.JwtUtil;
import com.telecomw.customer_service.dto.ApiResponse;
import com.telecomw.customer_service.dto.CustomerProfileResponse;
import com.telecomw.customer_service.dto.CustomerResponse;
import com.telecomw.customer_service.dto.WalletResponse;
import com.telecomw.customer_service.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CustomerResponse>> getCustomer(
            @PathVariable Long id) {

        CustomerResponse response = customerService.getCustomerById(id);
        return ResponseEntity.ok(
                new ApiResponse<>(true, "Customer fetched successfully", response)
        );
    }

    @GetMapping("/{id}/wallet")
    public ResponseEntity<ApiResponse<WalletResponse>> getWallet(
            @PathVariable Long id) {

        WalletResponse wallet = customerService.getWallet(id);
        return ResponseEntity.ok(
                new ApiResponse<>(true, "Wallet fetched successfully", wallet)
        );
    }

    @PutMapping("/customers/{id}/wallet/deduct")
    public ResponseEntity<ApiResponse<Void>> deductWallet(
            @PathVariable Long id,
            @RequestParam Double amount) {

        customerService.deductWallet(id, amount);
        return ResponseEntity.ok(
                new ApiResponse<>(true, "Wallet deducted successfully", null)
        );
    }

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/profile")
    public ResponseEntity<CustomerProfileResponse> getProfile(
            @RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
        throw new RuntimeException("Missing or invalid Authorization header");
    }
        String token = authHeader.substring(7);
        String email = jwtUtil.extractEmail(token);

        return ResponseEntity.ok(customerService.getProfile(email));
    }
}

