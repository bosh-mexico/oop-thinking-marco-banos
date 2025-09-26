package src.main.java.services;

import src.main.java.modules.throttle.Throttle;

/**
 * Implementation of ThrottleService.
 * Simulates interaction with the vehicle’s throttle actuator in a simplified way.
 */
public class ThrottleServiceImpl implements ThrottleService {

    private final Throttle throttle;

    public ThrottleServiceImpl() {
        this.throttle = new Throttle();
        this.throttle.setThrottleLimited(false);
        this.throttle.setThrottleLevel(100); // Default: full throttle allowed
    }

    @Override
    public void limitThrottle() {
        if (!throttle.isThrottleLimited()) {
            throttle.setThrottleLimited(true);

            // Simulate gradual throttle reduction (e.g., to 60%)
            int newLevel = Math.max(throttle.getThrottleLevel() - 40, 60);
            throttle.setThrottleLevel(newLevel);
        }
    }

    @Override
    public void releaseThrottle() {
        if (throttle.isThrottleLimited()) {
            throttle.setThrottleLimited(false);

            // Smooth release back to full throttle
            throttle.setThrottleLevel(100);
        }
    }

    @Override
    public boolean isThrottleLimited() {
        return throttle.isThrottleLimited();
    }

    @Override
    public int getThrottleLevel() {
        return throttle.getThrottleLevel();
    }
}