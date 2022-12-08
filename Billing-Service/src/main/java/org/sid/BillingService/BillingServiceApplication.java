package org.sid.BillingService;

import java.util.Date;
import java.util.Random;

import org.sid.BillingService.Entities.Bill;
import org.sid.BillingService.Entities.ProductItem;
import org.sid.BillingService.Feign.CustomerRestClient;
import org.sid.BillingService.Feign.ProductItemRestClient;
import org.sid.BillingService.Repository.BillRepository;
import org.sid.BillingService.Repository.ProductItemRepository;
import org.sid.BillingService.model.Customer;
import org.sid.BillingService.model.Product;
import org.sid.billingservice.Repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.hateoas.PagedModel;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(
			RepositoryRestConfiguration restConfiguration,
			CustomerRestClient customerRestClient,
			ProductItemRestClient productItemRestClient,
			BillRepository billRepository,
			ProductItemRepository productItemRepository
	)
    {
    	return args->{
    		Customer customer= customerRestClient.getCustomerById(1L);
    		System.out.println("----------------------------------------------------");
    		System.out.println(customer.getId());
    		System.out.println(customer.getName());
    		System.out.println(customer.getEmail());
    		System.out.println("----------------------------------------------------");
    		Bill bill1 = billRepository.save(new Bill(null,new Date(),null, customer.getId(),null));
    		PagedModel<Product> productPagedModel = productItemRestClient.pageProducts(1, 1000);
    		productPagedModel.forEach(p->{
    			ProductItem productItem=new ProductItem(null, 0, 0, 0, bill1, p);
    			productItem.setPrice(p.getPrice());
    			productItem.setQuantity(1+new Random().nextInt(100));
    			productItem.setBill(bill1);
    			productItemRepository.save(productItem);
    		});
    	};
    	};

}
