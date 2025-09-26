package src.main.java.services;

public interface ThrottleService {
    void limitThrottle();
    void releaseThrottle();
}
