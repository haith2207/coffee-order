/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Categories;

/**
 *
 * @author Huy Trinh
 */
public interface ICategories {
    boolean save(Categories inData);
    boolean update(Categories inData);
    List<Categories> findAll();
    Categories findOneByID(int id);
    public  Categories findByName(String name);
}
