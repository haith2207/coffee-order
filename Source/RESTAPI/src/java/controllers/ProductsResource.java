/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import models.Products;

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

    /**
     * Retrieves representation of an instance of controllers.ProductsResource
     * @return an instance of models.Products
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Products getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ProductsResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Products content) {
    }
}
