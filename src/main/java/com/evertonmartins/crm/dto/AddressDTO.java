package com.evertonmartins.crm.dto;

public record AddressDTO(Long id, String address, String neighborhood,
                         String city, String state, String country,
                         String complement, String description, String zipCode) {
}
