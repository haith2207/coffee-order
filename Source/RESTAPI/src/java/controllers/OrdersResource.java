/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.imp.OrdersDAO;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import models.Orders;
import utils.Constant;

/**
 * REST Web Service
 *
 * @author Huy Trinh
 */
@Path("Orders")
public class OrdersResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of OrdersResource
     */
    public OrdersResource() {
    }
    private OrdersDAO ordersRepository = new OrdersDAO();

    @GET
    @Path("list-all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Orders> getAll() {
        return ordersRepository.findAll();
    }

    @POST
    @Path("insert")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")

    public Orders save(
            @FormParam("address") String address,
            @FormParam("accountID") int accountID,
            @FormParam("dateCreate") Date dateCreate,
            @FormParam("totalPrice") float totalPrice) {
        Orders orders = new Orders();
        orders.setAddress(address);
        orders.setStatus(Constant.Status.active);
        orders.setDelete(false);
        orders.setAccountID(accountID);
        orders.setDateCreate(dateCreate);
        orders.setTotalprice(totalPrice);
        ordersRepository.save(orders);
        return orders;
    }
@POST
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")

    public Orders update(
            @FormParam("address") String address,
            @FormParam("status") String status,
            @FormParam("isDelete") boolean isDelete,
            @FormParam("accountID") int accountID,
            @FormParam("dateCreate") Date dateCreate,
            @FormParam("totalPrice") float totalPrice) {
        Orders orders = new Orders();
        orders.setAddress(address);
        orders.setStatus(status);
        orders.setDelete(isDelete);
        orders.setAccountID(accountID);
        orders.setDateCreate(dateCreate);
        orders.setTotalprice(totalPrice);
        ordersRepository.update(orders);
        return orders;
    }
    @POST
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public boolean delete(int id) {
        boolean result = false;
        Orders orders = ordersRepository.findByID(id);
        //validate
        if (orders != null) {
            orders.setDelete(true);
            result = ordersRepository.update(orders);
        }
        return result;
    }
    @POST
    @Path("search-by-id")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public Orders searchByID (@FormParam("id") int id){
        Orders result = null;
        result = ordersRepository.findByID(id);
        return  result;
}
    @POST
    @Path("search-by-accountid")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
     public Orders searchByAccountID (@FormParam("id")int id){
        Orders result = null;
        result = ordersRepository.findByAccountID(id);
        return  result;
    }
     
     @POST
    @Path("search-by-address")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
     public Orders searchByAddress(@FormParam("id") String address){
        Orders result = null;
        result = ordersRepository.findByAddress(address);
        return result;
    }
}
