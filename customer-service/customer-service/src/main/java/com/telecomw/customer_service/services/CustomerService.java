package com.telecomw.customer_service.services;
import com.telecomw.customer_service.dto.CustomerProfileResponse;
import com.telecomw.customer_service.dto.CustomerResponse;
import com.telecomw.customer_service.dto.LoginRequest;
import com.telecomw.customer_service.dto.RegisterRequest;
import com.telecomw.customer_service.dto.WalletResponse;

public interface CustomerService {

    void register(RegisterRequest request);

    String login(LoginRequest request);

    CustomerResponse getCustomerById(Long customerId);

    WalletResponse getWallet(Long customerId);

    void deductWallet(Long customerId, Double amount);

    CustomerProfileResponse getProfile(String email);
}
