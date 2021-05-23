package com.airton.sales_project.repositories;

import com.airton.sales_project.entities.Category;
import com.airton.sales_project.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{



}
