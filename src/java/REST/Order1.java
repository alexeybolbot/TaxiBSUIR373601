/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import Database.Сommunication;
import java.io.Serializable;
import java.sql.SQLException;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Sizon
 */
@Entity
@Table(name = "order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o"),
    @NamedQuery(name = "Order1.findById", query = "SELECT o FROM Order1 o WHERE o.id = :id"),
    @NamedQuery(name = "Order1.findByDate", query = "SELECT o FROM Order1 o WHERE o.date = :date"),
    @NamedQuery(name = "Order1.findByStartAddress", query = "SELECT o FROM Order1 o WHERE o.startAddress = :startAddress"),
    @NamedQuery(name = "Order1.findByFinishAddress", query = "SELECT o FROM Order1 o WHERE o.finishAddress = :finishAddress"),
    @NamedQuery(name = "Order1.findByCost", query = "SELECT o FROM Order1 o WHERE o.cost = :cost"),
    @NamedQuery(name = "Order1.findByWay", query = "SELECT o FROM Order1 o WHERE o.way = :way"),
    @NamedQuery(name = "Order1.findByStatus", query = "SELECT o FROM Order1 o WHERE o.status = :status"),
    @NamedQuery(name = "Order1.findByGuestInfo", query = "SELECT o FROM Order1 o WHERE o.guestInfo = :guestInfo")})
public class Order1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "date")
    private String date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "startAddress")
    private String startAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "finishAddress")
    private String finishAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cost")
    private String cost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "way")
    private String way;
    @Column(name = "status")
    private Integer status;
    @Size(max = 300)
    @Column(name = "guest_info")
    private String guestInfo;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "Car_idCar", referencedColumnName = "id")
    @ManyToOne
    private Car caridCar;

    public Order1() {
    }

    public Order1(Integer id) {
        this.id = id;
    }

    public Order1(Integer id, String date, String startAddress, String finishAddress, String cost, String way) {
        this.id = id;
        this.date = date;
        this.startAddress = startAddress;
        this.finishAddress = finishAddress;
        this.cost = cost;
        this.way = way;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public String getFinishAddress() {
        return finishAddress;
    }

    public void setFinishAddress(String finishAddress) {
        this.finishAddress = finishAddress;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getGuestInfo() {
        return guestInfo;
    }

    public void setGuestInfo(String guestInfo) {
        this.guestInfo = guestInfo;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Car getCaridCar() {
        return caridCar;
    }

    public void setCaridCar(Car caridCar) {
        this.caridCar = caridCar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "REST.Order1[ id=" + id + " ]";
    }
    
    public static void insert(String s) throws JSONException, ClassNotFoundException, SQLException 
    {        
        JSONObject order = new JSONObject(s);
        Сommunication connector = new Сommunication();
        connector.orderInsert(order.getString("idUser"), order.getString("otkuda"), order.getString("kuda"), 
                order.getString("summ"), order.getString("km")); 
    }   
    
    public static void accept(String s) throws JSONException, ClassNotFoundException, SQLException 
    {        
        JSONObject order = new JSONObject(s);
        Сommunication connector = new Сommunication();
        connector.orderAccept(order.getString("idOrder"), order.getString("idClient")); 
    }   
     
     public static void insertGuest(String s) throws JSONException, ClassNotFoundException, SQLException 
    {        
        JSONObject order = new JSONObject(s);
        Сommunication connector = new Сommunication();
        connector.orderInsertGuest(order.getString("firstname"), order.getString("lastname"), order.getString("phone"), 
                order.getString("otkuda"), order.getString("kuda"), order.getString("summ"), order.getString("km")); 
    } 
    public static String[][] getOrders() throws JSONException, ClassNotFoundException, SQLException 
    {        
        Сommunication connector = new Сommunication();
        return connector.orderGetOrders(); 
    } 
}
