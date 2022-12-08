package org.sid.BillingService.Entities;

import org.sid.BillingService.model.Product;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class ProductItem {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private double quantity;
	private double price;
	private long productID;
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	@ManyToOne
	private Bill bill;
	@Transient
	private Product product;
   @Override
	public String toString() {
		return "ProductItem [id=" + id + ", quantity=" + quantity + ", price=" + price + ", productID=" + productID
				+ ", bill=" + bill.toString() + ", product=" + product.toString() + "]";
	}
	public ProductItem(Long id, double quantity, double price, long productID, Bill bill, Product product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.productID = productID;
		this.bill = bill;
		this.product = product;
	}
	public void setPrice(double price2) {
		// TODO Auto-generated method stub
		
	}
	public void setQuantity(int i) {
		// TODO Auto-generated method stub
		
	}
	public void setBill(Bill bill1) {
		// TODO Auto-generated method stub
		
	}
}
