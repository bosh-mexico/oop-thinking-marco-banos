package src.main.java.services;

public interface ThrottleService {
    void limitThrottle();
    void releaseThrottle();

    /**
     * @return true if throttle is currently limited.
     */
    boolean isThrottleLimited();

    /**
     * @return current throttle level (0–100).
     */
    int getThrottleLevel();
}
