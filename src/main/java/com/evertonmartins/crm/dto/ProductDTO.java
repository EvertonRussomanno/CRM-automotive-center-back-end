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

    @Size(min = 10, message = "Descrição deve ter pelo menos 10 caracteres!")
    @NotBlank(message = "Campo Obrigatório!")
    private String description;

    @Positive(message = "Preço deve ser positivo")
    private BigDecimal price;

    private String imgUrl;

    @NotEmpty(message = "Deve ter ao menos uma catrgoria.")
    private List<CategoryDTO> categories = new ArrayList<>();
    public ProductDTO(Long id, String name, String description, BigDecimal price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
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

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }
}
