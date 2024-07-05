package com.gopistore;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gopistore.dao.CategoryMasterDAOEntity;
import com.gopistore.repo.CategoryMasterRepository;

@Component
public class DataLoader implements CommandLineRunner
{
	public static final Logger logger=LoggerFactory.getLogger(CommandLineRunner.class);
	@Autowired
	private CategoryMasterRepository categoryMasterRepository;
	public static List<CategoryMasterDAOEntity> categoryList;
	@Override
	public void run(String... args) throws Exception
	{
		logger.info("Entry into the DataLoader -> run");
		categoryList=categoryMasterRepository.findAll();
	}
	

}
