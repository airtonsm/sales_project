package com.airton.sales_project.resources;

import com.airton.sales_project.entities.Order;
import com.airton.sales_project.services.OrderService;
import com.airton.sales_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService service; // precisa está registrada como componente do spring

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){

        List<Order> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable  Long id){ // @PathVatiable traduz o Long id para a requisição http
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
