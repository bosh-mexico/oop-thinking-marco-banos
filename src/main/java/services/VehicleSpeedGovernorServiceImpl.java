package src.main.java.services;


import src.main.java.modules.speed_sensor.SpeedSensor;

/**
 * Implementation of the VehicleSpeedGovernorService.
 * Ensures that the vehicle speed does not exceed a configurable threshold.
 */
public class VehicleSpeedGovernorServiceImpl implements VehicleSpeedGovernorService {

    private final SpeedSensor speedSensor = new SpeedSensor();
    private final ThrottleService throttleService = new ThrottleServiceImpl();
    private final LoggerService logger = new LoggerServiceImpl();

    @Override
    public void start() {
        logger.logEvent("Vehicle Speed Governor started. Limit = " + 100 + " km/h");
    }

    @Override
    public void deactivate(){
        logger.logEvent("Vehicle Speed Governor deactivated. Speed = " + 0 + " km/h");
    }


    @Override
    public void checkSpeed(int speedLimit) {
        int currentSpeed = speedSensor.getSpeed();

        if (currentSpeed > speedLimit) {
            throttleService.limitThrottle();
            logger.logEvent("Speed exceeded: " + currentSpeed + " km/h. Applying control.");
            alertDriver();
        } else {
            throttleService.releaseThrottle();
            logger.logEvent("Speed OK: " + currentSpeed + " km/h");
        }
    }


    @Override
    public void updateSpeedLimit(SpeedSensor sensor, int newLimit) {
        sensor.setSpeed(newLimit);
        logger.logEvent("New speed limit configured: " + newLimit + " km/h");
    }

    private void alertDriver() {
        logger.logEvent("⚠️ Warning: Speed limit reached.");
    }
}
