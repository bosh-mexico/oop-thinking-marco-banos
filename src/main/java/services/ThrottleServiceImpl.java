package src.main.java.services;

/**
 * Implementation of ThrottleService.
 * Simulates interaction with the vehicle’s throttle actuator in a simplified way.
 */
public class ThrottleServiceImpl implements ThrottleService {

    private boolean isThrottleLimited;
    private int throttleLevel; // percentage [0–100]

    public ThrottleServiceImpl() {
        this.isThrottleLimited = false;
        this.throttleLevel = 100; // Default: full throttle allowed
    }

    @Override
    public void limitThrottle() {
        if (!isThrottleLimited) {
            isThrottleLimited = true;

            // Simulate gradual throttle reduction (e.g., to 60%)
            throttleLevel = Math.max(throttleLevel - 40, 60);
        }
    }

    @Override
    public void releaseThrottle() {
        if (isThrottleLimited) {
            isThrottleLimited = false;

            // Smooth release back to full throttle
            throttleLevel = 100;
        }
    }

    /**
     * @return true if throttle is currently limited.
     */
    public boolean isThrottleLimited() {
        return isThrottleLimited;
    }

    /**
     * @return current throttle level (0–100).
     */
    public int getThrottleLevel() {
        return throttleLevel;
    }
}
