package com.shoppin.app.service.impl;

import com.shoppin.app.exeption.ProductNotFound;
import com.shoppin.app.model.Products;
import com.shoppin.app.model.repository.ProductsRepository;
import com.shoppin.app.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private final ProductsRepository productsRepository;

  public ProductServiceImpl(ProductsRepository productsRepository) {
    this.productsRepository = productsRepository;
  }

  @Override
  public Products insert(Products products) {
    return productsRepository.save(products);
  }

  @Override
  public List<Products> getAll() {
    return productsRepository.findAll();
  }

  @Override
  public Products getProductById(Long id) {
    return productsRepository.findById(id).orElseThrow(ProductNotFound::new);
  }

  @Override
  public Products update(Long id, Products newProducts) {
    Products product = productsRepository.findById(id).orElseThrow(ProductNotFound::new);
    product.setName(newProducts.getName());
    product.setDescription(newProducts.getDescription());
    product.setPrice(newProducts.getPrice());

    return productsRepository.save(product);
  }

  @Override
  public void delete(Long id) {
    productsRepository.findById(id).orElseThrow(ProductNotFound::new);
    productsRepository.deleteById(id);
  }
}
