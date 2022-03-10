package fr.lernejo.logger;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilteredLogger implements Logger{
    private final Logger delegate;
    private final Predicate<String> condition;

    public FilteredLogger(Logger delegate, Predicate<String> condition) {
        this.delegate = delegate;
        this.condition = condition;
    }

    @Override
    public void log(String message) {
        List<String> list = Arrays.asList(message.split("\\s+"));
        if (list.stream().filter(condition).count() != 0)
        {
            delegate.log(message);
        }
    }
}
