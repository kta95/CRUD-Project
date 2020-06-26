package com.kta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kta.model.Product;
public interface ProductRepository extends CrudRepository<Product, Long>{

}
