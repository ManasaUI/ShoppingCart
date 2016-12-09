package com.cart.dto;

public class Product {

	private int productId;
	private String productName;
	private String productDesc;
	private float productPrice;
	private String image;
	private String Category;
	
	
	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductDesc() {
		return productDesc;
	}


	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}


	public float getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getCategory() {
		return Category;
	}


	public void setCategory(String category) {
		Category = category;
	}


	
	
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", productDesc="
				+ productDesc + ", productPrice=" + productPrice + ", image="
				+ image + "]";
	}

}
