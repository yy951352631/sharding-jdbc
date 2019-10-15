package com.shardingjdbc.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Wtq
 * @date 2019/10/11 - 17:28
 */
@Entity
@Table(name = "T_ORDER")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;  //订单id
    @Column(name = "customer_id")
    private Long customerId; //顾客id
    @Column(name = "totla_price")
    private Double totlaPrice;//总价
    @Column(name = "status")
    private String status;  //订单状态

    //下面定义我们的订单描述
    //Order是关系维护端，如果删除order则级联删除orderDescribe
    @OneToOne(fetch = FetchType.EAGER,targetEntity = OrderDescribe.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id",referencedColumnName = "order_id",table = "t_order_describe")
    private OrderDescribe orderDescribe;

    public Order() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Double getTotlaPrice() {
        return totlaPrice;
    }

    public void setTotlaPrice(Double totlaPrice) {
        this.totlaPrice = totlaPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OrderDescribe getOrderDescribe() {
        return orderDescribe;
    }

    public void setOrderDescribe(OrderDescribe orderDescribe) {
        this.orderDescribe = orderDescribe;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", totlaPrice=" + totlaPrice +
                ", status='" + status + '\'' +
                ", orderDescribe=" + orderDescribe +
                '}';
    }

    public Order(Long customerId, Double totlaPrice, String status, OrderDescribe orderDescribe) {
        this.customerId = customerId;
        this.totlaPrice = totlaPrice;
        this.status = status;
        this.orderDescribe = orderDescribe;
    }
}
