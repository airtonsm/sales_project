package com.airton.sales_project.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private  String imUrl;

    //o mesmo produto não pode ter a mesma categoria mais de uma vez, o Set não permite itens repetidos na lista.

    //@Transient -> impede o JPA interpretar esse comando
    @ManyToMany
    @JoinTable(name = "tb_product_category", // name table association
            joinColumns = @JoinColumn(name = "product_id"), // name FK in the table Category
            inverseJoinColumns = @JoinColumn(name = "category_id"))   // inverserJoinColumns aponta o @joinColumn para referenciar FK na tabela Product
    private Set<Category> categories = new HashSet<>(); // "new HashSet" permite que a categoria não inicie nula, porém vazia.

    public Product(){};

    public Product(Long id, String name, String description, Double price, String imUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imUrl = imUrl;
    } // não se colocar collection em construtores, a collection já está instancia (categories);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImUrl() {
        return imUrl;
    }

    public void setImUrl(String imUrl) {
        this.imUrl = imUrl;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId().equals(product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
