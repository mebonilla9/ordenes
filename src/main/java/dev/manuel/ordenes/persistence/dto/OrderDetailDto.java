/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.manuel.ordenes.persistence.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author lord_nightmare
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OrderDetailDto {

  /**
   * The id of the order detail
   */
  private Integer orderDetailId;

  /**
   * The description of the product in the order detail
   */
  private String productDescription;

  /**
   * the price of the product in the order detail
   */
  private double price;

  /**
   * The quantity of the products in the order detail
   */
  private int quantity;
  private ProductDto productId;
  private OrderDto orderId;

  /**
   * @return the orderDetailId
   */
  public Integer getOrderDetailId() {
    return orderDetailId;
  }

  /**
   * @param orderDetailId the orderDetailId to set
   */
  public void setOrderDetailId(Integer orderDetailId) {
    this.orderDetailId = orderDetailId;
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
   * @return the quantity
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * @param quantity the quantity to set
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /**
   * @return the productId
   */
  public ProductDto getProductId() {
    return productId;
  }

  /**
   * @param productId the productId to set
   */
  public void setProductId(ProductDto productId) {
    this.productId = productId;
  }

  /**
   * @return the orderId
   */
  public OrderDto getOrderId() {
    return orderId;
  }

  /**
   * @param orderId the orderId to set
   */
  public void setOrderId(OrderDto orderId) {
    this.orderId = orderId;
  }
  
  
}
