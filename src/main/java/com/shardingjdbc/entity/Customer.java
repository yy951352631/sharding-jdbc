package com.shardingjdbc.entity;

import javax.persistence.*;

/**
 * @author Wtq
 * @date 2019/10/12 - 16:41
 */
@Entity
@Table(name = "T_CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId; //顾客id

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_type")
    private String customerType;

    public Customer(String customerName, String customerType) {
        this.customerName = customerName;
        this.customerType = customerType;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerType='" + customerType + '\'' +
                '}';
    }

    public Customer() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
}
