/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.manuel.ordenes.business.services;

import dev.manuel.ordenes.persistence.dto.CreateOrderDto;
import dev.manuel.ordenes.persistence.entities.Customer;
import dev.manuel.ordenes.persistence.entities.MyOrder;
import dev.manuel.ordenes.persistence.entities.OrderDetail;
import dev.manuel.ordenes.persistence.repositories.CustomerRepository;
import dev.manuel.ordenes.persistence.repositories.OrderDetailRepository;
import dev.manuel.ordenes.persistence.repositories.OrderRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lord_nightmare
 */
@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private OrderDetailRepository detailRepository;

  @Transactional(rollbackFor = Throwable.class)
  public String registerNewOrder(CreateOrderDto createOrderDto) throws Exception {
    if (createOrderDto.getOrderDetails().size() > 5) {
      throw new Exception("The order exceeds the maximum quantity of products");
    }
    var orderSaved = orderRepository.save(createOrderDto.getOrder());
    for (var orderDetail : createOrderDto.getOrderDetails()) {
      var customer = customerRepository.existProductByCustomer(
        createOrderDto.getOrder().getCustomerId().getCustomerId(),
        orderDetail.getProductId().getProductId()
      );
      if (customer.isEmpty()) {
        throw new Exception("A product is not available to the customer");
      }
      orderDetail.setOrderId(orderSaved);
      detailRepository.save(orderDetail);
    }
    return "New order registered";
  }

  @Transactional(readOnly = true)
  public List<MyOrder> findOrderByCustomer(int idCustomer) {
    List<MyOrder> orderByCustomer = orderRepository.findOrdersByCustomer(idCustomer);
    orderByCustomer.forEach((order) -> {
      detailRepository.findOrderDetailById(order.getOrderId());
    });
    return orderByCustomer;
  }
}
