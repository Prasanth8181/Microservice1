package com.gopistore;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class GopiStoreConfigurations 
{
	public static final Logger logger=LoggerFactory.getLogger(GopiStoreConfigurations.class);
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
	@Bean
	public DataLoader getDataLoader()
	{
		logger.info("Entry into the GopiStoreConfigurations -> getDataLoader()");
		return new DataLoader();
	}
	

}
