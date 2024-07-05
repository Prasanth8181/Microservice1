package com.gopistore;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gopistore.repo.impl.ProductMasterImpl;

@Configuration
public class MvcConfig implements WebMvcConfigurer 
{
	public static final Logger logger=LoggerFactory.getLogger(ProductMasterImpl.class);
	  @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) 
	  {
		  logger.info("Entry into MvcConfig -> addResourceHandlers()");
	        exposeDirectory("user-photos", registry);
	    }
	     
	    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) 
	    {
	    	logger.info("Entry into MvcConfig -> exposeDirectory()");
	        Path uploadDir = Paths.get(dirName);
	        String uploadPath = uploadDir.toFile().getAbsolutePath();
	         
	        if (dirName.startsWith("../")) dirName = dirName.replace("../", "");
	         
	        registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/"+ uploadPath + "/");
	    }

}
