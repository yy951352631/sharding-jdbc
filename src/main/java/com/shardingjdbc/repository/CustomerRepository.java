package com.shardingjdbc.repository;

import com.shardingjdbc.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Wtq
 * @date 2019/10/12 - 16:46
 */
public interface CustomerRepository extends JpaRepository<Customer,Long>{
}
