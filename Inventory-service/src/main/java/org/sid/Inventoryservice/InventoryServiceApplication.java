package org.sid.Inventoryservice;

import org.sid.Inventoryservice.Entities.Product;
import org.sid.Inventoryservice.Repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
 
@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository,RepositoryRestConfiguration restConfiguration)
    {
		restConfiguration.exposeIdsFor(Product.class);
    	return args->{
    		productRepository.save(new Product(null,"Ordinateur",777,3000));
    		productRepository.save(new Product(null,"Souris",32,120));
    		productRepository.save(new Product(null,"Ecran",123,2340));
    		productRepository.save(new Product(null,"Clavier",234,345));
    		productRepository.findAll().forEach(p->{
    			System.out.println(p.getName());
    		});
    	};		
}
	}
