package src.test.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.main.java.modules.speed_sensor.SpeedSensor;
import src.main.java.services.ThrottleService;
import src.main.java.services.ThrottleServiceImpl;
import src.main.java.services.VehicleSpeedGovernorService;
import src.main.java.services.VehicleSpeedGovernorServiceImpl;

class VSGTest {

    private final int speedLimit = 200;
    private final SpeedSensor sensor = new SpeedSensor();
    private final VehicleSpeedGovernorService governor = new VehicleSpeedGovernorServiceImpl();
    private final ThrottleService throttle = new ThrottleServiceImpl();

    @Test
    void testStart() {
        assertDoesNotThrow(governor::start);
    }

    @Test
    void testCheckSpeedBelowLimit() {
        governor.checkSpeed(speedLimit);
        assertFalse(throttle.isThrottleLimited());
        assertEquals(100, throttle.getThrottleLevel());
    }

    @Test
    void testCheckSpeedAboveLimit() {
        governor.checkSpeed(speedLimit);
        assertTrue(throttle.isThrottleLimited());
        assertTrue(throttle.getThrottleLevel() <= 60);
    }

    @Test
    void testUpdateSpeedLimit() {
        governor.updateSpeedLimit(sensor, speedLimit);
        governor.checkSpeed(speedLimit);
        assertFalse(throttle.isThrottleLimited());
        assertEquals(100, throttle.getThrottleLevel());
    }

    @Test
    void testThrottleReleaseAfterLimit() {
        governor.checkSpeed(speedLimit);
        assertTrue(throttle.isThrottleLimited());

        governor.checkSpeed(speedLimit);
        assertFalse(throttle.isThrottleLimited());
        assertEquals(100, throttle.getThrottleLevel());
    }
}
