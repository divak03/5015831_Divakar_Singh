package com.bookstore.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.bookstore.dto.CustomerDTO;
import com.bookstore.entity.Customer;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE=Mappers.getMapper(CustomerMapper.class);
    CustomerDTO customertoCustomerDTO(Customer customer);
    Customer customerDTOtoCustomer(CustomerDTO customerDTO);
}