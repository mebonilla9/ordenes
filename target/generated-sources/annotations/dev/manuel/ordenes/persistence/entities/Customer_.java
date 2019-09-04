package dev.manuel.ordenes.persistence.entities;

import dev.manuel.ordenes.persistence.entities.MyOrder;
import dev.manuel.ordenes.persistence.entities.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-04T13:23:27")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, Integer> customerId;
    public static volatile SingularAttribute<Customer, String> name;
    public static volatile SingularAttribute<Customer, String> email;
    public static volatile ListAttribute<Customer, Product> productList;
    public static volatile ListAttribute<Customer, MyOrder> myOrderList;

}