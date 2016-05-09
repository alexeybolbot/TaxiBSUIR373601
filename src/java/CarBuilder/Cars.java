package CarBuilder;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "car")
public class Cars implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    int id ;
    private String modelCar;  
    int placesCar;
    private String colorCar; 

    public Cars() {
    }

    public Cars(int id, String modelCar, int placesCar, String colorCar) {
        this.id = id;
        this.modelCar = modelCar;
        this.placesCar = placesCar;
        this.colorCar = colorCar;
    }
    public void setId(int id) { this.id = id;}
    public void setModelCar(String modelCar) {this.modelCar = modelCar;}
    public void setPlacesCar(int placesCar) {this.placesCar = placesCar;}
    public void setColorCar(String colorCar) {this.colorCar = colorCar;}
      
}
