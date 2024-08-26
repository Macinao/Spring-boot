package com.apisrestful.michelebrito.apisrestful.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.apisrestful.michelebrito.apisrestful.Models.ProductModel;
import com.apisrestful.michelebrito.apisrestful.Repository.ProductRepository;
import com.apisrestful.michelebrito.apisrestful.dtos.ProductRecordDTO;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ResponseEntity<ProductModel> saveProduct(ProductRecordDTO productRecordDTO) {
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDTO, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }

    public ResponseEntity<Object> findById(UUID id) {
        Optional<ProductModel> product = productRepository.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product.get());
    }

    public ResponseEntity<Object> updateProduct(UUID id, ProductRecordDTO productRecordDTO) {
        Optional<ProductModel> product = productRepository.findById(id);
        var productModel = product.get();
        BeanUtils.copyProperties(productRecordDTO, productModel);
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
    }

    public ResponseEntity<Object> deleteProduct(UUID id) {
        Optional<ProductModel> product = productRepository.findById(id);
        productRepository.delete(product.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado!");
    }
}