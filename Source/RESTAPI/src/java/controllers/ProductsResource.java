/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.imp.ProductsDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import models.Products;
import utils.Constant;

/**
 * REST Web Service
 *
 * @author Huy Trinh
 */
@Path("products")
public class ProductsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductsResource
     */
    public ProductsResource() {
    }

    private ProductsDAO productRepository = new ProductsDAO();

    @GET
    @Path("list-all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Products> getAll() {
        return productRepository.findAll();
    }

    @POST
    @Path("insert")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public Products save(
            @FormParam("name") String name,
            @FormParam("price") float price,
            @FormParam("imageLink") String imageLink,
            @FormParam("description") String description,
            @FormParam("coverLink") String coverLink,
            @FormParam("catID") int catID
    //@FormParam ("status") String status,
    //@FormParam ("isDelete") String isDelete 
    ) {
        Products product = new Products();
        product.setName(name);
        product.setPrice(price);
        product.setImageLink(imageLink);
        product.setImageLink(imageLink);
        product.setDescriptions(description);
        product.setCoverLink(coverLink);
        product.setCatID(catID);
        product.setStatus(Constant.Status.active);
        product.setDelete(false);
        productRepository.save(product);
        return product;
    }

    @POST
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public Products update(
            @FormParam("name") String name,
            @FormParam("price") float price,
            @FormParam("imageLink") String imageLink,
            @FormParam("description") String description,
            @FormParam("coverLink") String coverLink,
            @FormParam("catID") int catID,
            @FormParam("status") String status,
            @FormParam("isDelete") boolean isDelete) {
        Products product = new Products();
        product.setName(name);
        product.setPrice(price);
        product.setImageLink(imageLink);
        product.setImageLink(imageLink);
        product.setDescriptions(description);
        product.setCoverLink(coverLink);
        product.setCatID(catID);
        product.setStatus(status);
        product.setDelete(isDelete);
        productRepository.update(product);
        return product;
    }

    @POST
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public boolean delete(@FormParam("id") int id) {
        boolean result = false;
        Products products = productRepository.findByID(id);
        if (products != null) {
            products.setDelete(true);
            result = productRepository.update(products);

        }
        return result;
    }

    @POST
    @Path("search-by-id")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public Products searchByID(@FormParam("id") int id) {
        Products result = null;
        result = productRepository.findByID(id);
        return result;
    }

    @POST
    @Path("search-by-catid")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public Products searchByCatID(@FormParam("id") int id) {
        Products result = null;
        result = productRepository.findByCatID(id);
        return result;
    }

    @POST
    @Path("search-by-name")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public Products searchByName(@FormParam("name") String name) {
        Products result = null;
        result = productRepository.findByName(name);
        return result;
    }

    @POST
    @Path("search-by-price")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public Products searchByPrice(@FormParam("price") float price) {
        Products result = null;
        result = productRepository.findByPrice(price);
        return result;
    }
}
