package com.melbrisade.project.services;

import com.melbrisade.project.dtos.CustomerGetDto;
import com.melbrisade.project.dtos.CustomerPostDto;
import com.melbrisade.project.entities.Customer;
import com.melbrisade.project.repositories.CustomerRepository;
import com.melbrisade.project.mappers.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public void delete(Long customerId){
        customerRepository.deleteById(customerId);
    }

    //get customer list
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    public CustomerGetDto findCustomerById(Long customerId){
        return customerMapper.fromEntity(customerRepository.getOne(customerId));
    }

    /*
    private Customer mapPostDtoToEntity(CustomerPostDto customerPostDto) {
        Customer customer = new Customer();
        customer.setFirst_name(customer.getFirst_name());
        customer.setLast_name(customer.getLast_name());
        customer.setMobile(customer.getMobile());
        customer.setGender(customer.getGender());
        customer.setEmail(customer.getEmail());
        customer.setAddress_line1(customer.getAddress_line1());
        customer.setAddress_line2(customer.getAddress_line2());
        customer.setZip(customer.getZip());
        customer.setCity(customer.getCity());
        customer.setCountry(customer.getCountry());
        customer.setDate_of_birth(customer.getDate_of_birth());
        customer.setTag(customer.getTag());

        return customer;
    }
     private CustomerGetDto mapEntityToGetDto(Customer customer) {
     CustomerGetDto customerGetDto = new CustomerGetDto();
     customerGetDto.setCustomer_id(customer.getCustomer_id());
     customerGetDto.setFirst_name(customer.getFirst_name());
     customerGetDto.setLast_name(customer.getLast_name());
     customerGetDto.setGender(customer.getGender());
     customerGetDto.setMobile(customer.getMobile());
     customerGetDto.setEmail(customer.getEmail());
     customerGetDto.setAddress_line1(customer.getAddress_line1());
     customerGetDto.setAddress_line2(customer.getAddress_line2());
     customerGetDto.setZip(customer.getZip());
     customerGetDto.setCity(customer.getCity());
     customerGetDto.setCountry(customer.getCountry());
     customerGetDto.setCity(customer.getCity());
     customerGetDto.setDate_of_birth(customer.getDate_of_birth());
     customerGetDto.setTag(customer.getTag());

     return customerGetDto;
     }
     */
}
