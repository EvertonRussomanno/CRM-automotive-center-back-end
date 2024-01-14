package com.evertonmartins.crm.dto;

import com.evertonmartins.crm.models.entities.Address;
import com.evertonmartins.crm.models.entities.User;
import org.springframework.security.core.GrantedAuthority;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDTO{

        private Long id;
        private String name;
        private String lastName;
        private String email;
        private String phone;
        private Address userAddress;
        private String cpfNumber;
        private String rgNumber;
        private String workCardNumber;
        private String pisNumber;
        private Integer children;
        private String birthDate;
        private BigDecimal salary;

    private static List<String> roles = new ArrayList<>();

    public UserDTO (User entity){
        id = entity.getId();
        name = entity.getName();
        lastName = entity.getLastName();
        email = entity.getEmail();
        phone = entity.getPhone();
        userAddress = entity.getUserAddress();
        cpfNumber = entity.getCpfNumber();
        rgNumber = entity.getRgNumber();
        workCardNumber = entity.getWorkCardNumber();
        pisNumber = entity.getPisNumber();
        children = entity.getChildren();
        birthDate = entity.getBirthDate();
        salary = entity.getSalary();

        for(GrantedAuthority role : entity.getRoles()){
            roles.add(role.getAuthority());
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Address getUserAddress() {
        return userAddress;
    }

    public String getCpfNumber() {
        return cpfNumber;
    }

    public String getRgNumber() {
        return rgNumber;
    }

    public String getWorkCardNumber() {
        return workCardNumber;
    }

    public String getPisNumber() {
        return pisNumber;
    }

    public Integer getChildren() {
        return children;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public static List<String> getRoles() {
        return roles;
    }
}
