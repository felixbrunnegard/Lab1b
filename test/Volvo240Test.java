import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class Volvo240Test {
    Volvo240 volvo240 = new Volvo240();

    @Test
    public void getNrDoorsShouldBeFour(){
        assertEquals(4, volvo240.getNrDoors());
    }

    @Test
    public void getEnginePowerShouldBeOneHundred(){
        assertEquals(100, volvo240.getEnginePower());
    }

    @Test
    public void getColorShouldBeBlack(){
        assertEquals(Color.black, volvo240.getColor());
    }
    @Test
    public void setColorShouldBeRed(){
        volvo240.setColor(Color.red);
        assertEquals(Color.red, volvo240.getColor());
    }

    @Test
    public void startEngineShouldBeZeroPointOne(){
        volvo240.startEngine();
        assertEquals(0.1, volvo240.getCurrentSpeed());
    }

    @Test
    public void stopEngineShouldBeZero(){
        volvo240.stopEngine();
        assertEquals(0, volvo240.getCurrentSpeed());
    }

    @Test
    public void IsMovingShouldBeFalse(){
        assertFalse(volvo240.isMoving());
    }

    @Test
    public void IsMovingShouldBeTrue(){
        volvo240.startEngine();
        assertTrue(volvo240.isMoving());
    }

    @Test
    public void speedFactorShouldBeOnePointTwentyFour(){
        assertEquals(1.25, volvo240.speedFactor());
    }

    @Test
    public void gasShouldBeOnePointThirtyFive(){
        volvo240.startEngine();
        volvo240.gas(1);
        assertEquals(1.35, volvo240.getCurrentSpeed());
    }

    @Test
    public void gasShouldBeEnginePower(){
        volvo240.startEngine();
        volvo240.setCurrentSpeed(99);
        volvo240.gas(1);
        assertEquals(100, volvo240.getCurrentSpeed());
    }

    @Test
    public void gasShouldThrowExeption(){
        volvo240.startEngine();
        assertThrows(IllegalArgumentException.class, ()->volvo240.gas(2));

    }

    @Test
    public void brakeShouldBeOnePointTwentyFour(){
        volvo240.startEngine();
        volvo240.gas(1);
        volvo240.brake(0.5);
        assertEquals(0.725, volvo240.getCurrentSpeed(), 0.000001);
    }

    @Test
    public void brakeShouldThrowExeption(){
        volvo240.startEngine();
        volvo240.gas(1);
        assertThrows(IllegalArgumentException.class, ()->volvo240.brake(2));

    }

    @Test
    public void moveShouldBeZeroPointOne(){
        volvo240.startEngine();
        volvo240.move();
        assertEquals(0.1, volvo240.getCoordinateX(), 0.000001);
    }

    @Test
    public void turnLeftShouldBeZeroPointOne(){
        volvo240.startEngine();
        volvo240.turnLeft();
        volvo240.move();
        assertEquals(0.1, volvo240.getCoordinateY());
    }

    @Test
    public void turnRightShouldBeZeroPointOne(){
        volvo240.startEngine();
        volvo240.turnRight();
        volvo240.move();
        assertEquals(-0.1, volvo240.getCoordinateX());
    }


    @Test
    public void setCurrentSpeedShouldBeTwenty(){
        volvo240.setCurrentSpeed(20);
        assertEquals(20,volvo240.getCurrentSpeed());
    }

    @Test
    public void setCurrentSpeedShouldOneHundred(){
        volvo240.setCurrentSpeed(523);
        assertEquals(100,volvo240.getCurrentSpeed());
    }

    @Test
    public void setCurrentSpeedShouldZero(){
        volvo240.setCurrentSpeed(-523);
        assertEquals(0,volvo240.getCurrentSpeed());
    }

    @Test
    public void getModelnameShouldBeVolvo240(){
        assertEquals("Volvo240", volvo240.getModelName());
    }

}