/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import Database.Сommunication;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Sizon
 */
@Entity
@Table(name = "vacant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacant.findAll", query = "SELECT v FROM Vacant v"),
    @NamedQuery(name = "Vacant.findById", query = "SELECT v FROM Vacant v WHERE v.id = :id"),
    @NamedQuery(name = "Vacant.findByFirstName", query = "SELECT v FROM Vacant v WHERE v.firstName = :firstName"),
    @NamedQuery(name = "Vacant.findByLastName", query = "SELECT v FROM Vacant v WHERE v.lastName = :lastName"),
    @NamedQuery(name = "Vacant.findBySex", query = "SELECT v FROM Vacant v WHERE v.sex = :sex"),
    @NamedQuery(name = "Vacant.findByDate", query = "SELECT v FROM Vacant v WHERE v.date = :date"),
    @NamedQuery(name = "Vacant.findByModelCar", query = "SELECT v FROM Vacant v WHERE v.modelCar = :modelCar"),
    @NamedQuery(name = "Vacant.findByPlacesCar", query = "SELECT v FROM Vacant v WHERE v.placesCar = :placesCar"),
    @NamedQuery(name = "Vacant.findByColorCar", query = "SELECT v FROM Vacant v WHERE v.colorCar = :colorCar")})
public class Vacant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "firstName")
    private String firstName;
    @Size(max = 45)
    @Column(name = "lastName")
    private String lastName;
    @Size(max = 45)
    @Column(name = "sex")
    private String sex;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 45)
    @Column(name = "modelCar")
    private String modelCar;
    @Column(name = "placesCar")
    private Integer placesCar;
    @Size(max = 45)
    @Column(name = "colorCar")
    private String colorCar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacant")
    private Collection<Driver> driverCollection;

    public Vacant() {
    }

    public Vacant(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public Integer getPlacesCar() {
        return placesCar;
    }

    public void setPlacesCar(Integer placesCar) {
        this.placesCar = placesCar;
    }

    public String getColorCar() {
        return colorCar;
    }

    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }

    @XmlTransient
    public Collection<Driver> getDriverCollection() {
        return driverCollection;
    }

    public void setDriverCollection(Collection<Driver> driverCollection) {
        this.driverCollection = driverCollection;
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
        if (!(object instanceof Vacant)) {
            return false;
        }
        Vacant other = (Vacant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "REST.Vacant[ id=" + id + " ]";
    }
    
    public static void insert(String s) throws JSONException, ClassNotFoundException, SQLException 
    {        
        JSONObject order = new JSONObject(s);
        Сommunication connector = new Сommunication();
        connector.vacancyInsert(order.getString("firstname"), order.getString("lastname"), order.getString("sex"), 
                order.getString("modelcar"), order.getString("placescar"), order.getString("colorcar"),order.getString("contact")); 
    } 
    
    public static String[][] getVacant() throws JSONException, ClassNotFoundException, SQLException 
    {        
        Сommunication connector = new Сommunication();
        return connector.getVacancy(); 
    } 
    
    public static void accept(String s) throws JSONException, ClassNotFoundException, SQLException 
    {        
        JSONObject order = new JSONObject(s);
        Сommunication connector = new Сommunication();
        connector.vacantAccept(order.getString("idVac"), order.getString("firstname"), order.getString("lastname"), order.getString("sex"), order.getString("modelcar"), order.getString("placescar"), order.getString("colorcar"), order.getString("contact")); 
    }   
    
}
