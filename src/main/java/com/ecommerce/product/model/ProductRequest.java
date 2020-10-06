package com.ecommerce.product.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProductRequest {

    @Getter@Setter
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