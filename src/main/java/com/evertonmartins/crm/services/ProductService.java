package com.evertonmartins.crm.services;

import com.evertonmartins.crm.dto.ProductDTO;
import com.evertonmartins.crm.dto.ProductMinDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    Page<ProductMinDTO> findAll(String name, Pageable pageable);
    ProductDTO findById(Long id);
    ProductDTO insert(ProductDTO productDTO);
    ProductDTO update(Long id, ProductDTO productDTO);
    void delete(Long id);

}
