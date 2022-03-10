package fr.lernejo.logger;

public class CompositeLogger implements Logger{
    private final Logger consoleLogger;
    private final Logger fileLogger;

    public CompositeLogger(Logger consoleLogger, Logger fileLogger)
    {
        this.consoleLogger = consoleLogger;
        this.fileLogger = fileLogger;
    }

    @Override
    public void log(String message) {
        consoleLogger.log(message);
        fileLogger.log(message);
    }
}
