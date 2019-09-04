/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.manuel.ordenes.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lord_nightmare
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

  private static final long serialVersionUID = 1L;
  
  /**
   * The id of the product
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "product_id")
  private Integer productId;
  
  /**
   * The name of the product
   */
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 191)
  @Column(name = "name")
  private String name;
  
  /**
   * The text description of the product
   */
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 191)
  @Column(name = "product_description")
  private String productDescription;
  
  /**
   * The price of the product
   */
  @Basic(optional = false)
  @NotNull
  @Column(name = "price")
  private double price;
  
  @ManyToMany(mappedBy = "productList")
  @JsonIgnore
  private List<Customer> customerList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId",fetch = FetchType.LAZY)
  @JsonIgnore
  private List<OrderDetail> orderDetailList;

  public Product() {
  }

  public Product(Integer productId) {
    this.productId = productId;
  }

  public Product(Integer productId, String name, String productDescription, double price) {
    this.productId = productId;
    this.name = name;
    this.productDescription = productDescription;
    this.price = price;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  @XmlTransient
  public List<Customer> getCustomerList() {
    return customerList;
  }

  public void setCustomerList(List<Customer> customerList) {
    this.customerList = customerList;
  }

  @XmlTransient
  public List<OrderDetail> getOrderDetailList() {
    return orderDetailList;
  }

  public void setOrderDetailList(List<OrderDetail> orderDetailList) {
    this.orderDetailList = orderDetailList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (productId != null ? productId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Product)) {
      return false;
    }
    Product other = (Product) object;
    if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dev.manuel.ordenes.persistence.entities.Product[ productId=" + productId + " ]";
  }
  
}
