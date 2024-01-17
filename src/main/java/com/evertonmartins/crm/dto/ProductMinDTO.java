package com.evertonmartins.crm.dto;

import com.evertonmartins.crm.models.entities.Product;

import java.math.BigDecimal;

public class ProductMinDTO {

    private Long id;

    private String name;
    private BigDecimal finalPrice;
    private String imgUrl;

    public ProductMinDTO(Long id, String name, BigDecimal finalPrice, String imgUrl) {
        this.id = id;
        this.name = name;
        this.finalPrice = finalPrice;
        this.imgUrl = imgUrl;
    }

    public ProductMinDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        finalPrice = entity.getFinalPrice();
        imgUrl = entity.getImgUrl();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
