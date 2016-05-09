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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.json.JSONException;

/**
 *
 * @author Sizon
 */
@Entity
@Table(name = "car")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c"),
    @NamedQuery(name = "Car.findById", query = "SELECT c FROM Car c WHERE c.id = :id"),
    @NamedQuery(name = "Car.findByModelCar", query = "SELECT c FROM Car c WHERE c.modelCar = :modelCar"),
    @NamedQuery(name = "Car.findByPlacesCar", query = "SELECT c FROM Car c WHERE c.placesCar = :placesCar"),
    @NamedQuery(name = "Car.findByColorCar", query = "SELECT c FROM Car c WHERE c.colorCar = :colorCar")})
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "modelCar")
    private String modelCar;
    @Column(name = "placesCar")
    private Integer placesCar;
    @Size(max = 45)
    @Column(name = "colorCar")
    private String colorCar;
    @OneToMany(mappedBy = "caridCar")
    private Collection<Order1> order1Collection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
    private Collection<Driver> driverCollection;

    public Car() {
    }

    public Car(Integer id) {
        this.id = id;
    }

    public Car(Integer id, String modelCar) {
        this.id = id;
        this.modelCar = modelCar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    public Collection<Order1> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order1> order1Collection) {
        this.order1Collection = order1Collection;
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
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    public static String[][] getCars() throws JSONException, ClassNotFoundException, SQLException 
    {        
        Сommunication connector = new Сommunication();
        return connector.getCars(); 
    } 

    @Override
    public String toString() {
        return "REST.Car[ id=" + id + " ]";
    }
    
}
