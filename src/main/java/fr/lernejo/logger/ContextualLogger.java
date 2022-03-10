package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger{
    private String className;
    private Logger logger;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    public ContextualLogger(String className, Logger logger)
    {
        this.className = className;
        this.logger = logger;
    }

    @Override
    public void log(String message) {
        logger.log(LocalDateTime.now().format(formatter) + " " + className + " " + message);
    }
}
