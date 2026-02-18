package com.telecomw.investment_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "investment_plans")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvestmentPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String planName;

    @Column(nullable = false)
    private Double minAmount;

    @Column(nullable = false)
    private Double interestRate;

    @Column(nullable = false)
    private Integer durationMonths;
}