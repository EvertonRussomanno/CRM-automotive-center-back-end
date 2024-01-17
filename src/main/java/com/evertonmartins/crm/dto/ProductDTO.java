package com.evertonmartins.crm.dto;

import com.evertonmartins.crm.models.entities.Category;
import com.evertonmartins.crm.models.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductDTO {

    private Long id;

    @Size(min = 3, max = 80, message = "Nome precisa de 3 a 80 caracteres!")
    @NotBlank(message = "Campo Obrigatório!")
    private String name;

    private String codeNumber;

    @Size(min = 10, message = "Descrição deve ter pelo menos 10 caracteres!")
    @NotBlank(message = "Campo Obrigatório!")
    private String description;

    @Positive(message = "Preço deve ser positivo")
    private BigDecimal costPrice;

    private BigDecimal finalPrice;

    private String ncmNumber;

    private String imgUrl;

    @NotEmpty(message = "Deve ter ao menos uma catergoria.")
    private List<CategoryDTO> categories = new ArrayList<>();
    public ProductDTO(Long id, String name, String codeNumber, String description, BigDecimal costPrice, BigDecimal finalPrice, String ncmNumber, String imgUrl) {
        this.id = id;
        this.name = name;
        this.codeNumber = codeNumber;
        this.description = description;
        this.costPrice = costPrice;
        this.finalPrice = finalPrice;
        this.ncmNumber = ncmNumber;
        this.imgUrl = imgUrl;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        codeNumber = entity.getCodeNumber();
        description = entity.getDescription();
        costPrice = entity.getCostPrice();
        finalPrice = entity.getFinalPrice();
        ncmNumber = entity.getNcmNumber();
        imgUrl = entity.getImgUrl();
        for(Category cat : entity.getCategories()){
            categories.add(new CategoryDTO(cat));
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public String getNcmNumber() {
        return ncmNumber;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }
}
