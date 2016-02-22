/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blo;

import dao.IOrders;
import java.util.List;
import models.Orders;

/**
 *
 * @author Huy Trinh
 */
public class OrdersBLO {

    private IOrders ordersService;

    public boolean save(Orders order) {
        boolean result = false;
        //validate
        result = ordersService.save(order);
        return result;
    }

    public boolean update(Orders order) {
        boolean result = false;
        //validate
        result = ordersService.update(order);
        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        Orders orders = ordersService.findByID(id);
        //validate
        if (orders != null) {
            orders.setDelete(true);
            result = ordersService.update(orders);
        }

        return result;
    }
    public List<Orders> findAll(){
        List<Orders> result = null;
        result = ordersService.findAll();
        return  result;
    }
    
    public Orders searchByID (int id){
        Orders result = null;
        result = ordersService.findByID(id);
        return  result;
    }
    public Orders searchByAccountID (int id){
        Orders result = null;
        result = ordersService.findByAccountID(id);
        return  result;
    }
    public Orders searchByAddress(String address){
        Orders result = null;
        result = ordersService.findByAddress(address);
        return result;
    }
}
