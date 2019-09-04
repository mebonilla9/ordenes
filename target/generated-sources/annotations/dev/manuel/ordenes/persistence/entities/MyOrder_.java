package dev.manuel.ordenes.persistence.entities;

import dev.manuel.ordenes.persistence.entities.Customer;
import dev.manuel.ordenes.persistence.entities.OrderDetail;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-04T13:23:27")
@StaticMetamodel(MyOrder.class)
public class MyOrder_ { 

    public static volatile ListAttribute<MyOrder, OrderDetail> orderDetailList;
    public static volatile SingularAttribute<MyOrder, Double> total;
    public static volatile SingularAttribute<MyOrder, Integer> orderId;
    public static volatile SingularAttribute<MyOrder, String> deliveryAddress;
    public static volatile SingularAttribute<MyOrder, Customer> customerId;
    public static volatile SingularAttribute<MyOrder, Date> creationDate;

}