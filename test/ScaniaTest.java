import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class ScaniaTest {
    Scania scania = new Scania();

    @Test
    public void getCurrentAngleShouldBeZero(){
        assertEquals(0, scania.getCurrentAngle());
    }

    @Test
    public void IsRaisedShouldBeFalse(){
        assertFalse(scania.isRaised());
    }

    @Test
    public void IsRaisedShouldBeTrue(){
        scania.raisePlatform();
        assertTrue(scania.isRaised());
    }

    @Test
    public void CurrentAngleShouldBeFive(){
        scania.raisePlatform();
        assertEquals(5,scania.getCurrentAngle());
    }

    @Test
    public void CurrentAngleShouldBeTwenty(){
        scania.raisePlatform();
        scania.raisePlatform();
        scania.raisePlatform();
        scania.raisePlatform();
        assertEquals(20,scania.getCurrentAngle());
    }

    @Test
    public void CurrentAngleShouldBeZero(){
        scania.startEngine();
        scania.raisePlatform();
        assertEquals(0,scania.getCurrentAngle());
    }

    @Test
    public void CurrentAngleShouldBeSeventy(){
        scania.raisePlatform();
        scania.raisePlatform();
        scania.raisePlatform();
        scania.raisePlatform();
        scania.raisePlatform();
        scania.raisePlatform();
        scania.raisePlatform();
        scania.raisePlatform();
        scania.raisePlatform();
        scania.raisePlatform();
        scania.raisePlatform();
        scania.raisePlatform();
        scania.raisePlatform();
        scania.raisePlatform();
        scania.raisePlatform();
        assertEquals(70,scania.getCurrentAngle());
    }

    @Test
    public void moveShouldBeZero(){
        scania.raisePlatform();
        scania.startEngine();
        scania.move();
        assertEquals(0, scania.getCurrentX(), 0.000001);
    }

    @Test
    public void LowerPlatformCurrentAngleShouldBeZero(){
        scania.lowerPlatform();
        assertEquals(0,scania.getCurrentAngle());
    }

    @Test
    public void IsMovingShouldBeFalse(){
        assertFalse(scania.isMoving());
    }

    @Test
    public void IsMovingShouldBeTrue(){
        scania.startEngine();
        assertTrue(scania.isMoving());
    }

    @Test
    public void getNrDoorsShouldBeTwo(){
        assertEquals(2, scania.getNrDoors());
    }

    @Test
    public void getEnginePowerShouldBeNinety(){
        assertEquals(90, scania.getEnginePower());
    }

    @Test
    public void getColorShouldBeWhite(){
        assertEquals(Color.white, scania.getColor());
    }

    @Test
    public void setColorShouldBeRed(){
        scania.setColor(Color.black);
        assertEquals(Color.black, scania.getColor());
    }

    @Test
    public void getModelnameShouldBeScania(){
        assertEquals("Scania", scania.getModelName());
    }

    @Test
    public void startEngineShouldBeZeroPointOne(){
        scania.startEngine();
        assertEquals(0.1, scania.getCurrentSpeed());
    }

    @Test
    public void stopEngineShouldBeZero(){
        scania.stopEngine();
        assertEquals(0, scania.getCurrentSpeed());
    }

    @Test
    public void speedFactorShouldBeZeroPointNine(){
        assertEquals(0.9, scania.speedFactor());
    }

    @Test
    public void gasShouldBeOne(){
        scania.startEngine();
        scania.gas(1);
        assertEquals(1, scania.getCurrentSpeed());
    }

    @Test
    public void brakeShouldBeZeroPointFiftyFive(){
        scania.startEngine();
        scania.gas(1);
        scania.brake(0.5);
        assertEquals(0.55, scania.getCurrentSpeed(), 0.000001);
    }

    @Test
    public void gasShouldThrowException(){
        scania.startEngine();
        assertThrows(IllegalArgumentException.class, ()->scania.gas(2));

    }

    @Test
    public void brakeShouldThrowExeption(){
        scania.startEngine();
        scania.gas(1);
        assertThrows(IllegalArgumentException.class, ()->scania.brake(2));

    }

    @Test
    public void moveShouldBeZeroPointOne(){
        scania.startEngine();
        scania.move();
        assertEquals(0.1, scania.getCurrentX(), 0.000001);
    }

    @Test
    public void turnLeftShouldBeZeroPointOne(){
        scania.startEngine();
        scania.turnLeft();
        scania.move();
        assertEquals(0.1, scania.getCurrentY());
    }

    @Test
    public void turnRightShouldBeZeroPointOne(){
        scania.startEngine();
        scania.turnRight();
        scania.move();
        assertEquals(-0.1, scania.getCurrentY());
    }

    @Test
    public void turnLeftShouldBeZero(){
        scania.turnLeft();
        scania.turnLeft();
        scania.turnLeft();
        scania.turnLeft();
        assertEquals(0, scania.getDirectionDegree());
    }

    @Test
    public void setCurrentSpeedShouldBeTwenty(){
        scania.setCurrentSpeed(20);
        assertEquals(20,scania.getCurrentSpeed());
    }

    @Test
    public void setCurrentSpeedShouldOneNinety(){
        scania.setCurrentSpeed(523);
        assertEquals(90,scania.getCurrentSpeed());
    }

    @Test
    public void setCurrentSpeedShouldZero(){
        scania.setCurrentSpeed(-523);
        assertEquals(0,scania.getCurrentSpeed());
    }
}
