package com.gopistore.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gopistore.dao.CategoryMasterDAOEntity;
import com.gopistore.dao.ProductMasterDAOEntity;

public interface CategoryMasterRepository extends JpaRepository<CategoryMasterDAOEntity, String>
{
	
}
