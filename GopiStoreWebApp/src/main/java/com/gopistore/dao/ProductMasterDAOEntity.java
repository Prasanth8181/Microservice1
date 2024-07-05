package com.gopistore.dao;

import java.sql.Blob;

import org.springframework.data.annotation.Transient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "product_master")
public class ProductMasterDAOEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID",nullable = false,unique = true)
	private int prodId;
	@Column(name="PRODUCT_NAME",nullable = false)
	private String prodName;
	/*
	 * @Column(name="PRODUCT_IMAGE",nullable = true,length = 65555)
	 * 
	 * @Lob private byte[] prodImage;
	 */
	@Column(name="PRODUCT_PRICE",nullable = false)
	private int prodPrice;
	@Column(name="PRODUCT_CATEGORY", nullable=false)
	private String prodCategory;
	@Column(name="PRODUCT_DESCRIPTION",nullable = false)
	private String prodDesc;
	@Column(name="IMAGE_NAME")
	private String fileName;
	@Column(name="IMAGE_TYPE")
	private String fileType;
	@Column(name="base64EncodeImage",length = 65555)
	private String base64EncodeImage;
	@Column(name="OUT_OF_STOCK")
	private String isOutofStock;
	
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

	/*
	 * public byte[] getProdImage() { return prodImage; } public void
	 * setProdImage(byte[] prodImage) { this.prodImage = prodImage; }
	 */
	public String getProdCategory() {
		return prodCategory;
	}
	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getBase64EncodeImage() {
		return base64EncodeImage;
	}
	public void setBase64EncodeImage(String base64EncodeImage) {
		this.base64EncodeImage = base64EncodeImage;
	}
	public String getIsOutofStock() {
		return isOutofStock;
	}
	public void setIsOutofStock(String isOutofStock) {
		this.isOutofStock = isOutofStock;
	}
	
	
	
	
	
}
