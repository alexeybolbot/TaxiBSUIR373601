/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST.service;

import REST.Order1;
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
@Path("rest.order1")
public class Order1FacadeREST extends AbstractFacade<Order1> {

    @PersistenceContext(unitName = "Restful5PU")
    private EntityManager em;

    public Order1FacadeREST() {
        super(Order1.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Order1 entity) {
        super.create(entity);
    }
    
    @Path("create")
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response create(String s) throws JSONException, ClassNotFoundException, SQLException {
        //super.create(entity);
        Order1.insert(s);
        return Response.status(200).build();
    }
    
    @Path("accept")
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response accept(String s) throws JSONException, ClassNotFoundException, SQLException {
        //super.create(entity);
        Order1.accept(s);
        return Response.status(200).build();
    }
    
    @Path("createGuest")
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response createGuest(String s) throws JSONException, ClassNotFoundException, SQLException {
        //super.create(entity);
        System.out.println("aaaa");
        Order1.insertGuest(s);
        return Response.status(200).build();
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Order1 entity) {
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
    public Order1 find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Order1> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Order1> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @Path("getOrders")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getOrders() throws JSONException, ClassNotFoundException, SQLException 
    {
        System.out.println("raz-2");
        String [][]orders = Order1.getOrders();
        
        String result = "";  
        for(int i=0; i<orders.length; i++)
        {
            JSONObject jsonObject = new JSONObject(); 
            jsonObject.put("id", orders[i][0]); 
            jsonObject.put("date", orders[i][1]); 
            jsonObject.put("startAddress", orders[i][2]);
            jsonObject.put("finishAddress", orders[i][3]); 
            jsonObject.put("cost", orders[i][4]); 
            jsonObject.put("way", orders[i][5]);
            jsonObject.put("id_user", orders[i][6]); 
            jsonObject.put("id_car", orders[i][7]); 
            jsonObject.put("order_info", orders[i][8]); 
            if(i==orders.length-1)
                result += jsonObject+""; 
            else
                result += jsonObject+"";             
        }
        System.out.println(result);
        return Response.status(200).entity(result).build();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
