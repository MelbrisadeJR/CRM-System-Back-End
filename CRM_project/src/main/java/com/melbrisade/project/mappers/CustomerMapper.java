package com.melbrisade.project.mappers;

import com.melbrisade.project.dtos.CustomerGetDto;
import com.melbrisade.project.dtos.CustomerPostDto;
import com.melbrisade.project.dtos.CustomerPutDto;
import com.melbrisade.project.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {
    Customer toEntity(CustomerPostDto customerPostDto);
    CustomerGetDto fromEntity(Customer customer);
    void copy(CustomerPutDto customerPutDto, @MappingTarget Customer customer);
}

