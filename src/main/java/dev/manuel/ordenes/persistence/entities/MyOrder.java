/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.manuel.ordenes.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lord_nightmare
 */
@Entity
@Table(name = "\"order\"")
public class MyOrder implements Serializable {

  private static final long serialVersionUID = 1L;
  
  /**
   * The order id
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "order_id")
  private Integer orderId;
  
  /**
   * The date of the order creation
   */
  @Basic(optional = false)
  @NotNull
  @Column(name = "creation_date")
  @Temporal(TemporalType.DATE)
  private Date creationDate;
  
  /**
   * the delivery address of the order
   */
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 191)
  @Column(name = "delivery_address")
  private String deliveryAddress;
  
  /**
   * The total price of products into the order
   */
  @Basic(optional = false)
  @NotNull
  @Column(name = "total")
  private double total;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId", fetch = FetchType.LAZY)
  private List<OrderDetail> orderDetailList;
  @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
  @ManyToOne(optional = false)
  private Customer customerId;

  public MyOrder() {
  }

  public MyOrder(Integer orderId) {
    this.orderId = orderId;
  }

  public MyOrder(Integer orderId, Date creationDate, String deliveryAddress, double total) {
    this.orderId = orderId;
    this.creationDate = creationDate;
    this.deliveryAddress = deliveryAddress;
    this.total = total;
  }

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public String getDeliveryAddress() {
    return deliveryAddress;
  }

  public void setDeliveryAddress(String deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  @XmlTransient
  public List<OrderDetail> getOrderDetailList() {
    return orderDetailList;
  }

  public void setOrderDetailList(List<OrderDetail> orderDetailList) {
    this.orderDetailList = orderDetailList;
  }

  public Customer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Customer customerId) {
    this.customerId = customerId;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (orderId != null ? orderId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof MyOrder)) {
      return false;
    }
    MyOrder other = (MyOrder) object;
    if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dev.manuel.ordenes.persistence.entities.MyOrder[ orderId=" + orderId + " ]";
  }
  
}
