import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class Saab95Test {
    Saab95 saab95 = new Saab95();

    @Test
    public void getNrDoorsShouldBeFour(){
        assertEquals(2, saab95.getNrDoors());
    }

    @Test
    public void getEnginePowerShouldBeOneHundred(){
        assertEquals(125, saab95.getEnginePower());
    }

    @Test
    public void getColorShouldBeBlack(){
        assertEquals(Color.red, saab95.getColor());
    }
    @Test
    public void setColorShouldBeRed(){
        saab95.setColor(Color.black);
        assertEquals(Color.black, saab95.getColor());
    }

    @Test
    public void startEngineShouldBeZeroPointOne(){
        saab95.startEngine();
        assertEquals(0.1, saab95.getCurrentSpeed());
    }

    @Test
    public void stopEngineShouldBeZero(){
        saab95.stopEngine();
        assertEquals(0, saab95.getCurrentSpeed());
    }

    @Test
    public void IsMovingShouldBeFalse(){
        assertFalse(saab95.isMoving());
    }

    @Test
    public void IsMovingShouldBeTrue(){
        saab95.startEngine();
        assertTrue(saab95.isMoving());
    }

    @Test
    public void speedFactorShouldBeOnePointTwentyFourTurboOff(){
        assertEquals(1.25, saab95.speedFactor());
    }

    @Test
    public void speedFactorShouldBeOnePointTwentyFour(){
        saab95.setTurboOn();
        assertEquals(1.625, saab95.speedFactor());
    }

    @Test
    public void gasShouldBeOnePointThirtyFiveTurboOff(){
        saab95.startEngine();
        saab95.setTurboOff();
        saab95.gas(1);
        assertEquals(1.35, saab95.getCurrentSpeed());
    }

    @Test
    public void gasShouldBeOnePointSevenHundredTwentyFiveTurboOn(){
        saab95.startEngine();
        saab95.setTurboOn();
        saab95.gas(1);
        assertEquals(1.725, saab95.getCurrentSpeed());
    }

    @Test
    public void gasShouldBeEnginePower(){
        saab95.startEngine();
        saab95.setCurrentSpeed(124);
        saab95.gas(1);
        assertEquals(125, saab95.getCurrentSpeed());
    }
    @Test
    public void gasShouldThrowException(){
        saab95.startEngine();
        assertThrows(IllegalArgumentException.class, ()->saab95.gas(2));

    }

    @Test
    public void brakeShouldBeZeroPointSeventyTwoFourTurboOff(){
        saab95.startEngine();
        saab95.gas(1);
        saab95.brake(0.5);
        assertEquals(0.725, saab95.getCurrentSpeed(), 0.000001);
    }

    @Test
    public void brakeShouldBeZeroPointNinetyOneTurboOn(){
        saab95.startEngine();
        saab95.setTurboOn();
        saab95.gas(1);
        saab95.brake(0.5);
        assertEquals(0.9125, saab95.getCurrentSpeed(), 0.000001);
    }

    @Test
    public void breakShouldThrowException(){
        saab95.startEngine();
        saab95.gas(1);
        assertThrows(IllegalArgumentException.class, ()->saab95.brake(2));

    }

    @Test
    public void moveShouldBeZeroPointOne(){
        saab95.startEngine();
        saab95.move();
        assertEquals(0.1, saab95.getCurrentX(), 0.000001);
    }

    @Test
    public void turnLeftShouldBeZeroPointOne(){
        saab95.startEngine();
        saab95.turnLeft();
        saab95.move();
        assertEquals(0.1, saab95.getCurrentY());
    }

    @Test
    public void turnRightShouldBeZeroPointOne(){
        saab95.startEngine();
        saab95.turnRight();
        saab95.move();
        assertEquals(-0.1, saab95.getCurrentY());
    }

    @Test
    public void turnLeftShouldBeZero(){
        saab95.turnLeft();
        saab95.turnLeft();
        saab95.turnLeft();
        saab95.turnLeft();
        assertEquals(0, saab95.getDirectionDegree());
    }

    @Test
    public void setCurrentSpeedShouldBeTwenty(){
        saab95.setCurrentSpeed(20);
        assertEquals(20,saab95.getCurrentSpeed());
    }

    @Test
    public void setCurrentSpeedShouldOneHundred(){
        saab95.setCurrentSpeed(523);
        assertEquals(125,saab95.getCurrentSpeed());
    }

    @Test
    public void setCurrentSpeedShouldZero(){
        saab95.setCurrentSpeed(-523);
        assertEquals(0,saab95.getCurrentSpeed());
    }

    @Test
    public void getTurboShouldBeFalse(){
        assertFalse(saab95.getTurbo());
    }

    @Test
    public void getModelnameShouldBeSaab95(){
        assertEquals("Saab95", saab95.getModelName());
    }
}