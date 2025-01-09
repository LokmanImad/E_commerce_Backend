package org.example.product_service.service;

import lombok.AllArgsConstructor;
import org.example.product_service.model.Product;
import org.example.product_service.model.ProductDto;
import org.example.product_service.model.ProductUpdateDto;
import org.example.product_service.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    public ResponseEntity<Product> findById(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        return productOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Product> addProduct(ProductDto dto){
        Product product = Product.builder()
                .stock(dto.stock())
                .name(dto.name())
                .description(dto.description())
                .promo(dto.promo())
                .categories(dto.categorises())
                .price(BigDecimal.valueOf(dto.price()))
                .image(dto.imagePath())
                .build();
        return ResponseEntity.ok(productRepository.save(product));
    }


    public ResponseEntity<Product> updateProduct(Long productId, ProductDto productUpdateDto) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if(productOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Product existingProduct = productOptional.get();

        existingProduct.setName(productUpdateDto.name());
        existingProduct.setDescription(productUpdateDto.description());
        existingProduct.setImage(productUpdateDto.imagePath());
        existingProduct.setPromo(productUpdateDto.promo());
        existingProduct.setPrice(BigDecimal.valueOf(productUpdateDto.price()));
        existingProduct.setCategories(productUpdateDto.categorises());

        productRepository.save(existingProduct);

        return ResponseEntity.ok(existingProduct);
    }

    public ResponseEntity<?> deleteProduct(Long productId){
        Optional<Product> productOptional = productRepository.findById(productId);
        if(productOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        productRepository.deleteById(productId);

        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Product> updateProductPromo(Long productId, ProductUpdateDto productUpdateDto) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if(productOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Product existingProduct = productOptional.get();
        existingProduct.setPromo(productUpdateDto.promo());

        return ResponseEntity.accepted().body(existingProduct);
    }

    // TODO: add more patch methods to update different attributes of a product
}
