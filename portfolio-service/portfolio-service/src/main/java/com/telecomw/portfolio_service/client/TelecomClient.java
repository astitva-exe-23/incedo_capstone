package com.telecomw.portfolio_service.client;


import com.telecomw.portfolio_service.dto.UsageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//TELLING THIS TO TALK TO THIS SERVICE SPECIFIED.
@FeignClient(name="telecom-usage-service")
public interface TelecomClient {

    @GetMapping("usage/{customerId}")
    UsageDTO getUsage(@PathVariable Long customerId);
}
