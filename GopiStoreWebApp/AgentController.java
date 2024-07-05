package com.gopistore.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gopistore.dao.ProductMasterDAOEntity;
import com.gopistore.repo.impl.ProductMasterImpl;

import jakarta.servlet.http.HttpSession;


@Controller
public class AgentController 
{
	public static Logger logger=LoggerFactory.getLogger(ProductDisplayController.class);
	@Autowired
	private ProductMasterImpl productMasterImpl;
	@GetMapping("/agent")
	public String displayAgentConsole() 
	{
		return "agent";
	}
	@GetMapping("/home")
	public String returningToHomePage(Model model,HttpSession session)
	{
		logger.info("Entry into :: AgentController -> returningToHomePage()");
		model.addAttribute("products_list", session.getAttribute("productsList"));
		logger.info("Records from session" + (List<ProductMasterDAOEntity>) session.getAttribute("productsList"));
		return "ProductDisplay";

		// Implement the try catch blocks as well
		// Instead of loading from the database Need to add in the session
        
	}
	

}
