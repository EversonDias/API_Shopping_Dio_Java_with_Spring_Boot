package com.shoppin.app.controller;

import com.shoppin.app.controller.Dto.ResponseDto;
import com.shoppin.app.model.Products;
import com.shoppin.app.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {

  @Autowired
  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping
  public ResponseEntity<ResponseDto<Products>> insert(@RequestBody Products products) {
    Products data = productService.insert(products);

    ResponseDto<Products> response = new ResponseDto<>(
        "Produto Inserido com Sucesso!",
        data
    );

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ResponseDto<Products>> update(@PathVariable Long id, @RequestBody Products products) {
    Products data = productService.update(id, products);

    ResponseDto<Products> response = new ResponseDto<>(
        "Produto Atualizado com Sucesso",
        data
    );

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Products> getById(@PathVariable Long id) {
    Products data = productService.getProductById(id);
    return ResponseEntity.status(HttpStatus.OK).body(data);
  }

  @GetMapping
  public ResponseEntity<List<Products>> getAll() {
    List<Products> data = productService.getAll();

    return ResponseEntity.status(HttpStatus.OK).body(data);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable Long id) {
    productService.delete(id);
    return ResponseEntity.status(HttpStatus.OK).body("Produto Excluido com Sucesso!");
  }

}
