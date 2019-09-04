/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.manuel.ordenes.persistence.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.manuel.ordenes.persistence.entities.OrderDetail;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lord_nightmare
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OrderDto {

  /**
   * The order id
   */
  private Integer orderId;

  /**
   * The date of the order creation
   */
  private Date creationDate;

  /**
   * the delivery address of the order
   */
  private String deliveryAddress;

  /**
   * The total price of products into the order
   */
  private double total;
  
  private CustomerDto customerId;
  
  private List<OrderDetailDto> orderDetailList;

  /**
   * @return the orderId
   */
  public Integer getOrderId() {
    return orderId;
  }

  /**
   * @param orderId the orderId to set
   */
  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  /**
   * @return the creationDate
   */
  public Date getCreationDate() {
    return creationDate;
  }

  /**
   * @param creationDate the creationDate to set
   */
  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  /**
   * @return the deliveryAddress
   */
  public String getDeliveryAddress() {
    return deliveryAddress;
  }

  /**
   * @param deliveryAddress the deliveryAddress to set
   */
  public void setDeliveryAddress(String deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
  }

  /**
   * @return the total
   */
  public double getTotal() {
    return total;
  }

  /**
   * @param total the total to set
   */
  public void setTotal(double total) {
    this.total = total;
  }

  /**
   * @return the customerId
   */
  public CustomerDto getCustomerId() {
    return customerId;
  }

  /**
   * @param customerId the customerId to set
   */
  public void setCustomerId(CustomerDto customerId) {
    this.customerId = customerId;
  }

  /**
   * @return the orderDetailList
   */
  public List<OrderDetailDto> getOrderDetailList() {
    return orderDetailList;
  }

  /**
   * @param orderDetailList the orderDetailList to set
   */
  public void setOrderDetailList(List<OrderDetailDto> orderDetailList) {
    this.orderDetailList = orderDetailList;
  }

  
  
}
