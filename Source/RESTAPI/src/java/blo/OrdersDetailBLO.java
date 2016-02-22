/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blo;

import dao.IOrdersDetail;
import java.util.List;
import models.OrdersDetail;

/**
 *
 * @author Huy Trinh
 */
public class OrdersDetailBLO {

    private IOrdersDetail ordersDetailService;

    public boolean save(OrdersDetail orderDetail) {
        boolean result = false;
        //validate
        result = ordersDetailService.save(orderDetail);
        return result;
    }

    public boolean update(OrdersDetail orderDetail) {
        boolean result = false;
        //validate
        result = ordersDetailService.update(orderDetail);
        return result;
    }
public List<OrdersDetail> findAll()
{
    List<OrdersDetail> result = null;
    result = ordersDetailService.findAll();
    return  result;
}
   public OrdersDetail findByOrdersID (int id){
       OrdersDetail result =null;
       result =ordersDetailService.findByOrdersID(id);
       return result;
   }
   public OrdersDetail findByProductID (int id){
       OrdersDetail result =null;
       result =ordersDetailService.findByProductID(id);
       return result;
   }
   public OrdersDetail findByID (int id){
       OrdersDetail result =null;
       result =ordersDetailService.findByID(id);
       return result;
   }
}
