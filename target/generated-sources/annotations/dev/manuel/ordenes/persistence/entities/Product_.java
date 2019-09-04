package dev.manuel.ordenes.persistence.entities;

import dev.manuel.ordenes.persistence.entities.Customer;
import dev.manuel.ordenes.persistence.entities.OrderDetail;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-04T13:23:27")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile ListAttribute<Product, OrderDetail> orderDetailList;
    public static volatile SingularAttribute<Product, Integer> productId;
    public static volatile SingularAttribute<Product, Double> price;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile ListAttribute<Product, Customer> customerList;
    public static volatile SingularAttribute<Product, String> productDescription;

}