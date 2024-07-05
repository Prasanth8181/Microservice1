package com.gopistore.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ProductAddDTO 
{
	private int prodId;
	@NotEmpty(message = "* Product name can not be blank")
	private String prodName;
	@NotBlank(message = "* Product price can not be blank")
	private int prodPrice;
	@NotBlank(message = "* Product description can not be blank")
	private String prodDesc;
	@NotBlank(message = "* Product category can not be blank")
	private String prodCategory;
	private byte[] prodImage;
	
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getProdDesc() {
		return prodDesc;
	}
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	public String getProdCategory() {
		return prodCategory;
	}
	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}
	public byte[] getProdImage() {
		return prodImage;
	}
	public void setProdImage(byte[] prodImage) {
		this.prodImage = prodImage;
	}
	
	
	
	

	
	
	

}
