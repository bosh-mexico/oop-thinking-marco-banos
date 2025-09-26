package src.test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.main.java.services.VehicleSpeedGovernorServiceImpl;

class VSGTest {

    private VehicleSpeedGovernorServiceImpl governor;

    @BeforeEach
    void setUp() {
        governor = new VehicleSpeedGovernorServiceImpl(80);
    }

    @Test
    void testStart() {
        assertDoesNotThrow(() -> governor.start());
    }

    @Test
    void testCheckSpeedBelowLimit() {
        governor.checkSpeed(60);
        assertFalse(governor.getThrottleService().isThrottleLimited());
        assertEquals(100, governor.getThrottleService().getThrottleLevel());
    }

    @Test
    void testCheckSpeedAboveLimit() {
        governor.checkSpeed(100);
        assertTrue(governor.getThrottleService().isThrottleLimited());
        assertTrue(governor.getThrottleService().getThrottleLevel() <= 60);
    }

    @Test
    void testUpdateSpeedLimit() {
        governor.updateSpeedLimit(90);
        governor.checkSpeed(85);
        assertFalse(governor.getThrottleService().isThrottleLimited());
        assertEquals(100, governor.getThrottleService().getThrottleLevel());
    }

    @Test
    void testThrottleReleaseAfterLimit() {
        governor.checkSpeed(100); // over limit → throttle limited
        assertTrue(governor.getThrottleService().isThrottleLimited());

        governor.checkSpeed(70); // below limit → throttle released
        assertFalse(governor.getThrottleService().isThrottleLimited());
        assertEquals(100, governor.getThrottleService().getThrottleLevel());
    }
}
