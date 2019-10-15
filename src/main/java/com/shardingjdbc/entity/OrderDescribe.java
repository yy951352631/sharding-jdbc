package com.shardingjdbc.entity;

/**
 * @author Wtq
 * @date 2019/10/14 - 14:38
 */

import javax.persistence.*;

/**
 * 这里是订单描述类
 */

@Entity
@Table(name = "T_ORDER_DESCRIBE")
public class OrderDescribe {

    @Id
    @Column(name = "order_id")
    private Long orderId;  //订单id

    @Column(name = "order_describe")
    private String orderDescribe;

    @Column(name = "customer_id")
    private Long customerId; //顾客id

    @Override
    public String toString() {
        return "OrderDescribe{" +
                "orderId=" + orderId +
                ", orderDescribe='" + orderDescribe + '\'' +
                ", customerId=" + customerId +
                '}';
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderDescribe() {
        return orderDescribe;
    }

    public void setOrderDescribe(String orderDescribe) {
        this.orderDescribe = orderDescribe;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public OrderDescribe() {
    }

    public OrderDescribe(Long orderId, String orderDescribe, Long customerId) {
        this.orderId = orderId;
        this.orderDescribe = orderDescribe;
        this.customerId = customerId;
    }
}
