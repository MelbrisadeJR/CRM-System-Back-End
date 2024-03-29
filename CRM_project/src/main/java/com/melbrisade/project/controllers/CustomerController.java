package com.melbrisade.project.controllers;

import com.melbrisade.project.dtos.CustomerGetDto;
import com.melbrisade.project.dtos.CustomerPostDto;
import com.melbrisade.project.dtos.CustomerPutDto;
import com.melbrisade.project.entities.Customer;
import com.melbrisade.project.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> findCustomers(){
        List<Customer> customerList = customerService.getAllCustomers();
        return ResponseEntity.ok(customerList);
    }

    @GetMapping("/totalCustomers")
    public ResponseEntity<Integer> findTotalCustomers(){
        List<Customer> customerList = customerService.getAllCustomers();
        return ResponseEntity.ok(customerList.size());
    }

    @PostMapping
    public ResponseEntity<CustomerGetDto> createCustomer(@RequestBody CustomerPostDto customerPostDto){
        CustomerGetDto customerGetDto = customerService.createCustomer(customerPostDto);
        return ResponseEntity.ok(customerGetDto);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity deleteCustomerById(@PathVariable Long customerId){
        customerService.deleteCustomerById(customerId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{customerIds}")
    public ResponseEntity<?> deleteMultipleCustomers(@PathVariable List<Long> customerIds) {
        for (long id : customerIds) {
            if (customerService.findCustomerById(id) != null) {
                customerService.fakeDeleteCustomerById(id);
            }
        }
        return new ResponseEntity<String>("Multiple customers were deleted", HttpStatus.OK);
    }

    @PutMapping("updateById/{customerId}")
    public ResponseEntity<CustomerGetDto> updateCustomers(@PathVariable Long customerId,
                                             @RequestBody CustomerPutDto customerPutDto) {
        CustomerGetDto customerGetDto = customerService.updateCustomerById(customerId, customerPutDto);
        return ResponseEntity.ok(customerGetDto);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerGetDto> findById(@PathVariable Long customerId){
        return ResponseEntity.ok(customerService.findCustomerById(customerId));
    }


}
