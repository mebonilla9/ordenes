/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.manuel.ordenes.persistence.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lord_nightmare
 */
@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * The id of the order detail
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "order_detail_id")
  private Integer orderDetailId;

  /**
   * The description of the product in the order detail
   */
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 191)
  @Column(name = "product_description")
  private String productDescription;

  /**
   * the price of the product in the order detail
   */
  @Basic(optional = false)
  @NotNull
  @Column(name = "price")
  private double price;

  /**
   * The quantity of the products in the order detail
   */
  @Basic(optional = false)
  @NotNull
  @Column(name = "quantity")
  private int quantity;
  @JoinColumn(name = "product_id", referencedColumnName = "product_id")
  @ManyToOne(optional = false)
  private Product productId;
  @JoinColumn(name = "order_id", referencedColumnName = "order_id")
  @ManyToOne(optional = false)
  private MyOrder orderId;

  public OrderDetail() {
  }

  public OrderDetail(Integer orderDetailId) {
    this.orderDetailId = orderDetailId;
  }

  public OrderDetail(Integer orderDetailId, String productDescription, double price, int quantity) {
    this.orderDetailId = orderDetailId;
    this.productDescription = productDescription;
    this.price = price;
    this.quantity = quantity;
  }

  public Integer getOrderDetailId() {
    return orderDetailId;
  }

  public void setOrderDetailId(Integer orderDetailId) {
    this.orderDetailId = orderDetailId;
  }

  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Product getProductId() {
    return productId;
  }

  public void setProductId(Product productId) {
    this.productId = productId;
  }

  public MyOrder getOrderId() {
    return orderId;
  }

  public void setOrderId(MyOrder orderId) {
    this.orderId = orderId;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (orderDetailId != null ? orderDetailId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof OrderDetail)) {
      return false;
    }
    OrderDetail other = (OrderDetail) object;
    if ((this.orderDetailId == null && other.orderDetailId != null) || (this.orderDetailId != null && !this.orderDetailId.equals(other.orderDetailId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dev.manuel.ordenes.persistence.entities.OrderDetail[ orderDetailId=" + orderDetailId + " ]";
  }

}
