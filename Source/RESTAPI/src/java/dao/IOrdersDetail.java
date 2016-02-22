/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.OrdersDetail;

/**
 *
 * @author Huy Trinh
 */
public interface IOrdersDetail {
    boolean save(OrdersDetail inData);
    boolean update(OrdersDetail inData);
    List<OrdersDetail> findAll();
    OrdersDetail findByOrdersID(int id);
    OrdersDetail findByProductID(int id);
    OrdersDetail findByID(int id);
    
}
