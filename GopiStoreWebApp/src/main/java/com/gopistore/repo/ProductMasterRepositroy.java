package com.gopistore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gopistore.dao.ProductMasterDAOEntity;

import jakarta.transaction.Transactional;
@Transactional
public interface ProductMasterRepositroy extends JpaRepository<ProductMasterDAOEntity, Integer>
{
	@Query(nativeQuery =true, value = "SELECT * FROM product_master WHERE product_category= :productCategory AND OUT_OF_STOCK='N'")
	public List<ProductMasterDAOEntity> getProductsByCategory(@Param("productCategory") String ProductCat);
	@Query(nativeQuery =true, value = "SELECT * FROM product_master WHERE product_category= :productCategory AND OUT_OF_STOCK='Y'")
	public List<ProductMasterDAOEntity> getOutOfStockProductsByCategory(@Param("productCategory") String ProductCat);
	
	@Modifying
	@Query(nativeQuery =true,value ="Update product_master pm SET pm.PRODUCT_NAME= ?1,pm.PRODUCT_PRICE=?2,pm.PRODUCT_CATEGORY=?3,pm.PRODUCT_DESCRIPTION=?4 WHERE pm.PRODUCT_ID=?5")
	public int updateProductMaster(String productName,int productPrice ,String productCategory,String productDescription,int productId);
	
	@Modifying
	@Query(nativeQuery =true,value ="Update product_master pm SET pm.OUT_OF_STOCK= ?1 WHERE pm.PRODUCT_ID=?2")
	public int UpdateOutOfStockRecord(String isOutOfStockint,int productId);
	
	@Modifying
	@Query(nativeQuery =true,value ="Update product_master pm SET pm.OUT_OF_STOCK='N' WHERE pm.PRODUCT_ID=?1")
	public int AddToStockFromOutOfStock(int productId);
}
