package com.airton.sales_project.repositories;

import com.airton.sales_project.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>{



}
