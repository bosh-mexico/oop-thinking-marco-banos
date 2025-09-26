package src.main.java.modules.throttle;

public class Throttle {
    private boolean isThrottleLimited;
    private int throttleLevel;

    public boolean isThrottleLimited() {
        return isThrottleLimited;
    }

    public void setThrottleLimited(boolean throttleLimited) {
        isThrottleLimited = throttleLimited;
    }

    public int getThrottleLevel() {
        return throttleLevel;
    }

    public void setThrottleLevel(int throttleLevel) {
        this.throttleLevel = throttleLevel;
    }
}
