package com.telecomw.customer_service.services;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.telecomw.customer_service.config.JwtUtil;
import com.telecomw.customer_service.dto.CustomerProfileResponse;
import com.telecomw.customer_service.dto.CustomerResponse;
import com.telecomw.customer_service.dto.LoginRequest;
import com.telecomw.customer_service.dto.RegisterRequest;
import com.telecomw.customer_service.dto.WalletResponse;
import com.telecomw.customer_service.entity.Customer;
import com.telecomw.customer_service.exception.BadRequestException;
import com.telecomw.customer_service.exception.ResourceNotFoundException;
import com.telecomw.customer_service.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public CustomerServiceImpl(CustomerRepository repository,
                               PasswordEncoder passwordEncoder,
                               JwtUtil jwtUtil) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void register(RegisterRequest request) {
        if (repository.existsByEmail(request.getEmail())) {
            throw new BadRequestException("Email already registered");
        }

        Customer customer = new Customer(
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                0.0
        );

        repository.save(customer);
    }

    @Override
    public String login(LoginRequest request) {
        Customer customer = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        if (!passwordEncoder.matches(request.getPassword(), customer.getPassword())) {
            throw new BadRequestException("Invalid credentials");
        }

        return jwtUtil.generateToken(customer.getEmail());
    }

    @Override
    public CustomerResponse getCustomerById(Long customerId) {
        Customer customer = repository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        CustomerResponse response = new CustomerResponse();
        response.setCustomerId(customer.getId());
        response.setEmail(customer.getEmail());
        response.setWalletBalance(customer.getWalletBalance());

        return response;
    }

    @Override
    public WalletResponse getWallet(Long customerId) {
        Customer customer = repository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        return new WalletResponse(customer.getId(), customer.getWalletBalance());
    }

    @Override
    public void deductWallet(Long customerId, Double amount) {
        Customer customer = repository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        if (customer.getWalletBalance() < amount) {
            throw new BadRequestException("Insufficient wallet balance");
        }

        customer.setWalletBalance(customer.getWalletBalance() - amount);
        repository.save(customer);
    }

    @Override
    public CustomerProfileResponse getProfile(String email) {

        Customer customer = repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        CustomerProfileResponse response = new CustomerProfileResponse();
        response.setId(customer.getId());
        response.setEmail(customer.getEmail());
        response.setWalletBalance(customer.getWalletBalance());
        response.setCreatedAt(customer.getCreatedAt());

        return response;
    }
}
