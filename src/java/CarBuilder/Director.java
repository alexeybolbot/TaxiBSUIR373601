
package CarBuilder;

import CarBuilder.Cars;


public class Director {
    private CarsBuilder carsBuilder;

    public void setCarsomputerBuilder(CarsBuilder carsBuilder) {
    this.carsBuilder = carsBuilder;
    }

    public Cars getCars() {
    return carsBuilder.getCars();
    }

    public void constructCars(String model, int plaser, String color) {
    carsBuilder.createNewCars();
    carsBuilder.buildColorCar(color);
    carsBuilder.buildModelCar(model);
    carsBuilder.buildPlacesCar(plaser);
    }
}
