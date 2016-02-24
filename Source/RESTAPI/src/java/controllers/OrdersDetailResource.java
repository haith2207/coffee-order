/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.imp.OrdersDetailDAO;
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
import models.OrdersDetail;

/**
 * REST Web Service
 *
 * @author Huy Trinh
 */
@Path("OrdersDetail")
public class OrdersDetailResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of OrdersDetailResource
     */
    public OrdersDetailResource() {
    }

    private OrdersDetailDAO ordersDetailRepository = new OrdersDetailDAO();

    @GET
    @Path("list-all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrdersDetail> getAll() {
        return ordersDetailRepository.findAll();
    }

    @POST
    @Path("insert")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public OrdersDetail save(
            @FormParam("orderID") int oderID,
            @FormParam("productID") int productID,
            @FormParam("quantity") int quantity,
            @FormParam("total") float total) {
        OrdersDetail detail = new OrdersDetail();
        detail.setOrderID(oderID);
        detail.setProductID(productID);
        detail.setQuantity(quantity);
        detail.setTotal(total);
        ordersDetailRepository.save(detail);
        return detail;
    }

    @POST
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")

    public OrdersDetail update(
            @FormParam("orderID") int oderID,
            @FormParam("productID") int productID,
            @FormParam("quantity") int quantity,
            @FormParam("total") float total) {
        OrdersDetail detail = new OrdersDetail();
        detail.setOrderID(oderID);
        detail.setProductID(productID);
        detail.setQuantity(quantity);
        detail.setTotal(total);
        ordersDetailRepository.update(detail);
        return detail;
    }

    @POST
    @Path("search-by-id")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public OrdersDetail findByID(@FormParam("id") int id) {
        OrdersDetail result = null;
        result = ordersDetailRepository.findByID(id);
        return result;
    }

    @POST
    @Path("search-by-ordersid")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public OrdersDetail findByOrdersID(@FormParam("id") int id) {
        OrdersDetail result = null;
        result = ordersDetailRepository.findByOrdersID(id);
        return result;
    }

    @POST
    @Path("search-by-productid")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public OrdersDetail findByProductID(int id) {
        OrdersDetail result = null;
        result = ordersDetailRepository.findByProductID(id);
        return result;
    }

}
