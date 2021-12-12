/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.retoDos.Order;

import com.example.retoDos.Order.OrderRepository;
import com.example.retoDos.Order.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




/**
 *
 * @author john
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    public List<Order> getAll(){
        return orderRepository.getAll();
     
    }
    
    public Optional<Order> getOrder(int id){
        return orderRepository.getOrder(id);
    }
    
    public Order create(Order order){
        
        
        if(order.getId() == null) {
            return order;
            
        }else{
            return orderRepository.create(order);            
        
        }        
    }
    
    public Order update(Order order) {

        if (order.getId() != null) {
            Optional<Order> dbOrder = orderRepository.getOrder(order.getId());
            if (!dbOrder.isEmpty()) {
                if (order.getStatus() != null) {
                    dbOrder.get().setStatus(order.getStatus());
                }
                
                orderRepository.update(dbOrder.get());
                return dbOrder.get();
            } else {
                return order;
            }
        
        }else{
            return order;
        }
    }
        public boolean delete(int id){
        Boolean aboolean= getOrder(id).map(order -> {
            orderRepository.delete(order);
            return true;
        }).orElse(false);
        return aboolean;
    }
    
    public List<Order> findByZone(String zona){
        return orderRepository.findByZone(zona);
    }
    public List<Order> ordersSalesManByDate(String dateStr, int id) {
        return orderRepository.ordersSalesManByDate(dateStr, id);
    }
    
    public List<Order> ordersSalesManByState(String state, Integer id) {
        return orderRepository.ordersSalesManByState(state, id);
    }   
}
