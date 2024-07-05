package com.gopistore.controllers;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gopistore.DataLoader;
import com.gopistore.DTO.ProductAddDTO;
import com.gopistore.DTO.ReturnResponseDTO;
import com.gopistore.dao.CategoryMasterDAOEntity;
import com.gopistore.dao.ProductMasterDAOEntity;
import com.gopistore.repo.impl.ProductMasterImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProductController
{
	public static Logger logger=LoggerFactory.getLogger(ProductController.class);
	public static final String outOfStock="N";
	public static final String Y="Y";
	public static final String N="N";
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ProductMasterImpl productMasterImpl;
	@Autowired
	private DataLoader dataLoader;
	
	@GetMapping("/AddProduct")
	public String addProduct(Model model)
	{
		logger.info("Entry into the ProductController -> addProduct()");
		ProductAddDTO productAddDTO=new ProductAddDTO();
		model.addAttribute("productAddDTOobj",productAddDTO);
		return "AddProduct";
	}
	@PostMapping("/signUpView")
	public String postAddProduct()
	{
		logger.info("Entry into the ProductController -> postAddProduct()");
		return null;
	}
	@GetMapping("/news")
	public String getStoreNews()
	{
		logger.info("Entry into the ProductController -> getStoreNews()");
		return "News";
	}
	@PostMapping("/PostAddProduct")
	public String postAddProduct(@Valid @ModelAttribute("productAddDTOobj") ProductAddDTO productAddDTO,@RequestParam("image") MultipartFile multipartFile,Model model) throws IOException
	{
		ReturnResponseDTO returnResponseDTO=new ReturnResponseDTO();
		try 
		{
			logger.info("Entry into the ProductController -> postAddProduct()");
			logger.info("ProdDesc " + productAddDTO.getProdDesc());
			logger.info("ProdName " + productAddDTO.getProdName());
			logger.info("ProdPrice " + productAddDTO.getProdPrice());
			logger.info("Prodcategory " + productAddDTO.getProdCategory());
			logger.info("ProdImage " + productAddDTO.getProdImage());

			logger.info("fileName::::" + multipartFile.getName());
			logger.info("fileSize::::" + multipartFile.getSize());
			logger.info("getOriginalFilename::::" + multipartFile.getOriginalFilename());
			logger.info("getContentType::::" + multipartFile.getContentType());
			logger.info("getBytes::::" + multipartFile.getBytes());

			ProductMasterDAOEntity productMasterDAOEntity = new ProductMasterDAOEntity();
			productMasterDAOEntity.setFileName(multipartFile.getOriginalFilename());
			productMasterDAOEntity.setFileType(multipartFile.getContentType());
			productMasterDAOEntity.setProdCategory(productAddDTO.getProdCategory());
			productMasterDAOEntity.setProdDesc(productAddDTO.getProdDesc());
			productMasterDAOEntity.setProdPrice(productAddDTO.getProdPrice());
			productMasterDAOEntity.setProdName(productAddDTO.getProdName());
			productMasterDAOEntity.setIsOutofStock(outOfStock);
			byte[] bytes = multipartFile.getBytes();
			byte[] encodeBase64 = Base64Utils.encode(bytes);
			String base64Encoded = new String(encodeBase64, "UTF-8");
			productMasterDAOEntity.setBase64EncodeImage(base64Encoded);
			logger.info("Encode Image:::" + base64Encoded);
			boolean isSaved=productMasterImpl.saveProducts(productMasterDAOEntity);
			if(isSaved)
			{
				returnResponseDTO.setProductName(productAddDTO.getProdName());
				returnResponseDTO.setSuccessMessage("Product added successfully");
				returnResponseDTO.setResponseCode(200);
				returnResponseDTO.setResponseMessage("Added to the stock");
				returnResponseDTO.setHasErrors(N);
			}
			else
			{
				returnResponseDTO.setProductName(productAddDTO.getProdName());
				returnResponseDTO.setSuccessMessage("Product not added due to some issue");
				returnResponseDTO.setResponseCode(400);
				returnResponseDTO.setResponseMessage("Please try again later or check with the developer");
				returnResponseDTO.setHasErrors(Y);
			}
		}
		catch(Exception e)
		{
			returnResponseDTO.setProductName(productAddDTO.getProdName());
			returnResponseDTO.setSuccessMessage("Product not added due to some issue");
			returnResponseDTO.setResponseCode(500);
			returnResponseDTO.setResponseMessage("Please try again later or check with the developer");
			returnResponseDTO.setHasErrors(Y);
			logger.info("Exception: ",e,e);
		}
		
		model.addAttribute("responseDTO",returnResponseDTO);
		return "ResultPage";
	}
	@GetMapping("/ContactUs")
	public String contactUs()
	{
		
		logger.info("Entry into the ProductController -> contactUs()");
		return "ContactUs";
	}
	@GetMapping("/Reports")
	public String reports()
	{
		logger.info("Entry into the ProductController -> contactUs()");
		return "Reports";
	}
	@GetMapping("/agent")
	public String agentCosoleDisplay()
	{
		logger.info("Entry into the ProductController -> agentCosoleDisplay()");
		return "agent";
	}
	@PostMapping("/postImageAdd")
	public String postImageAdd(@ModelAttribute("productAddDTOobj") ProductAddDTO productAddDTO, @RequestParam("image") MultipartFile multipartFile) throws IOException
	{
		logger.info("Entry into the ProductController -> postImageAdd()");
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		productAddDTO.setProdImage(fileName.getBytes());
		//model mapper
//		ProductMasterDAOEntity productMasterDAOEntity=modelMapper.map(productAddDTO, ProductMasterDAOEntity.class);
//		ProductMasterDAOEntity entity=productMasterImpl.saveProducts(productMasterDAOEntity);
//		String uploadDir = "user-photos/" + productMasterDAOEntity.getProdId();
	   // FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		/*logger.info(uploadDir);
		logger.info("Product Id"+entity.getProdId());
		logger.info("prod name:  "+entity.getProdName());
		logger.info("prod desc "+entity.getProdDesc());
		logger.info("ProdPrice "+entity.getProdPrice());
		logger.info("image "+entity.getProdImage());*/
		
		return "ResultPage";
	}
	@GetMapping("/UpdateProductsList")
	public String UpdateDeleteOutOfStockProductList(Model model)
	{
		logger.info("Entry into the ProductController -> UpdateDeleteOutOfStockProductList()");
		//List<ProductMasterDAOEntity> productsList=productMasterImpl.getRecordsByProductCategory("books");
		//Iterator<ProductMasterDAOEntity> it=productsList.iterator();
		List<CategoryMasterDAOEntity> list=dataLoader.categoryList;
		model.addAttribute("Product_categories_list",list);
		return "ProductsModuleList";
	}
	@GetMapping("/updateProductDetails")
	public String updateProductDetails(@RequestParam("productId") int prodId,@ModelAttribute("productAddDTOobj") ProductAddDTO productAddDTO,Model model,HttpSession session)
	{
		logger.info("Entry into the ProductController -> updateProductDetails()");
		logger.info("product Id: "+prodId);
		ProductMasterDAOEntity entity=productMasterImpl.findProductById(prodId);
		logger.info("Prod Name[ "+entity.getProdName()+"]");
		logger.info("Prod Category[ "+entity.getProdCategory()+"]");
		logger.info("Prod Price[ "+entity.getProdPrice()+"]");
		session.setAttribute("ProductID", prodId);
		productAddDTO.setProdName(entity.getProdName());
		productAddDTO.setProdCategory(entity.getProdCategory());
		productAddDTO.setProdPrice(entity.getProdPrice());
		productAddDTO.setProdDesc(entity.getProdDesc());
		
		return "UpdateProductDetails";
	}
	//DeleteProductsList
	@DeleteMapping("/deleteProduct")
	public String DeleteProductsList(@RequestParam("productId") int prodId)
	{
		logger.info("Entry into the ProductController -> DeleteProductsList()");
		//productMasterImpl.deleteProductById(prodId);
		return "ResultPage";
	}
	@GetMapping("/postProductCategoriesModulePage")
	public String postProductModulesCategories(@RequestParam("PoductCategory") String productCategory, Model model,HttpSession session)
	{
		logger.info("Entry into the ProductController -> postProductModulesCategories()");
		logger.info("Product category[ "+productCategory+" ]");
		List<ProductMasterDAOEntity> productMasterDAOEntities=productMasterImpl.getRecordsByProductCategory(productCategory);
		model.addAttribute("products_list",productMasterDAOEntities);
		return "UpdateDeleteOutOfStockProduct";
	}
	@PostMapping("/postUpdate")
	public String postUpdate(@ModelAttribute("productAddDTOobj") ProductAddDTO productAddDTO,HttpSession session,Model model)
	{
		logger.info("Entry into the ProductController -> postUpdate()");
		ReturnResponseDTO returnResponseDTO=new ReturnResponseDTO();
		logger.info("PORDUCT ID "+session.getAttribute("ProductID"));
		logger.info("Entry into the ProductController -> postProductModulesCategories()");
		logger.info(productAddDTO.getProdName());
		logger.info(productAddDTO.getProdCategory());
		logger.info(""+productAddDTO.getProdId());
		logger.info(productAddDTO.getProdDesc());
		boolean isUpdated=productMasterImpl.productUpdate(productAddDTO.getProdName()
				,productAddDTO.getProdPrice(),productAddDTO.getProdCategory(),productAddDTO.getProdDesc(),(int)session.getAttribute("ProductID"));
		if(isUpdated)
		{
			returnResponseDTO.setProductName(productAddDTO.getProdName());
			returnResponseDTO.setSuccessMessage("Product Updated successfully");
			returnResponseDTO.setResponseCode(200);
			returnResponseDTO.setResponseMessage("Added to the stock");
			returnResponseDTO.setHasErrors(N);
		}
		else
		{
			returnResponseDTO.setProductName(productAddDTO.getProdName());
			returnResponseDTO.setSuccessMessage("Product not Updated due to some issue");
			returnResponseDTO.setResponseCode(400);
			returnResponseDTO.setResponseMessage("Please try again later or check with the developer");
			returnResponseDTO.setHasErrors(Y);
		}
		model.addAttribute("responseDTO",returnResponseDTO);
		return "ResultPage";
	}
	@GetMapping("/outOfStockList")
	public String modulesListForAddUpdateOutOfStock(Model model)
	{
		logger.info("Entry into the ProductController -> outOfStockModuleList()");
		List<CategoryMasterDAOEntity> list=dataLoader.categoryList;
		model.addAttribute("Product_categories_list",list);
		return "ProductsModuleList";
	}
	///outOfStockPoduct
	@GetMapping("/outOfStockPoduct")
	public String updatingOutOfStock(@RequestParam("productId") int prodId ,@RequestParam("productName") String productName,Model model)
	{
		ReturnResponseDTO returnResponseDTO=new ReturnResponseDTO();
		logger.info("Entry into the ProductController -> updatingOutOfStock()");
		boolean isOutOfStockUpdated=productMasterImpl.outOfStockProductUpdate(Y, prodId);
		logger.info(isOutOfStockUpdated?"Record Updated":"Record Not Updated");
		if(isOutOfStockUpdated)
		{
			returnResponseDTO.setProductName(productName);
			returnResponseDTO.setSuccessMessage("Product added to the out of stock successfully");
			returnResponseDTO.setResponseCode(200);
			returnResponseDTO.setResponseMessage("Updated into the out of stock list");
			returnResponseDTO.setHasErrors(N);
		}
		else
		{
			returnResponseDTO.setProductName(productName);
			returnResponseDTO.setSuccessMessage("Product not added to the out of stock successfully");
			returnResponseDTO.setResponseCode(400);
			returnResponseDTO.setResponseMessage("Please try again later or check with the developer");
			returnResponseDTO.setHasErrors(Y);
		}
		model.addAttribute("responseDTO",returnResponseDTO);
		return "ResultPage";
	}
	@GetMapping("/outOfStockModules")
	public String outOfStockModuleList(Model model)
	{
		logger.info("Entry into the ProductController -> outOfStockModuleList()");
		List<CategoryMasterDAOEntity> list=dataLoader.categoryList;
		model.addAttribute("Product_categories_list",list);
		return "OutOfStockModulesList";
	}
	@GetMapping("/PreOutOfStockList")
	public String preOutOfStockList(@RequestParam("PoductCategory") String productCategory,Model model)
	{
		 logger.info("Entry into the ProductController -> preOutOfStockList()");
		 List<ProductMasterDAOEntity> list=productMasterImpl.getOutOfStockList(productCategory);
		 model.addAttribute("products_list",list);
		 return "OutOfStockList";
	}
	@GetMapping("/AddToStockFromOutOfStock")
	public String addToStockFromOutOfStock(@RequestParam("PoductID") int productId,@RequestParam("ProductName") String productName,Model model)
	{
		 ReturnResponseDTO returnResponseDTO=new ReturnResponseDTO();
		 logger.info("Entry into the ProductController -> addToStockFromOutOfStock()");
		 int value=productMasterImpl.addToStockFromOutOfStock(productId);
		 logger.info(value==1?"added to stock":"Not added");
		 if(value==1)
			{
				returnResponseDTO.setProductName(productName);
				returnResponseDTO.setSuccessMessage("Product added to the Stock from the out of stock successfully");
				returnResponseDTO.setResponseCode(200);
				returnResponseDTO.setResponseMessage("Updated into the stock");
				returnResponseDTO.setHasErrors(N);
			}
			else
			{
				returnResponseDTO.setProductName(productName);
				returnResponseDTO.setSuccessMessage("Product not added to the Stock from the out of stock due to some technical issues");
				returnResponseDTO.setResponseCode(400);
				returnResponseDTO.setResponseMessage("Please try again later or check with the developer");
				returnResponseDTO.setHasErrors(Y);
			}
		 model.addAttribute("responseDTO",returnResponseDTO);
		 return "ResultPage";
	}
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("productId") int productId,@RequestParam("productName") String ProductName,Model model)
	{
		 ReturnResponseDTO returnResponseDTO=new ReturnResponseDTO();
		 logger.info("Entry into the ProductController -> deleteProduct()");
		 logger.info(ProductName);
		 boolean result=productMasterImpl.deleteProductById(productId);
		 if(result)
		 {
			 returnResponseDTO.setProductName(ProductName);
			 returnResponseDTO.setSuccessMessage("Product Deleted successfully");
			 returnResponseDTO.setResponseCode(200);
			 returnResponseDTO.setResponseMessage("Removed from the stock");
			 returnResponseDTO.setHasErrors(N); 
		 }
		 else
		 {
			 returnResponseDTO.setProductName(ProductName);
			 returnResponseDTO.setSuccessMessage("Product deleted due to some issue");
			 returnResponseDTO.setResponseCode(400);
			 returnResponseDTO.setResponseMessage("Please try again later or check with the developer");
			 returnResponseDTO.setHasErrors(Y);
		 }
		  model.addAttribute("responseDTO", returnResponseDTO);
		 logger.info(result?"Deleted successfully":"Product Not deleted");
		 return "ResultPage";
	}
	@GetMapping("/backToProductModulesList")
	public String backToProductModulesList(Model model)
	{
		logger.info("Entry into the ProductController -> backToProductModulesList()");
		List<CategoryMasterDAOEntity> list=dataLoader.categoryList;
		model.addAttribute("Product_categories_list",list);
		return "ProductsModuleList";
	}
	

}
