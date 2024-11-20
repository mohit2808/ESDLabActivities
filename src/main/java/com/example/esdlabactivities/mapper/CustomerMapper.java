package com.example.esdlabactivities.mapper;

import com.example.esdlabactivities.entity.Customer;
import com.example.esdlabactivities.dto.CustomerRequest;
import org.springframework.stereotype.Service;

@Service

public class CustomerMapper {

    public Customer toEntity(CustomerRequest request) {
        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .build();
    }
}