/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Orders;

/**
 *
 * @author Huy Trinh
 */
public interface IOrders {
    boolean save(Orders inData);
    boolean update(Orders inData);
    List<Orders> findAll();
    Orders findByAddress(String address);
    Orders findByID (int id);
    Orders findByAccountID (int id);
}
