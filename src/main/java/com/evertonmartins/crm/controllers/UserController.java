package com.evertonmartins.crm.controllers;

import com.evertonmartins.crm.dto.UserDTO;
import com.evertonmartins.crm.services.impl.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "crm/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SELLER', 'ROLE_RH', 'ROLE_ADM', 'ROLE_WORKSHOP', 'ROLE_BUYER')")
    @GetMapping(value = "/me")
    @Operation(summary = "Get logged user")
    public ResponseEntity<UserDTO> getMe(){
        UserDTO userDTO = userService.getMe();
        return ResponseEntity.ok(userDTO);
    }
}
