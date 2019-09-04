/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.manuel.ordenes.business.services;

import dev.manuel.ordenes.persistence.entities.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dev.manuel.ordenes.persistence.repositories.CustomerRepository;
import java.util.Optional;

/**
 *
 * @author lord_nightmare
 */
@Service
public class CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  @Transactional(readOnly = true)
  public List<Customer> findAllCustomers() {
    return(List<Customer>) customerRepository.findAll();
  }

  @Transactional(readOnly = true)
  public Optional<Customer> findCustomerByProduct(int customerId, int productId) {
    return customerRepository.existProductByCustomer(customerId, productId);
  }

}
