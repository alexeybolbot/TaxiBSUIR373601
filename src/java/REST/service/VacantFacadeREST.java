/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST.service;

import REST.Order1;
import REST.Vacant;
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
@Path("rest.vacant")
public class VacantFacadeREST extends AbstractFacade<Vacant> {

    @PersistenceContext(unitName = "Restful5PU")
    private EntityManager em;

    public VacantFacadeREST() {
        super(Vacant.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Vacant entity) {
        super.create(entity);
    }
    
    @Path("create")
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response create(String s) throws JSONException, ClassNotFoundException, SQLException {
        //super.create(entity);
        Vacant.insert(s);
        return Response.status(200).build();
    }
    
    @Path("accept")
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response accept(String s) throws JSONException, ClassNotFoundException, SQLException {
        //super.create(entity);
        Vacant.accept(s);
        return Response.status(200).build();
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Vacant entity) {
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
    public Vacant find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vacant> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vacant> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @Path("getVacant")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getAllVacancy() throws JSONException, ClassNotFoundException, SQLException 
    {
        String [][]orders = Vacant.getVacant();
        
        String result = "";  
        for(int i=0; i<orders.length; i++)
        {
            JSONObject jsonObject = new JSONObject(); 
            jsonObject.put("id", orders[i][0]); 
            jsonObject.put("firstname", orders[i][1]); 
            jsonObject.put("lastname", orders[i][2]);
            jsonObject.put("sex", orders[i][3]); 
            jsonObject.put("date", orders[i][4]); 
            jsonObject.put("modelcar", orders[i][5]);
            jsonObject.put("placescar", orders[i][6]); 
            jsonObject.put("colorcar", orders[i][7]); 
            jsonObject.put("contact", orders[i][8]); 
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
