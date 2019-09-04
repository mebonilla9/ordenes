/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.manuel.ordenes.persistence.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.manuel.ordenes.persistence.entities.MyOrder;
import dev.manuel.ordenes.persistence.entities.OrderDetail;
import java.util.List;

/**
 *
 * @author lord_nightmare
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CreateOrderDto {
  
  /**
   * 
   */
  private MyOrder order;
  private List<OrderDetail> orderDetails;

  /**
   * @return the order
   */
  public MyOrder getOrder() {
    return order;
  }

  /**
   * @param order the order to set
   */
  public void setOrder(MyOrder order) {
    this.order = order;
  }

  /**
   * @return the orderDetails
   */
  public List<OrderDetail> getOrderDetails() {
    return orderDetails;
  }

  /**
   * @param orderDetails the orderDetails to set
   */
  public void setOrderDetails(List<OrderDetail> orderDetails) {
    this.orderDetails = orderDetails;
  }
  
  
  
}
