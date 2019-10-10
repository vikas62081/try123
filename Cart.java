package com.virtusa.shoppersden.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cart")
public class Cart  {

	@Id
	@Column(name="Cart_Id")
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int cartId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="User_Id",nullable = false)
	private User user;

	@Column(name = "Total_Amount")
	private long totalAmount;
	
	@OneToMany(mappedBy="cart",cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	private List<ProductQuantity> productQty;

	public long getTotalAmount() {
		return totalAmount; 
	}

	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ProductQuantity> getProductQty() {
		return productQty;
	}

	public void setProductQty(List<ProductQuantity> productQty) {
		this.productQty = productQty;
	}

}
