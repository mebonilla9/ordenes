package dev.manuel.ordenes.persistence.entities;

import dev.manuel.ordenes.persistence.entities.MyOrder;
import dev.manuel.ordenes.persistence.entities.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-04T13:23:27")
@StaticMetamodel(OrderDetail.class)
public class OrderDetail_ { 

    public static volatile SingularAttribute<OrderDetail, Integer> quantity;
    public static volatile SingularAttribute<OrderDetail, Product> productId;
    public static volatile SingularAttribute<OrderDetail, MyOrder> orderId;
    public static volatile SingularAttribute<OrderDetail, Double> price;
    public static volatile SingularAttribute<OrderDetail, Integer> orderDetailId;
    public static volatile SingularAttribute<OrderDetail, String> productDescription;

}