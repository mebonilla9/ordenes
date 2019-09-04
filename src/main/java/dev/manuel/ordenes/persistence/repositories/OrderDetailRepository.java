/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.manuel.ordenes.persistence.repositories;

import dev.manuel.ordenes.persistence.entities.OrderDetail;
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
public interface OrderDetailRepository extends CrudRepository<OrderDetail, Integer>{
  
  @Query("select d from OrderDetail d join fetch d.orderId o where o.orderId = :idorder")
  public List<OrderDetail> findOrderDetailById(@Param("idorder") int idOrder);
  
  @Query(
    "select d from OrderDetail d "
      + "join d.orderId o "
      + "join o.customerId c "
      + "where c.customerId = :idcustomer "
      + "order by d.orderDetailId asc")
  List<OrderDetail> findOrderDetailByCustomer(@Param("idcustomer") int idCustomer);
  
}
