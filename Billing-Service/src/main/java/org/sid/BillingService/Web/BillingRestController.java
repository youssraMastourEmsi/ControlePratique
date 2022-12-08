package org.sid.BillingService.Web;

import org.sid.BillingService.Entities.Bill;
import org.sid.BillingService.Feign.CustomerRestClient;
import org.sid.BillingService.Feign.ProductItemRestClient;
import org.sid.BillingService.Repository.BillRepository;
import org.sid.BillingService.Repository.ProductItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingRestController {

	public BillingRestController(BillRepository billRepository, ProductItemRepository productItemRepository,
			CustomerRestClient customerRestClient, ProductItemRestClient productItemRestClient) {
		super();
		this.billRepository = billRepository;
		this.setProductItemRepository(productItemRepository);
		this.setCustomerRestClient(customerRestClient);
		this.setProductItemRestClient(productItemRestClient);
	}
	private BillRepository billRepository;
	private ProductItemRepository productItemRepository;
	private CustomerRestClient customerRestClient;
	private ProductItemRestClient productItemRestClient;
	@GetMapping(path="/fullBill/{id}")
	public Bill getBill(@PathVariable(name="id") Long id)
	{
		Bill bill=billRepository.findById(id).get();
		return bill;
	}
	public ProductItemRepository getProductItemRepository() {
		return productItemRepository;
	}
	public void setProductItemRepository(ProductItemRepository productItemRepository) {
		this.productItemRepository = productItemRepository;
	}
	public CustomerRestClient getCustomerRestClient() {
		return customerRestClient;
	}
	public void setCustomerRestClient(CustomerRestClient customerRestClient) {
		this.customerRestClient = customerRestClient;
	}
	public ProductItemRestClient getProductItemRestClient() {
		return productItemRestClient;
	}
	public void setProductItemRestClient(ProductItemRestClient productItemRestClient) {
		this.productItemRestClient = productItemRestClient;
	}
}
