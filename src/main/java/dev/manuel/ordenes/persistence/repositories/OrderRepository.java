/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.manuel.ordenes.persistence.repositories;

import dev.manuel.ordenes.persistence.entities.MyOrder;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lord_nightmare
 */
@Repository
public interface OrderRepository extends CrudRepository<MyOrder, Integer>{
  
  @Query("select o from MyOrder o join fetch o.customerId c where c.customerId = :idcustomer")
  List<MyOrder> findOrdersByCustomer(@Param("idcustomer") int idCustomer);
  
}
