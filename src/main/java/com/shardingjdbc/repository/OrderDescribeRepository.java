package com.shardingjdbc.repository;

import com.shardingjdbc.entity.OrderDescribe;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Wtq
 * @date 2019/10/14 - 15:12
 */
public interface OrderDescribeRepository extends JpaRepository<OrderDescribe,Long> {
}
