package com.shoppin.app.service;

import com.shoppin.app.model.Products;
import java.util.List;

public interface ProductService {

  Products insert(Products products);

  List<Products> getAll();

  Products getProductById(Long id);

  Products update(Long id, Products products);

  void delete(Long id);
}
