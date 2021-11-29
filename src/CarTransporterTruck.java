import java.util.ArrayList;

public class CarTransporterTruck <T extends Car> {
    private final int maxCars;
    private Scania truck;
    private ArrayList<T> carsTransported = new ArrayList<>();
    private int carCounter = 0;


    public CarTransporterTruck(int maxCars) {
        this.truck = new Scania();
        this.maxCars = maxCars;
    }


    public CarTransporterTruck() {
        this.truck = new Scania();
        this.maxCars = 6;
    }


    public double getDistanceToCar(T car) {
        double x1 = truck.getCoordinateX();
        double y1 = truck.getCoordinateY();
        double x2 = car.getCoordinateX();
        double y2 = car.getCoordinateY();
        return Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
    }

    public void loadCar(T car) {
        if (!truck.getRampUp() && (car.getDirection() == truck.getDirection()) && (getDistanceToCar(car) <= 2) && maxCars >= carCounter){
            carsTransported.add(car);
            carCounter += 1;
        }
        else if (truck.getRampUp())
            System.out.println("The truck's ramp must be down to be able to load a car");
        else if (carsTransported.get(maxCars - 1) != null)
            System.out.println("The transportation truck is full and cannot hold more cars");
        else
            System.out.println("The car to be loaded must be close enough to and be in the same direction as the transportation truck");
    }


    public void unloadCar() {
        if (!truck.getRampUp() && carsTransported.get(0) != null)
            for (int i = (maxCars - 1); i >= 0; i--) {
                if (carsTransported.get(i) != null) {
                    T car = carsTransported.get(i);
                    carsTransported.set(i, null);
                    car.setPosition(truck.getCoordinateX() - 1, truck.getCoordinateY() - 1);
                }
            }
        else if (truck.getRampUp())
            System.out.println("The truck's ramp must be down to be able to unload a car");
        else if (carsTransported.get(0) == null) {
            System.out.println("The transportation truck is empty and has no cars to unload");
        }
    }

    public void move() {
        truck.move();
        for (T car: carsTransported)
            car.move();
    }

    public void turnLeft() {
        truck.turnLeft();
        for (T car: carsTransported)
            car.turnLeft();
    }

    public void turnRight() {
        truck.turnRight();
        for (T car: carsTransported)
            car.turnLeft();
    }


    protected ArrayList<T> getCarsTransported() {
        return this.carsTransported;
    }

    // add more relevant methods (gas, break etc. etc.)

}
