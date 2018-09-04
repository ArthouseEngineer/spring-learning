package com.spring.core.loggers;

import java.util.List;

public class CombinedEventLogger implements EventLogger {

    private final List<EventLogger> loggers;

    public CombinedEventLogger(List<EventLogger> loggers) {
        super();
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger eventLogger : loggers) {
            eventLogger.logEvent(event);
        }
    }
}
