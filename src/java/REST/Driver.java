/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sizon
 */
@Entity
@Table(name = "driver")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Driver.findAll", query = "SELECT d FROM Driver d"),
    @NamedQuery(name = "Driver.findById", query = "SELECT d FROM Driver d WHERE d.driverPK.id = :id"),
    @NamedQuery(name = "Driver.findByFirstName", query = "SELECT d FROM Driver d WHERE d.firstName = :firstName"),
    @NamedQuery(name = "Driver.findByLastName", query = "SELECT d FROM Driver d WHERE d.lastName = :lastName"),
    @NamedQuery(name = "Driver.findBySex", query = "SELECT d FROM Driver d WHERE d.sex = :sex"),
    @NamedQuery(name = "Driver.findByDate", query = "SELECT d FROM Driver d WHERE d.date = :date"),
    @NamedQuery(name = "Driver.findByCaridCar", query = "SELECT d FROM Driver d WHERE d.driverPK.caridCar = :caridCar"),
    @NamedQuery(name = "Driver.findByVacantidVacant", query = "SELECT d FROM Driver d WHERE d.driverPK.vacantidVacant = :vacantidVacant")})
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DriverPK driverPK;
    @Size(max = 75)
    @Column(name = "firstName")
    private String firstName;
    @Size(max = 100)
    @Column(name = "lastName")
    private String lastName;
    @Size(max = 45)
    @Column(name = "sex")
    private String sex;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "Vacant_idVacant", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vacant vacant;
    @JoinColumn(name = "Car_idCar", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Car car;

    public Driver() {
    }

    public Driver(DriverPK driverPK) {
        this.driverPK = driverPK;
    }

    public Driver(int id, int caridCar, int vacantidVacant) {
        this.driverPK = new DriverPK(id, caridCar, vacantidVacant);
    }

    public DriverPK getDriverPK() {
        return driverPK;
    }

    public void setDriverPK(DriverPK driverPK) {
        this.driverPK = driverPK;
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

    public Vacant getVacant() {
        return vacant;
    }

    public void setVacant(Vacant vacant) {
        this.vacant = vacant;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (driverPK != null ? driverPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Driver)) {
            return false;
        }
        Driver other = (Driver) object;
        if ((this.driverPK == null && other.driverPK != null) || (this.driverPK != null && !this.driverPK.equals(other.driverPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "REST.Driver[ driverPK=" + driverPK + " ]";
    }
    
}
