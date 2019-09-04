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
public class ProductDto {

  /**
   * The id of the product
   */
  private Integer productId;
  
  /**
   * The name of the product
   */
  private String name;
  
  /**
   * The text description of the product
   */
  private String productDescription;
  
  /**
   * The price of the product
   */
  private double price;
  private List<CustomerDto> customerList;
  private List<OrderDetailDto> orderDetailList;

  /**
   * @return the productId
   */
  public Integer getProductId() {
    return productId;
  }

  /**
   * @param productId the productId to set
   */
  public void setProductId(Integer productId) {
    this.productId = productId;
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
   * @return the productDescription
   */
  public String getProductDescription() {
    return productDescription;
  }

  /**
   * @param productDescription the productDescription to set
   */
  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  /**
   * @return the price
   */
  public double getPrice() {
    return price;
  }

  /**
   * @param price the price to set
   */
  public void setPrice(double price) {
    this.price = price;
  }

  /**
   * @return the customerList
   */
  public List<CustomerDto> getCustomerList() {
    return customerList;
  }

  /**
   * @param customerList the customerList to set
   */
  public void setCustomerList(List<CustomerDto> customerList) {
    this.customerList = customerList;
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
