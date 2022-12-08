package org.sid.customerservice;

import org.sid.customerservice.Entities.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository,RepositoryRestConfiguration restConfiguration)
    {
		restConfiguration.exposeIdsFor(Customer.class);
    	return args->{
    		customerRepository.save(new Customer(null,"Anass","Anass@gmail.com"));
    		customerRepository.save(new Customer(null,"Youssra","youssra@gmail.com"));
    		customerRepository.save(new Customer(null,"Salma","salma@gmail.com"));
    		customerRepository.save(new Customer(null,"Taha","Taha@gmail.com"));
    		customerRepository.findAll().forEach(c->{
    			System.out.println(c.toString());
    		});
    	};
}
}
