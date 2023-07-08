package com.ytrsoft.gui;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.Layout;
import com.ytrsoft.gui.config.AppSettings;
import org.slf4j.LoggerFactory;

public class GUIAppender extends AppenderBase<LoggingEvent> implements AppSettings {

    @Override
    protected void append(LoggingEvent event) {
        String level = event.getLevel().levelStr;
        String message = getFormattedMessage(event);
        GUIApplication.logPage.append(level, message);
    }

    public String getFormattedMessage(LoggingEvent event) {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setPattern(LOG_FORMAT);
        encoder.setContext(loggerContext);
        encoder.start();
        Layout<ILoggingEvent> layout = encoder.getLayout();
        return layout.doLayout(event);
    }
}