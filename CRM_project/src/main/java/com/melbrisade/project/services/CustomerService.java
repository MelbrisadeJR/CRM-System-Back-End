package com.melbrisade.project.services;

import com.melbrisade.project.dtos.CustomerGetDto;
import com.melbrisade.project.dtos.CustomerPostDto;
import com.melbrisade.project.dtos.CustomerPutDto;
import com.melbrisade.project.entities.Customer;
import com.melbrisade.project.repositories.CustomerRepository;
import com.melbrisade.project.mappers.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerGetDto createCustomer(CustomerPostDto customerPostDto) {
        Customer customerEntity = customerMapper.toEntity(customerPostDto);
        return customerMapper.fromEntity(customerRepository.save(customerEntity));
    }

    public void deleteCustomerById(Long customerId){
        customerRepository.deleteById(customerId);
    }

    public void fakeDeleteCustomerById(Long customerId){
        Customer customerEntity = customerRepository.getOne(customerId);
        customerEntity.setDeleted(true);
        customerRepository.save(customerEntity);
    }

    public CustomerGetDto updateCustomerById(Long customerId, CustomerPutDto customerPutDto){
        Customer customer = customerRepository.getOne(customerId);
        System.out.println(customer);
        System.out.println(customerPutDto);
        customerMapper.copy(customerPutDto, customer);
        System.out.println(customer);
        return customerMapper.fromEntity(customerRepository.save(customer));
    }
    //get customer list
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        Iterator<Customer> itr = customerList.iterator();
        while(itr.hasNext()){
            Customer customer = itr.next();
            if (customer.isDeleted()){
                itr.remove();
            }
        }
        return customerList;
    }

    public CustomerGetDto findCustomerById(Long customerId){
        return customerMapper.fromEntity(customerRepository.getOne(customerId));
    }
}
