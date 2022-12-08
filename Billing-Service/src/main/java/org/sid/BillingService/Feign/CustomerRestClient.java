package org.sid.BillingService.Feign;

import org.sid.BillingService.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerRestClient {

	@GetMapping(path="/customers/{id}")
	public Customer getCustomerById(@PathVariable(name="id") Long id);
	
	
}
	 	