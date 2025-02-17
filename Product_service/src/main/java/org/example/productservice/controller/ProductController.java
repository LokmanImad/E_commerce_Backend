package org.example.productservice.controller;


import lombok.AllArgsConstructor;
import org.example.productservice.model.Product;
import org.example.productservice.model.ProductDto;
import org.example.productservice.model.ProductUpdateDto;
import org.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProduct(){
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> findById(@PathVariable("productId") Long productId){
        return productService.findById(productId);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody ProductDto dto){
        return productService.addProduct(dto);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productUpdateDto){
        return productService.updateProduct(productId, productUpdateDto);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") Long productId){
        return productService.deleteProduct(productId);
    }

    @PatchMapping("/{productId}/update")
    public ResponseEntity<Product> updateProductPromo(@PathVariable("productId") Long productId, @RequestParam ProductUpdateDto productUpdateDto){
        return productService.updateProductPromo(productId, productUpdateDto);
    }
}
