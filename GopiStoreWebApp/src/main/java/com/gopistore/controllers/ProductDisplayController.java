package com.gopistore.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.gopistore.DataLoader;
import com.gopistore.dao.CategoryMasterDAOEntity;
import com.gopistore.dao.ProductMasterDAOEntity;
import com.gopistore.repo.impl.ProductMasterImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProductDisplayController 
{
	public static Logger logger=LoggerFactory.getLogger(ProductDisplayController.class);
	@Autowired
	private ProductMasterImpl productMasterImpl;
	@Autowired
	private DataLoader dataLoader;
	
	@GetMapping("/welcome")
	public String productDisplay(Model model,MultipartFile multipartFile,HttpSession session)
	{
		logger.info("Entry into :: ProductDisplayController -> productDisplay()");
		List<CategoryMasterDAOEntity> list=dataLoader.categoryList;
		logger.info("list"+list);
		//List<ProductMasterDAOEntity> productsList=productMasterImpl.getAllTheProducts();
		//model.addAttribute("products_list",productsList);
		//session.setAttribute("productsList", productsList);
		//logger.info("No of records["+productsList.size()+"]");
	
		return "Welcome";
	}
	@GetMapping("/productDisplay")
	public String productDisplayUsingCategory(@RequestParam("productCategory") String productCat,Model model)
	{
		logger.info("Entry into :: ProductDisplayController -> productDisplayUsingCategory()");
		logger.info("Product Category[ "+productCat+" ]");
		List<ProductMasterDAOEntity> productsList=productMasterImpl.getRecordsByProductCategory(productCat);
		model.addAttribute("products_list",productsList);
		return "ProductDisplay";
	}
}
