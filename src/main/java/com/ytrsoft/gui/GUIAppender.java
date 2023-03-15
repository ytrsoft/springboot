package com.ytrsoft.gui;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;

public class GUIAppender extends ConsoleAppender<ILoggingEvent> {
    @Override
    protected void append(ILoggingEvent e) {
        super.append(e);
        GUIApplication.logContainer.append(e);
    }
}