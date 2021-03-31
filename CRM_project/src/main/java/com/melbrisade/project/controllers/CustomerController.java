package com.melbrisade.project.controllers;

import com.melbrisade.project.dtos.CustomerGetDto;
import com.melbrisade.project.dtos.CustomerPostDto;
import com.melbrisade.project.entities.Customer;
import com.melbrisade.project.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> findCustomers(){
        List<Customer> customerList = customerService.getAllCustomers();
        return ResponseEntity.ok(customerList);
    }

    @PostMapping
    public ResponseEntity<CustomerGetDto> createCustomer(@RequestBody CustomerPostDto customerPostDto){
        CustomerGetDto customerGetDto = customerService.createCustomer(customerPostDto);
        return ResponseEntity.ok(customerGetDto);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity delete(@PathVariable Long customerId){
        customerService.delete(customerId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerGetDto> findById(@PathVariable Long customerId){
        return ResponseEntity.ok(customerService.findCustomerById(customerId));
    }


}
