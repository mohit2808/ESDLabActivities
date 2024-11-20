package com.example.esdlabactivities.service;

import com.example.esdlabactivities.dto.CustomerRequest;
import com.example.esdlabactivities.dto.LoginRequest;
import com.example.esdlabactivities.entity.Customer;
import com.example.esdlabactivities.mapper.CustomerMapper;
import com.example.esdlabactivities.repo.CustomerRepo;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class CustomerService {

    private final CustomerRepo repo;
    private final CustomerMapper mapper;
    private final CustomerRepo customerRepo;

    public String createCustomer(CustomerRequest request){
        Customer customer = mapper.toEntity(request);
        repo.save(customer);
        return "Customer Created Sucessfully";
    }

    public Customer getCustomer(String email){
        return customerRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Customer Not Found"));
    }

    public String login(LoginRequest request){
        Customer customer = getCustomer(request.email());
        if(customer == null){
            return "Customer Not Found";
        }

        return "Customer Login Sucessfully";
    }
}
