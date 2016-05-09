package Database;

import CarBuilder.Cars;
import CarBuilder.CarsBuilder;
import CarBuilder.Director;
import CarBuilder.DriverCarsBuilder;
import Hibernate.HibernateUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Сommunication 
{
    private static final String URL ="jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME ="root";
    private static final String PASSWORD ="8774460";
    
    private static Connection con;
    private static PreparedStatement statement;
    private static ResultSet result;
    private static Statement stmt;
    
    public Сommunication() throws ClassNotFoundException, SQLException 
    {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(URL,USERNAME,PASSWORD); 
    }
    
    public String[] doQueryUserOut(String phone, String password) throws SQLException 
    {
        System.out.println("Выполняю запрос к DB doQuery:\n ");
        statement =  con.prepareStatement("SELECT * FROM user");
        result = statement.executeQuery();
        String masUser[] = {"","","","","","",""};
        while (result.next()) 
        {
            String phoneBase = result.getString("phone");
            String passwordBase = result.getString("password");
             System.out.println(phoneBase);
            if(phoneBase.equals(phone) && passwordBase.equals(password))
            {
                masUser[0] = result.getString("id");
                masUser[1] = result.getString("firstname");
                masUser[2] = result.getString(("lastname"));
                masUser[3] = result.getString(("address"));
                masUser[4] = result.getString(("phone"));
                masUser[5] = result.getString(("orders"));
                masUser[6] = result.getString(("type"));
                System.out.println("str");
                break;
            }
        }
        return masUser;
    }
    
    public int getCarId(String modelcar, String placescar, String colorcar) throws SQLException 
    {
        System.out.println("Выполняю запрос к DB doQuery:\n ");
        statement =  con.prepareStatement("SELECT * FROM car");
        result = statement.executeQuery();
        int A = 0;
        while (result.next()) 
        {
            if(result.getString("modelCar").equals(modelcar) && result.getString("placesCar").equals(placescar) && result.getString("colorCar").equals(colorcar))
            {
                A = result.getInt("id");
                break;
            }
        }
        return A;
    }
    
    
    public void doQueryIn(String query) throws SQLException 
    {
        System.out.println("Выполняю запрос к DB doQuerySQL:\n " + query);
        stmt = (Statement) con.createStatement();
        stmt.executeUpdate(query);
    }
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException 
    {
        if(con == null) 
            new Сommunication(); 
        return con;
    }
    
    public void userInsert(String firstname, String lastname, String address, String phone, String password) throws SQLException
    {
        doQueryIn("INSERT INTO user (`firstname`, `lastname`, `address`, `phone`, `password`, `type`, `orders`) "
                + "VALUES ('" + firstname + "', '" + lastname + "', '" + address + "', '" + phone + "', '" + password + "', '0', '0');");
        con.close();
    }
    public String[] userGet(String phone, String password) throws SQLException
    {
        String []mas = this.doQueryUserOut(phone, password);
        con.close();
        return mas;
    }
    public void carInsert(String modelCar, String placesCar, String colorCar) throws SQLException
    {
        this.doQueryIn("INSERT INTO car (`modelCar`, `placesCar`, `colorCar`) "
                + "VALUES ('" + modelCar + "', '" + placesCar + "', '" + colorCar + "');");
        con.close();
    }
    public void orderInsert(String idUser, String otkuda, String kuda, String summ, String km) throws SQLException
    {
        System.out.println("33333");
        Date now = new Date();
        this.doQueryIn("INSERT INTO order_test (`date`, `startAddress`, `finishAddress`, `cost`, `way`, `id_user`) "
                + "VALUES ('" + now.toString() + "', '" + otkuda + "', '" + kuda + "', '" + summ + "', '" + km + "', " + Integer.parseInt(idUser) + ");");
        con.close();
    }
    
    public void orderAccept(String idOrder, String idUser) throws SQLException
    {
        System.out.println("33333");
        this.doQueryIn("UPDATE order_test SET status='1', id_car='1' WHERE id = '"+idOrder+"'");
        if(!idUser.equals("0"))
        {
            this.doQueryIn("UPDATE user SET orders=orders+'1' WHERE id = '"+idUser+"'");
        }
        con.close();
    }
    public void vacantAccept(String idVac, String firstname, String lastname, String sex, String modelcar, String placescar, String colorcar, String contact) throws SQLException
    {
        System.out.println("33333");
        
        
        Director director = new Director();
        CarsBuilder driverCarsBuilder = new DriverCarsBuilder();
        
        director.setCarsomputerBuilder(driverCarsBuilder);
        director.constructCars(modelcar,Integer.valueOf(placescar),colorcar);
        
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
        
        int idCar = getCarId(modelcar,placescar,colorcar);
        this.doQueryIn("INSERT INTO driver (`firstname`, `lastname`, `sex`, `Car_idCar`, `contact`) "
                + "VALUES ('" + firstname + "', '" + lastname + "', '" + sex + "', " + idCar + ", '" + contact + "');");
        
        this.doQueryIn("DELETE FROM vacant WHERE id = "+idVac+"");
        con.close();
    }
    public void orderInsertGuest(String firstname, String lastname, String phone, String otkuda, String kuda, String summ, String km) throws SQLException
    {
        String info = firstname + " " + lastname + ", Тел: " + phone;
        Date now = new Date();
        this.doQueryIn("INSERT INTO order_test (`date`, `startAddress`, `finishAddress`, `cost`, `way`, `order_info`) "
                + "VALUES ('" + now.toString() + "', '" + otkuda + "', '" + kuda + "', '" + summ + "', '" + km + "', '" + info + "');");
        con.close();
    }
    
     public void vacancyInsert(String firstname, String lastname, String sex, String modelcar, String placescar, String colorcar, String contact) throws SQLException
    {
        Date now = new Date();
        this.doQueryIn("INSERT INTO vacant (`firstname`, `lastname`, `sex`, `date`, `modelcar`, `placescar`, `colorcar`, `contact`) "
                + "VALUES ('" + firstname + "', '" + lastname + "', '" + sex + "', '" + now.toString() + "', '" + modelcar + "', " + Integer.parseInt(placescar) + ", '" + colorcar + "', '" + contact + "');");
        con.close();
    }
     public String[][] orderGetOrders() throws SQLException
     {
         String [][] order = this.doQueryOrdersOut();
        con.close();
        return order;
     }
     
     public String[][] getCars() throws SQLException
     {
         String [][] order = this.doQueryCarsOut();
        con.close();
        return order;
     }
     
     public String[][] getVacancy() throws SQLException
     {
         String [][] order = this.doQueryVacancyOut();
        con.close();
        return order;
     }
     
     public String[][] doQueryOrdersOut() throws SQLException 
    {
        System.out.println("Выполняю запрос к DB doQuery:\n ");
        System.out.println("raz-2");
        statement =  con.prepareStatement("SELECT * FROM order_test");
        result = statement.executeQuery();
        int i = 0;
        System.out.println("raz-3");
        while (result.next()) 
        {
            System.out.println("raz-3");
            if(result.getInt("status")==0)
            { 
                i++;
            }
        }
        String masUser[][] = new String[i][9];
        statement =  con.prepareStatement("SELECT * FROM order_test");
        result = statement.executeQuery();
        int j = 0;
        while (result.next()) 
        {
            System.out.println("raz-3");
            if(result.getInt("status")==0)
            { 
                masUser[j][0] = result.getString("id");
                masUser[j][1] = result.getString("date");
                masUser[j][2] = result.getString("startAddress");
                masUser[j][3] = result.getString("finishAddress");
                masUser[j][4] = result.getString("cost");
                masUser[j][5] = result.getString("way");
                masUser[j][6] = result.getString("id_user");
                masUser[j][7] = result.getString("id_car");
                masUser[j][8] = result.getString("order_info");
                j++;
            }
        }
        
        return masUser;
    }
     
     public String[][] doQueryCarsOut() throws SQLException 
    {
        System.out.println("Выполняю запрос к DB doQuery:\n ");
        System.out.println("raz-2");
        statement =  con.prepareStatement("SELECT * FROM car");
        result = statement.executeQuery();
        int i = 0;
        System.out.println("raz-3");
        while (result.next()) 
        {
            System.out.println("raz-3");
            i++;
        }
        String masUser[][] = new String[i][3];
        statement =  con.prepareStatement("SELECT * FROM car");
        result = statement.executeQuery();
        int j = 0;
        while (result.next()) 
        {
            masUser[j][0] = result.getString("modelCar");
            masUser[j][1] = result.getString("placesCar");
            masUser[j][2] = result.getString("colorCar");
            j++;
        }
        
        return masUser;
    }
     
     public String[][] doQueryVacancyOut() throws SQLException 
    {
        System.out.println("Выполняю запрос к DB doQuery:\n ");
        statement =  con.prepareStatement("SELECT * FROM vacant");
        result = statement.executeQuery();
        int i = 0;
        while (result.next()) 
        {
            System.out.println("raz-9");
            i++;
        }
        String masUser[][] = new String[i][9];
        statement =  con.prepareStatement("SELECT * FROM vacant");
        result = statement.executeQuery();
        int j = 0;
        while (result.next()) 
        {
            System.out.println("raz-3");
             
            masUser[j][0] = result.getString("id");
            masUser[j][1] = result.getString("firstname");
            masUser[j][2] = result.getString("lastname");
            masUser[j][3] = result.getString("sex");
            masUser[j][4] = result.getString("date");
            masUser[j][5] = result.getString("modelcar");
            masUser[j][6] = result.getString("placescar");
            masUser[j][7] = result.getString("colorcar");
            masUser[j][8] = result.getString("contact");
            j++;            
        }
        
        return masUser;
    }
}
