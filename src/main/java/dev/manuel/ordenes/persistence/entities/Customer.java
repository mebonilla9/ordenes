/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.manuel.ordenes.persistence.entities;

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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "customer")
public class Customer implements Serializable {

  private static final long serialVersionUID = 1L;
  
  /**
   * The customer identifier
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "customer_id")
  private Integer customerId;
  
  /**
   * The name of the customer
   */
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 191)
  @Column(name = "name")
  private String name;
  // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
  
  /**
   * The email address of the customer
   */
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 191)
  @Column(name = "email")
  private String email;
  
  @JoinTable(name = "customer_product", joinColumns = {
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")}, inverseJoinColumns = {
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")})
  @ManyToMany
  private List<Product> productList;
  
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId", fetch = FetchType.LAZY)
  private List<MyOrder> myOrderList;

  public Customer() {
  }

  public Customer(Integer customerId) {
    this.customerId = customerId;
  }

  public Customer(Integer customerId, String name, String email) {
    this.customerId = customerId;
    this.name = name;
    this.email = email;
  }

  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @XmlTransient
  public List<Product> getProductList() {
    return productList;
  }

  public void setProductList(List<Product> productList) {
    this.productList = productList;
  }

  @XmlTransient
  public List<MyOrder> getMyOrderList() {
    return myOrderList;
  }

  public void setMyOrderList(List<MyOrder> myOrderList) {
    this.myOrderList = myOrderList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (customerId != null ? customerId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Customer)) {
      return false;
    }
    Customer other = (Customer) object;
    if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dev.manuel.ordenes.persistence.entities.Customer[ customerId=" + customerId + " ]";
  }
  
}
