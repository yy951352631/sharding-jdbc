package com.shardingjdbc;

import com.shardingjdbc.entity.Customer;
import com.shardingjdbc.entity.Dictionary;
import com.shardingjdbc.entity.Order;
import com.shardingjdbc.entity.OrderDescribe;
import com.shardingjdbc.repository.CustomerRepository;
import com.shardingjdbc.repository.DictionaryRepository;
import com.shardingjdbc.repository.OrderDescribeRepository;
import com.shardingjdbc.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingJdbcApplicationTests {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Autowired
    private OrderDescribeRepository orderDescribeRepository;


    @Test
    public void test01() {
        for (int i = 1; i < 10; i++) {
            long id = i;
            Order order = new Order();
            order.setCustomerId(id);
            order.setStatus("成功");
            order.setTotlaPrice(152.6);
            repository.save(order);
        }
    }


    @Test
    public void test02() {
        for (int i = 1; i < 5; i++) {
            long id = i;
            Customer customer = new Customer();
            customer.setCustomerName("顾客" + i);
            customer.setCustomerType("散客");
            customerRepository.save(customer);
        }
    }

    /**
     * 测试自己在dao层定义的方法
     */
    @Test
    public void test03() {
//        List<Order> list = repository.findAll();
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("************"+list.get(i)+"*************");
//        }

        Order order = new Order();
        order.setCustomerId(2L);
        Order byOrderIdAndCustomerId = repository.findByOrderIdAndCustomerId(389836685258522624L, 2L);
        System.out.println(byOrderIdAndCustomerId + "*******");
    }

    /**
     * 测试查询通过order_id查询单个订单（Jpa接口定义）
     */
    @Test
    public void test04() {
        Order findByOrderId = repository.findById(389836685258522624L).orElse(null);
        System.out.println(findByOrderId + "********");
    }

    /**
     * 测试我们的公共表
     */
    @Test
    public void test05() {
        Dictionary dictionary = new Dictionary();
        dictionary.setType("普通字典");
        dictionary.setCode("ord");
        dictionary.setValue("oo");
        dictionaryRepository.save(dictionary);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void test06(){
        for(long i = 0; i < 2 ; i++)
        {
            Order order = new Order();
            order.setCustomerId(i*3);
            order.setStatus("成功");
            order.setTotlaPrice(152.6*i);
            Order save = repository.save(order);

            OrderDescribe orderDescribe = new OrderDescribe();
            orderDescribe.setOrderId(save.getOrderId());
            orderDescribe.setCustomerId(save.getCustomerId());
            orderDescribe.setOrderDescribe("这里是订单描述");

            orderDescribeRepository.save(orderDescribe);
        }
    }
    /**
     * 测试添加一个orderDescribe
     */
    @Test
    @Transactional
//    @Rollback(false)
    public void test07(){

        OrderDescribe orderDescribe = new OrderDescribe();
        orderDescribe.setOrderId(10086L);
        orderDescribe.setOrderDescribe("这里是订单描述");
        List<OrderDescribe> list = new ArrayList<>();
        list.add(orderDescribe);

        orderDescribeRepository.saveAll(list);
    }

    /**
     * 测试一对一级联查询
     */
    @Test
    public void test08(){

        List<Order> list = repository.findAll();

        for(int i = 0; i < list.size();i++)
        {
            System.out.println("*********"+list.get(i)+"*********");
        }
    }

}