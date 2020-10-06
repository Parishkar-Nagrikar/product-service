package com.ecommerce.product.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("product")
public class Product {

    @Id
    String id;

    @Getter@Setter
    @Indexed(unique = true)
    Integer productId;

    @Getter@Setter
    String name;

    @Getter@Setter
    String description;

    @Getter@Setter
    Double price;

    @Getter@Setter
    String currencyCode;

    @Getter@Setter
    Integer quantity;
}