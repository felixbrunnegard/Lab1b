import java.awt.*;

public abstract class Car extends Vehicle {
    private int nrDoors; // Number of doors on the car

    public Car(double enginePower, double currentSpeed, Color color, String modelName, int x, int y, int direction, int nrDoors){
        super(enginePower, currentSpeed, color, modelName, x, y, direction);
        this.nrDoors = nrDoors;
    }

    public int getNrDoors() {
        return nrDoors;
    }


}
