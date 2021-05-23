package com.airton.sales_project.resources;

import com.airton.sales_project.entities.Product;
import com.airton.sales_project.services.ProductService;
import com.airton.sales_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService service; // precisa está registrada como componente do spring

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){

        List<Product> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable  Long id){ // @PathVatiable traduz o Long id para a requisição http
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
