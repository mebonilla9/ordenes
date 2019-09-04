/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.manuel.ordenes.persistence.repositories;

import dev.manuel.ordenes.persistence.entities.Customer;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lord_nightmare
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
  
  @Query(
    "select c from Customer c join "
    + "c.productList p where c.customerId = :idcustomer "
    + "and p.productId = :idproduct")
  Optional<Customer> existProductByCustomer(
    @Param("idcustomer") int idCustomer, 
    @Param("idproduct") int idProduct
  );
  
}
