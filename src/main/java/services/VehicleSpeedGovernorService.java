package src.main.java.services;

import src.main.java.modules.speed_sensor.SpeedSensor;

/**
 * Vehicle Speed Governor Service interface.
 * Defines the contract for any Vehicle Speed Governor implementation.
 */
public interface VehicleSpeedGovernorService {

    /**
     * Starts the Vehicle Speed Governor system.
     */
    void start();

    void deactivate();

    /**
     * Checks the current vehicle speed and applies control if needed.
     *
     * @param speedLimit
     */
    void checkSpeed(int speedLimit);

    /**
     * Updates the maximum speed limit for the governor.
     *
     * @param newLimit new speed limit in km/h
     */
    void updateSpeedLimit(SpeedSensor sensor, int newLimit);
}
