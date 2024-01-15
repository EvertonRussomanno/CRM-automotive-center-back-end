package com.evertonmartins.crm.services.impl;

import com.evertonmartins.crm.dto.ProductMinDTO;
import com.evertonmartins.crm.models.entities.Product;
import com.evertonmartins.crm.dto.CategoryDTO;
import com.evertonmartins.crm.dto.ProductDTO;
import com.evertonmartins.crm.models.entities.Category;
import com.evertonmartins.crm.repositories.ProductRepository;
import com.evertonmartins.crm.services.ProductService;
import com.evertonmartins.crm.services.exceptions.DatabaseException;
import com.evertonmartins.crm.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<ProductMinDTO> findAll(String name, Pageable pageable) {
        Page<Product> list = productRepository.searchByName(name, pageable);
        return list.map(ProductMinDTO::new);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        return new ProductDTO(product);
    }

    @Override
    @Transactional
    public ProductDTO insert(ProductDTO productDTO) {
        Product entity = new Product();
        copyDtoToEntity(productDTO, entity);
        productRepository.save(entity);
        return new ProductDTO(entity);
    }

    @Override
    @Transactional
    public ProductDTO update(Long id, ProductDTO productDTO) {
        try {
            Product entity = productRepository.getReferenceById(id);
            copyDtoToEntity(productDTO, entity);
            productRepository.save(entity);
            return new ProductDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Resource not found!");
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!productRepository.existsById(id)){
            throw new ResourceNotFoundException("Resource not found!");
        }
        try {
            productRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Integrity database fail!");
        }

    }

    private void copyDtoToEntity(ProductDTO productDTO, Product entity) {
        entity.setName(productDTO.getName());
        entity.setDescription(productDTO.getDescription());
        entity.setPrice(productDTO.getPrice());
        entity.setImgUrl(productDTO.getImgUrl());

        entity.getCategories().clear();
        for (CategoryDTO catDTO : productDTO.getCategories()){
            Category cat = new Category();
            cat.setId(catDTO.getId());
            entity.getCategories().add(cat);
        }
    }
}
