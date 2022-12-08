package org.sid.BillingService.Entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.sid.BillingService.model.Customer;

@Entity
public class Bill {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date billingDate;
	@OneToMany(mappedBy="bill", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Collection<ProductItem> productItems;
	private long customerID;
	@Transient
	private Customer customer;
	public Bill(Long id, Date billingDate, Collection<ProductItem> productItems, long customerID, Customer customer) {
		super();
		this.id = id;
		this.billingDate = billingDate;
		this.productItems = productItems;
		this.customerID = customerID;
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Bill [id=" + id + ", billingDate=" + billingDate + ", customerID="
				+ customerID + ", customer=" + customer.toString() + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}
	public Collection<ProductItem> getProductItems() {
		return productItems;
	}
	public void setProductItems(Collection<ProductItem> productItems) {
		this.productItems = productItems;
	}
	public long getCustomerID() {
		return customerID;
	}
	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
