/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST.service;

import REST.User;
import Session.Session;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Sizon
 */
@Stateless
@Path("rest.user")
public class UserFacadeREST extends AbstractFacade<User> {

    @PersistenceContext(unitName = "Restful5PU")
    private EntityManager em;

    public UserFacadeREST() {
        super(User.class);
    }

    @Path("getSession")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getSession() throws JSONException, ClassNotFoundException, SQLException 
    {
        JSONObject jsonObject = new JSONObject(); 
        String result = ""; 
        jsonObject.put("id", Session.id); 
        jsonObject.put("firstname", Session.firstname); 
        jsonObject.put("lastname", Session.lastname);
        jsonObject.put("address", Session.address); 
        jsonObject.put("phone", Session.phone); 
        jsonObject.put("type", Session.type);
        jsonObject.put("orders", Session.orders); 
        result += jsonObject+"";     
        System.out.println("aaaaaa");
        return Response.status(200).entity(result).build();
    }
    
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(User entity) {
        super.create(entity);
    }
    
    @Path("auth")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void auth(String s) throws JSONException, ClassNotFoundException, SQLException {
        System.out.println(s);
        User.auth(s);
        System.out.println("good");
        System.out.println(Session.firstname);
    }

    @Path("exit")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void exit() throws JSONException, ClassNotFoundException, SQLException {
        //super.create(entity);
        Session.firstname = ""; Session.lastname = ""; Session.phone = ""; Session.address = ""; Session.type = ""; Session.orders = ""; Session.id = ""; 
    }
    
    @Path("register")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(String s) throws JSONException, ClassNotFoundException, SQLException {
        //super.create(entity);
        System.out.println("sssss");
        User.insert(s);
        return Response.status(200).build();
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, User entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
