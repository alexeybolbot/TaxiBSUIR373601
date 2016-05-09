/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST.service;

import CarBuilder.*;
import Hibernate.HibernateUtil;
import REST.Car;
import REST.Order1;
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
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Sizon
 */
@Stateless
@Path("rest.car")
public class CarFacadeREST extends AbstractFacade<Car> {

    @PersistenceContext(unitName = "Restful5PU")
    private EntityManager em;

    public CarFacadeREST() {
        super(Car.class);
    }
    
    @Path("create")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(String s) throws JSONException {
        //super.create(entity);
        JSONObject obj = new JSONObject(s);
        Director director = new Director();
        CarsBuilder driverCarsBuilder = new DriverCarsBuilder();
        
        director.setCarsomputerBuilder(driverCarsBuilder);
        director.constructCars(obj.getString("modelCar"),obj.getInt("placesCar"),obj.getString("colorCar"));
        
        Cars c = director.getCars();
        
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();  
            ss.save(c);
            tr.commit();
            ss.close();
        }catch (Throwable ex) {
            // Log the exception.
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        return Response.status(200).build();
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Car entity) {
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
    public Car find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Car> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Car> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @Path("getCars")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getCars() throws JSONException, ClassNotFoundException, SQLException 
    {
        System.out.println("raz-2");
        String [][]orders = Car.getCars();
        
        String result = "";  
        for(int i=0; i<orders.length; i++)
        {
            JSONObject jsonObject = new JSONObject(); 
            jsonObject.put("modelcar", orders[i][0]); 
            jsonObject.put("placescar", orders[i][1]); 
            jsonObject.put("colorcar", orders[i][2]);
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
