/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blo;

import dao.IProducts;
import java.util.List;
import models.Products;

/**
 *
 * @author Huy Trinh
 */
public class ProductsBLO {

    private IProducts productsService;

    public boolean save(Products products) {
        boolean result = false;
        result = productsService.save(products);
        return result;
    }

    public boolean update(Products products) {
        boolean result = false;
        result = productsService.update(products);
        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        Products products = productsService.findByID(id);
        if (products != null) {
            products.setDelete(true);
            result = productsService.update(products);

        }
        return result;
    }
    
    public List<Products> findAll(){
       List<Products> result = null;
       result = productsService.findAll();
       return  result;
    }
    
    public Products searchByID(int id){
        Products result = null;
        result = productsService.findByID(id);
        return result;
    }
    
    public Products searchByCatID(int id){
        Products result = null;
        result = productsService.findByCatID(id);
        return result;
    }
    
    public Products searchByName(String name){
        Products result = null;
        result = productsService.findByName(name);
        return result;
    }
    
    public Products searchByPrice(float price){
        Products result = null;
        result = productsService.findByPrice(price);
        return result;
    }
}
