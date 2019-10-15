package com.shardingjdbc.repository;

import com.shardingjdbc.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Wtq
 * @date 2019/10/11 - 17:41
 */
public interface OrderRepository extends JpaSpecificationExecutor<Order>,JpaRepository<Order,Long> {

    Order findByOrderIdAndCustomerId(Long orderId,Long CustomerId);

}
