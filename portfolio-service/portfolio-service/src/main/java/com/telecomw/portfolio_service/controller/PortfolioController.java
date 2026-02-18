package com.telecomw.portfolio_service.controller;


import com.telecomw.portfolio_service.dto.PortfolioResponse;
import com.telecomw.portfolio_service.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio")
@RequiredArgsConstructor
public class PortfolioController {
    private final PortfolioService portfolioService;

    @GetMapping("/{customerId}")
    public PortfolioResponse getPortfolio(@PathVariable Long customerId){
        return portfolioService.getPortfolio(customerId);
    }
}
