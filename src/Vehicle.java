import java.awt.*;

public class Vehicle implements Movable {
    private double enginePower; // Engine power of the car
    private double currentSpeed; // Current speed of the car
    private Color color; // Color of the car
    private String modelName; // The model name of the car
    private double x; // x-coordinate of car
    private double y; // y-coordinate of car
    private int direction;


    public Vehicle(double enginePower, double currentSpeed, Color color, String modelName, int x, int y, int direction) {
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Vehicle() {
        this.enginePower = 100;
    }

    public void move() {
        if (direction == 0) { // or a switch statement ??
            y += currentSpeed;  // probably not complete but y will remain proportional to currentSpeed when direction is north or south
        } else if (direction == 1) {
            x += currentSpeed;
        } else if (direction == 2) {
            y -= currentSpeed;
        } else if (direction == 3) {
            x -= currentSpeed;
        }
    }

    public void turnLeft() {
        if (direction == 0) { // or a switch statement ??
            direction = 3; // if turns left, direction changes counter-clockwise
        } else if (direction == 1) {
            direction = 0;
        } else if (direction == 2) {
            direction = 1;
        } else if (direction == 3) {
            direction = 2;
        }
    }

    public void turnRight() {
        if (direction == 0) { // or a switch statement ??
            direction = 1;  // if turns right, direction changes clockwise
        } else if (direction == 1) {
            direction = 2;
        } else if (direction == 2) {
            direction = 3;
        } else if (direction == 3) {
            direction = 0;
        }
    }


    public boolean isMoving() {
        return currentSpeed != 0;
    }

    public double getCoordinateX() {
        return x;
    }

    public double getCoordinateY() {
        return y;
    }

    protected void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void startEngine() {     // starts engine of car and sets its speed to 0.1
        currentSpeed = 0.1;
    }

    public void stopEngine() {      // stops engine of car and sets its speed to 0
        currentSpeed = 0;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void setCurrentSpeed(double CurrentSpeed) {          // sets currentSpeed to parameter value which
        if (CurrentSpeed >= 0 && CurrentSpeed <= enginePower)     // must be between 0 and value of enginePower
            this.currentSpeed = CurrentSpeed;
    }


    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public String getModelName() {
        return modelName;
    }

   public void incrementSpeed(double amount) {  // increments speed of car objects
        double newSpeed = Math.min(currentSpeed * amount, enginePower);
        if (newSpeed > currentSpeed)
            setCurrentSpeed(newSpeed);        // else print something / throw exception?
    }

    public void decrementSpeed(double amount) {
        double newSpeed = Math.max(getCurrentSpeed() * amount, 0);
        if (newSpeed < currentSpeed)
            setCurrentSpeed(newSpeed);        // else print something / throw exception?
    }

    public void gas(double amount) {
        if (amount >= 0 && amount <= 1)
            incrementSpeed(amount);         // else print something / throw exception?
    }

    public void brake(double amount) {
        if (amount >= 0 && amount <= 1)
            decrementSpeed(amount);         // else print something / throw exception?
    }
}