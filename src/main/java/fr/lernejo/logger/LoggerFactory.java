package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory {
    public static Logger getLogger(String name)
    {
        Predicate<String> conditionFile = message -> message.contains("simulation");
        return new CompositeLogger(
            new ContextualLogger(name,
                new FilteredLogger(
                    new FileLogger("logs.txt"), conditionFile)),
            new ContextualLogger(name,
                    new ConsoleLogger()));
    }
}
