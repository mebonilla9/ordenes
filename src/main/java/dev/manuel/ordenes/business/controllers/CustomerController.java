/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.manuel.ordenes.business.controllers;

import dev.manuel.ordenes.business.constants.ERoute;
import dev.manuel.ordenes.business.services.CustomerService;
import dev.manuel.ordenes.persistence.dto.CustomerDto;
import dev.manuel.ordenes.persistence.entities.Customer;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lord_nightmare
 */
@RestController
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @Autowired
  private ModelMapper modelMapper;

  /**
   * Retrieves the list of customer into the application
   * @return the list of customer into the application
   */
  @GetMapping(ERoute.Customers.ALL_CUSTOMERS)
  public List<CustomerDto> findAllCustomers() {
    List<Customer> customerList = customerService.findAllCustomers();
    return customerList.stream()
      .map(customer -> convertToCustomerDto(customer))
      .collect(Collectors.toList());
  }

  private CustomerDto convertToCustomerDto(Customer customer) {
    CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class); 
    return customerDto;
  }

}
