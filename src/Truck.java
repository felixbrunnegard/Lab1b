import java.awt.*;

public abstract class Truck extends Vehicle {
    private int nrDoors;
    private boolean rampUp;

    public Truck(double enginePower, double currentSpeed, Color color, String modelName, int x, int y, int direction, int nrDoors, boolean rampUp) {
        super(enginePower,currentSpeed,color,modelName,x,y,direction);
        this.nrDoors = nrDoors;
        this.rampUp = rampUp;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public boolean getRampUp() {
        return rampUp;
    }

    protected void setRampUp() {
        if (!isMoving())
            rampUp = true;
        else
            System.out.println("The platform cannot be raised while the truck is in motion");
    }

    protected void setRampDown() {
        rampUp = false;
    }

    @Override
    public void move() {
        if (!rampUp)
            super.move();
        else
            System.out.println("The truck cannot move while the platform is raised");
    }

}
