/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Products;

/**
 *
 * @author Huy Trinh
 */
public interface IProducts {

  
    boolean save(Products inData);
    boolean update (Products inData);
    List<Products> findAll();
    Products findByID(int id);
    Products findByCatID(int id);
    Products findByName(String name);
    Products findByPrice(float price);
       
}
