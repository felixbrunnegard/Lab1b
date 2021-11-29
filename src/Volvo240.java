import java.awt.*;

public class Volvo240 extends Car{

    public final static double trimFactor = 1.25;

    public Volvo240(){
        super(100, 0, Color.black, "Volvo240", 0, 0, 0, 4);
    }

    public double speedFactor(){
        return this.getEnginePower() * 0.01 * trimFactor;
    }
}