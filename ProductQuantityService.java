package com.virtusa.shoppersden.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.virtusa.shoppersden.models.Cart;
import com.virtusa.shoppersden.models.Product;
import com.virtusa.shoppersden.models.ProductQuantity;
import com.virtusa.shoppersden.repository.ProductQuantityRepository;

@Service
public class ProductQuantityService {

	@Autowired
	private ProductQuantityRepository productQtyRepository;
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductService productService;
	public List<ProductQuantity> getAllProductQuantities() {
		return productQtyRepository.findAll();
	}

	public ProductQuantity getProductQuantityById(int productQtyId)
	{
		return productQtyRepository.findById(productQtyId).orElse(null);
	}
	public ProductQuantity addProductQuantity(long phoneNumber,int productId) {
		Cart cart=cartService.getCartByUserId(phoneNumber);
		Product product=productService.findProductById(productId);
		ProductQuantity productQty=productQtyRepository.isProductExist(cart, product);
		if(productQty==null)
		{
			productQty=new ProductQuantity();
			productQty.setPurchaseQty(1);
			productQty.setCart(cart);
			productQty.setProduct(product);
			productQty.setAmount(product.getPrice());
		}
		else
		{
			productQty.setPurchaseQty(productQty.getPurchaseQty()+1);
		}
		cart.setTotalAmount(cart.getTotalAmount()+product.getPrice());
		cartService.updateCart(cart);
		return productQtyRepository.save(productQty);
	}

	public void deleteProductQuantity(int productQtyId,long phoneNumber) {
		Cart cart=cartService.getCartByUserId(phoneNumber);
		ProductQuantity productQuantity=getProductQuantityById(productQtyId);
		cart.setTotalAmount(cart.getTotalAmount()-(productQuantity.getPurchaseQty()*productQuantity.getAmount()));
		productQtyRepository.deleteById(productQtyId);
	}
	
}
