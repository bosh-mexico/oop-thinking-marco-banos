package src.main.java.services;


import src.main.java.modules.speed_sensor.SpeedSensor;

/**
 * Implementation of the VehicleSpeedGovernorService.
 * Ensures that the vehicle speed does not exceed a configurable threshold.
 */
public class VehicleSpeedGovernorServiceImpl implements VehicleSpeedGovernorService {

    private int speedLimit; // Maximum allowed speed
    private final SpeedSensor speedSensor;
    private final ThrottleService throttleService;
    private final LoggerService logger;

    public VehicleSpeedGovernorServiceImpl(int speedLimit) {
        this.speedLimit = speedLimit;
        this.speedSensor = new SpeedSensor();
        this.throttleService = new ThrottleServiceImpl();
        this.logger = new LoggerServiceImpl();
    }

    @Override
    public void start() {
        System.out.println("Vehicle Speed Governor started. Limit = " + speedLimit + " km/h");
    }

    @Override
    public void checkSpeed(int currentSpeed) {
        speedSensor.setSpeed(currentSpeed);

        if (currentSpeed > speedLimit) {
            throttleService.limitThrottle();
            logger.logEvent("Speed exceeded: " + currentSpeed + " km/h. Applying control.");
            alertDriver();
        } else {
            throttleService.releaseThrottle();
            System.out.println("Speed OK: " + currentSpeed + " km/h");
        }
    }

    @Override
    public void updateSpeedLimit(int newLimit) {
        this.speedLimit = newLimit;
        logger.logEvent("New speed limit configured: " + newLimit + " km/h");
    }

    /**
     * Alerts the driver when the governed speed is reached.
     * Could be implemented with dashboard indicator, sound, etc.
     */
    private void alertDriver() {
        System.out.println("⚠️ Warning: Speed limit reached.");
    }
}
