/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Huy Trinh
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(controllers.AccountResource.class);
        resources.add(controllers.CategoriesResource.class);
        resources.add(controllers.OrdersDetailResource.class);
        resources.add(controllers.OrdersResource.class);
        resources.add(controllers.ProductsResource.class);
    }
    
}
