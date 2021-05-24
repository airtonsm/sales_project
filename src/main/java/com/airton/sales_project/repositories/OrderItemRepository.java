package com.airton.sales_project.repositories;

import com.airton.sales_project.entities.OrderItem;
import com.airton.sales_project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{



}
