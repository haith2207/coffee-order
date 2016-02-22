/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blo;

import dao.ICategories;
import java.util.List;
import models.Categories;

/**
 *
 * @author Huy Trinh
 */
public class CategoriesBLO {
    private  ICategories cateService;
    
    public  boolean save (Categories cate){
        boolean result = false;
        //validate
        result = cateService.save(cate);
        return result;
    }
    
    public boolean update (Categories cate)
    {
        boolean result = false;
        //validate
        result = cateService.update(cate);
        return result;
    }
    public boolean delete (int id)
    {
        boolean result = false;
        Categories cate = cateService.findOneByID(id);
        if (cate!=null)
        {
            cate.setDelete(true);
            result = cateService.update(cate);
        }
        return result;        
    }
    
    public List<Categories> findAll()
    {
       List<Categories> result =null;
       result= cateService.findAll();
       return  result;
    }
    
    public Categories searchByName (String name){
        Categories result = null;
        result = cateService.findByName(name);
        return result;
    }
    
    public Categories searchByID (int id){
        Categories result = null;
        result = cateService.findOneByID(id);
        return result;
    }
}
