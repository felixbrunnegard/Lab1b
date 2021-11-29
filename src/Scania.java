import java.awt.*;

public class Scania extends Truck {
    private double platformAngle;

    Scania() {
        super(80, 0, Color.white, "Scania", 0, 0, 0, 2, false);
        this.platformAngle = 0;
    }


    public double getPlatformAngle() {
        return platformAngle;
    }


    public void raisePlatform() {
        if (!isMoving() && (platformAngle + 10 <= 70)) {
            platformAngle += 10;
            super.setRampUp();
        }
        else if (isMoving())
            System.out.println("The platform cannot be raised while the Scania truck is in motion");
        else
            System.out.println("The platform cannot be raised further");
    }

    public void lowerPlatform() {
        if (platformAngle - 10 >= 0) {
            platformAngle -= 10;
            super.setRampDown();
        }
        else
            System.out.println("The platform cannot be lowered further");
    }

}
