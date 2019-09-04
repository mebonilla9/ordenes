/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.manuel.ordenes.business.controllers;

import dev.manuel.ordenes.business.constants.ERoute;
import dev.manuel.ordenes.business.services.OrderService;
import dev.manuel.ordenes.persistence.dto.CreateOrderDto;
import dev.manuel.ordenes.persistence.dto.OrderDto;
import dev.manuel.ordenes.persistence.entities.MyOrder;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lord_nightmare
 */
@RestController
public class OrderController {

  @Autowired
  private OrderService orderService;

  @Autowired
  private ModelMapper modelMapper;

  private static final Logger LOG = Logger.getLogger(OrderController.class.getName());

  /**
   * Create a new order with a quantity of order details
   * @param createOrderDto representation 
   * @return a message of order created confirmation
   */
  @PostMapping(ERoute.Orders.CREATE_ORDER)
  @ResponseStatus(HttpStatus.CREATED)
  public String createNewOrder(@RequestBody @Valid CreateOrderDto createOrderDto) {
    try {
      return orderService.registerNewOrder(createOrderDto);
    } catch (Exception e) {
      LOG.log(Level.SEVERE, e.getMessage());
      return "We can't create the order, you need contact with the application admin";
    }
  }

  /**
   * Retrieves the orders registered for a customer
   * @param idCustomer the identifier of the customer into the application
   * @return the list of orders with details of the customer
   */
  @GetMapping(ERoute.Orders.ORDER_BY_CUSTOMER)
  public List<OrderDto> findOrderByCustomer(@PathVariable("idcustomer") int idCustomer) {
    List<MyOrder> ordersByCustomer = orderService.findOrderByCustomer(idCustomer);
    return ordersByCustomer.stream()
      .map(order -> convertToOrderDto(order))
      .collect(Collectors.toList());
  }

  private OrderDto convertToOrderDto(MyOrder order) {
    OrderDto orderDto = modelMapper.map(order, OrderDto.class);
    orderDto.setCustomerId(null);
    orderDto.getOrderDetailList().forEach((detail) -> {
      detail.getProductId().getCustomerList().clear();
      detail.getProductId().getOrderDetailList().clear();
      detail.setOrderId(null);
    });
    return orderDto;
  }

}
