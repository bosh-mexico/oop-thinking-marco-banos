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
        assertDoesNotThrow(() -> governor.checkSpeed(60));
    }

    @Test
    void testCheckSpeedAboveLimit() {
        assertDoesNotThrow(() -> governor.checkSpeed(100));
    }

    @Test
    void testUpdateSpeedLimit() {
        governor.updateSpeedLimit(90);
        assertDoesNotThrow(() -> governor.checkSpeed(85));
    }
}
