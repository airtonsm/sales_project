package com.airton.sales_project.resources;

import com.airton.sales_project.entities.Category;
import com.airton.sales_project.services.CategoryService;
import com.airton.sales_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service; // precisa está registrada como componente do spring

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){

        List<Category> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable  Long id){ // @PathVatiable traduz o Long id para a requisição http
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
