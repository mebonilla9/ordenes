/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.manuel.ordenes.business.constants;

/**
 *
 * @author lord_nightmare
 */
public final class ERoute {
  
  public final static class Errors {

    public final static String ORDER_BY_CUSTOMER_ID = "/error";
  }

  public final static class Customers {

    public final static String ALL_CUSTOMERS = "/api/customers/";
    
  }
  
  public final static class Orders {
    public final static String CREATE_ORDER = "/api/order/create";
    public final static String ORDER_BY_CUSTOMER = "/api/order/customer/{idcustomer}";
  }

}
