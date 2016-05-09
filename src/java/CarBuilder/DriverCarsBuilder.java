
package CarBuilder;


public class DriverCarsBuilder extends CarsBuilder{

    public DriverCarsBuilder() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void buildModelCar(String model) {
      cars.setModelCar(model);
    }
    public void buildPlacesCar(int places) {
      cars.setPlacesCar(places);
    }
    public void buildColorCar(String color) {
      cars.setColorCar(color);
    }    

}
