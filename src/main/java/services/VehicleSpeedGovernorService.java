package src.main.java.services;

/**
 * Vehicle Speed Governor Service interface.
 * Defines the contract for any Vehicle Speed Governor implementation.
 */
public interface VehicleSpeedGovernorService {

    /**
     * Starts the Vehicle Speed Governor system.
     */
    void start();

    /**
     * Checks the current vehicle speed and applies control if needed.
     *
     * @param currentSpeed current vehicle speed in km/h
     */
    void checkSpeed(int currentSpeed);

    /**
     * Updates the maximum speed limit for the governor.
     *
     * @param newLimit new speed limit in km/h
     */
    void updateSpeedLimit(int newLimit);
}
