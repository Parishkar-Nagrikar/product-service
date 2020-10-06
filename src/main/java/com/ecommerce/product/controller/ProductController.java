package com.ecommerce.product.controller;

import com.ecommerce.product.model.ProductRequest;
import com.ecommerce.product.model.ProductResponse;
import com.ecommerce.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<ProductResponse> add(@RequestBody ProductRequest productRequest){

        LOGGER.info(" productRequest :"+ productRequest);
        ProductResponse productResponse = productService.addProduct(productRequest);
        return ResponseEntity.ok(productResponse);
    }

    @GetMapping("/findProduct/{productId}")
    public ResponseEntity<ProductResponse> get(@PathVariable Integer productId) {
        System.out.println(" ----------- productId  ----------- "+ productId);
        ProductResponse productResponse = productService.getProduct(productId);
        return ResponseEntity.ok(productResponse);
    }

    @GetMapping("/findProduct/allProduct")
    public ResponseEntity<List<ProductResponse>> get() {
        List<ProductResponse> products = productService.getAllProduct();
        System.out.println(" ----------: products :---------- "+products);
        return ResponseEntity.ok(products);
    }

    @PutMapping("/modifyProduct")
    public ResponseEntity<ProductResponse> modify(@RequestBody ProductRequest productRequest){
        ProductResponse productResponse = productService.modifyProduct(productRequest);
        return ResponseEntity.ok(productResponse);
    }

    @DeleteMapping("/removeProduct/{productId}")
    public ResponseEntity remove(@PathVariable Integer productId){
        System.out.println(" ----------: productId :---------- "+productId);
        productService.delete(productId);
        return ResponseEntity.ok().build();
    }
}