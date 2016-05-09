
package CarBuilder;

import CarBuilder.Cars;

abstract public class CarsBuilder {
    protected Cars cars;

    public Cars getCars() { 
      return cars; 
    }

    public void createNewCars() {
      cars = new Cars(); 
    }

    public abstract void buildModelCar(String model);
    public abstract void buildPlacesCar(int placer);
    public abstract void buildColorCar(String car);    
}
