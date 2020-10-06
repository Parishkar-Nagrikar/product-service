package com.ecommerce.product.repository;

import com.ecommerce.product.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {
   Product findByProductId(Integer productId);

   void deleteByProductId(Integer productId);
}
