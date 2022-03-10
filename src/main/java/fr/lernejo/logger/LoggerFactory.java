package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name)
    {
        FileLogger fileLogger = new FileLogger("logs.txt");
        return new ContextualLogger(name, fileLogger);
    }
}
