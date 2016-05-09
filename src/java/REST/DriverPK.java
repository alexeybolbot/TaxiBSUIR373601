/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Sizon
 */
@Embeddable
public class DriverPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Car_idCar")
    private int caridCar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Vacant_idVacant")
    private int vacantidVacant;

    public DriverPK() {
    }

    public DriverPK(int id, int caridCar, int vacantidVacant) {
        this.id = id;
        this.caridCar = caridCar;
        this.vacantidVacant = vacantidVacant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCaridCar() {
        return caridCar;
    }

    public void setCaridCar(int caridCar) {
        this.caridCar = caridCar;
    }

    public int getVacantidVacant() {
        return vacantidVacant;
    }

    public void setVacantidVacant(int vacantidVacant) {
        this.vacantidVacant = vacantidVacant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) caridCar;
        hash += (int) vacantidVacant;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DriverPK)) {
            return false;
        }
        DriverPK other = (DriverPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.caridCar != other.caridCar) {
            return false;
        }
        if (this.vacantidVacant != other.vacantidVacant) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "REST.DriverPK[ id=" + id + ", caridCar=" + caridCar + ", vacantidVacant=" + vacantidVacant + " ]";
    }
    
}
