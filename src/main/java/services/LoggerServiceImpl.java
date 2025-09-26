package src.main.java.services;

import java.time.LocalDateTime;

public class LoggerServiceImpl implements LoggerService {

    @Override
    public void logEvent(String message) {
        System.out.println("[LOG " + LocalDateTime.now() + "] " + message);
    }
}
