package com.ecommerce.product.service;

import com.ecommerce.product.domain.Product;
import com.ecommerce.product.model.ProductRequest;
import com.ecommerce.product.model.ProductResponse;
import com.ecommerce.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductResponse addProduct(ProductRequest productRequest){

        Product newProduct = productRequestMapper(productRequest);
        productRepository.save(newProduct);
        return productResponseMapper(newProduct);
    }
//domain to model mapper
    private ProductResponse productResponseMapper(Product newProduct){
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductId(newProduct.getProductId());
        productResponse.setName(newProduct.getName());
        productResponse.setDescription(newProduct.getDescription());
        productResponse.setPrice(newProduct.getPrice());
        productResponse.setCurrencyCode(newProduct.getCurrencyCode());
        productResponse.setQuantity(newProduct.getQuantity());

        return  productResponse;
    }
//model to domain mapper
    private Product productRequestMapper(ProductRequest productRequest){
        Product product = new Product();

        product.setProductId(productRequest.getProductId());
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setCurrencyCode(productRequest.getCurrencyCode());
        product.setQuantity(productRequest.getQuantity());

        return product;
    }

    public ProductResponse getProduct(Integer productId) {

        Product fetchedProduct = productRepository.findByProductId(productId);
        return productResponseMapper(fetchedProduct);
    }

    public ProductResponse modifyProduct(ProductRequest productRequest) {

        Product fetchedProduct = productRepository.findByProductId(productRequest.getProductId());

        Product modifiedProduct =null;

        if (fetchedProduct != null) {
            System.out.println(" : fetchedProduct : ");
            productRepository.delete(fetchedProduct);
            modifiedProduct = productRepository.save(productRequestMapper(productRequest));
        }else{
            System.out.println(" : else fetchedProduct : ");
            modifiedProduct = productRepository.save(productRequestMapper(productRequest));
        }
        return productResponseMapper(modifiedProduct);
    }

    public void delete(Integer productId) {
        productRepository.deleteByProductId(productId);
    }

    public List<ProductResponse> getAllProduct() {
        List<Product> products   = productRepository.findAll();

        /*List<ProductResponse> re = new ArrayList<>();
        products.forEach(it->{
            re.add(productResponseMapper(it));
        });*/

        List<ProductResponse> productResponses = products.stream().map(it-> {
            return productResponseMapper(it);
        }).collect(Collectors.toList());

        return productResponses;
    }
}
