/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.manuel.ordenes.persistence.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

/**
 *
 * @author lord_nightmare
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomerDto {
  
  /**
   * The customer identifier
   */
  private Integer customerId;
  
  /**
   * The name of the customer
   */
  private String name;
  /**
   * The email address of the customer
   */
  private String email;
  
  /**
   * The list of products of the customer
   */
  private List<ProductDto> productDtoList;
  
  /**
   * The list of orders of the customer
   */
  private List<OrderDto> orderDtoList;

  /**
   * @return the customerId
   */
  public Integer getCustomerId() {
    return customerId;
  }

  /**
   * @param customerId the customerId to set
   */
  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return the productDtoList
   */
  public List<ProductDto> getProductDtoList() {
    return productDtoList;
  }

  /**
   * @param productDtoList the productDtoList to set
   */
  public void setProductDtoList(List<ProductDto> productDtoList) {
    this.productDtoList = productDtoList;
  }

  /**
   * @return the orderDtoList
   */
  public List<OrderDto> getOrderDtoList() {
    return orderDtoList;
  }

  /**
   * @param orderDtoList the orderDtoList to set
   */
  public void setOrderDtoList(List<OrderDto> orderDtoList) {
    this.orderDtoList = orderDtoList;
  }
  
  
  
}
