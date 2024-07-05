package com.gopistore.repo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gopistore.dao.ProductMasterDAOEntity;
import com.gopistore.repo.CategoryMasterRepository;
import com.gopistore.repo.ProductMasterRepositroy;
//import com.studentapi.service.impl.StudentServiceImpl;

@Repository
public class ProductMasterImpl 
{
	public static final Logger logger=LoggerFactory.getLogger(ProductMasterImpl.class);
	@Autowired
	private ProductMasterRepositroy productMasterRepositroy;
	
	public List<ProductMasterDAOEntity> getAllTheProducts()
	{
		logger.info("Entry into :: ProductMasterImpl-->getAllTheProducts()");
		return productMasterRepositroy.findAll();
	}
	public boolean saveProducts(ProductMasterDAOEntity productMasterDAOEntity)
	{
		logger.info("Entry into :: ProductMasterImpl-->saveProducts()");
		boolean isSaved=false;
		try
		{
		  productMasterRepositroy.save(productMasterDAOEntity);
		  isSaved=true;
		}
		catch(Exception e)
		{
			logger.error("Exception",e,e);
		}
		return isSaved;
	}
	public List<ProductMasterDAOEntity> getRecordsByProductCategory(String prodCat)
	{
		logger.info("Entry into :: ProductMasterImpl-->getProductsByCategory()");
		List<ProductMasterDAOEntity> productMasterDAOEntity=productMasterRepositroy.getProductsByCategory(prodCat);
		return productMasterDAOEntity;
	}
	public ProductMasterDAOEntity findProductById(int productId)
	{
		logger.info("Entry into :: ProductMasterImpl-->getProductsByCategory()");
		ProductMasterDAOEntity productMasterDAOEntity=productMasterRepositroy.findById(productId).get();
		return productMasterDAOEntity;
	}
	public boolean productUpdate(String productName,int productPrice,String productCategory,String productDescription,int productId)
	{
		logger.info("Entry into :: ProductMasterImpl-->productUpdate()");
		boolean isUpdate=false;
		try
		{
			int result=productMasterRepositroy.updateProductMaster(productName,productPrice,productCategory,productDescription,productId);
			isUpdate=true;
			logger.info("Is Updated "+isUpdate+" "+result);
		}
		catch(Exception e)
		{
			logger.error("Exception: ",e,e);
			isUpdate=false;
		}
		return isUpdate;
	}
	public boolean outOfStockProductUpdate(String isOutOfStock,int productId)
	{
		logger.info("Entry into :: ProductMasterImpl-->outOfStockProductUpdate()");
		boolean isUpdate=false;
		try
		{
			int result=productMasterRepositroy.UpdateOutOfStockRecord(isOutOfStock,productId);
			isUpdate=true;
			logger.info("Is Updated "+isUpdate+" "+result);
		}
		catch(Exception e)
		{
			logger.error("Exception: ",e,e);
			isUpdate=false;
		}
		return isUpdate;
	}
	public List<ProductMasterDAOEntity> getOutOfStockList(String productCategory)
	{
		logger.info("Entry into :: ProductMasterImpl-->getOutOfStockList()");
		return productMasterRepositroy.getOutOfStockProductsByCategory(productCategory);
	}
	public int addToStockFromOutOfStock(int productId)
	{
		logger.info("Entry into :: ProductMasterImpl-->getOutOfStockList()");
		int result=productMasterRepositroy.AddToStockFromOutOfStock(productId);
		return result;
	}
	public boolean deleteProductById(int productId)
	{
		logger.info("Entry into :: ProductMasterImpl-->deleteProductById()");
		boolean isUpdate=false;
		try
		{
			productMasterRepositroy.deleteById(productId);
			isUpdate=true;
		}
		catch(Exception e)
		{
			logger.error("Exception: ",e,e);
			isUpdate=false;
		}
		
		return isUpdate;
	}
}
