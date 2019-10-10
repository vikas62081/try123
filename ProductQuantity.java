package com.virtusa.shoppersden.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product_Quantity")
public class ProductQuantity {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "Product_Qty_Id")
	private int productQtyId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Product_Id", nullable = false)
	private Product product;
	
	@Column(name = "Purchase_Quantity")
	private int purchaseQty;
	
	@Column(name = "Amount")
	private long amount;
	
	@ManyToOne
    	@JoinColumn(name="cart_id", nullable=false)
	private Cart cart;

	
	
	public int getProductQtyId() {
		return productQtyId;
	}

	public void setProductQtyId(int productQtyId) {
		this.productQtyId = productQtyId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getPurchaseQty() {
		return purchaseQty;
	}

	public void setPurchaseQty(int purchaseQty) {
		this.purchaseQty = purchaseQty;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

}
