package com.ytrsoft.gui;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Layout;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class LogView extends VBox {

    private final ScrollPane scrollPane;
    private final VBox labelBox;
    private final Map<String, Color> colorMap;

    public LogView() {
        setStyle("-fx-background-color: rgb(60, 63, 65);");
        scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setStyle("-fx-background-color: rgb(60, 63, 65);-fx-background: rgb(60, 63, 65);");
        setPadding(new Insets(10, 10, 10, 10));
        labelBox = new VBox();
        labelBox.setStyle("-fx-background-color: rgb(60, 63, 65);");
        scrollPane.setContent(labelBox);
        scrollPane.setFitToWidth(true);
        getChildren().add(scrollPane);
        colorMap = new HashMap<>();
        colorMap.put("ERROR", Color.valueOf("rgb(255, 107, 104)"));
        colorMap.put("WARN", Color.valueOf("rgb(240, 167, 50)"));
        colorMap.put("INFO", Color.valueOf("rgb(187, 187, 187)"));
        colorMap.put("DEBUG", Color.valueOf("rgb(53, 146, 196)"));
        colorMap.put("TRACE", Color.valueOf("rgb(73, 156, 86)"));
    }

    public void append(ILoggingEvent e) {
        Label label = new Label(getFormattedMessage(e));
        label.setStyle("-fx-background-color: rgb(60, 63, 65); -fx-background: transparent;");
        label.setWrapText(true);
        Color labelColor = colorMap.get(e.getLevel().levelStr);
        label.setTextFill(labelColor);
        label.maxWidthProperty().bind(scrollPane.widthProperty().subtract(20));
        Platform.runLater(() -> {
            labelBox.getChildren().add(label);
            scrollPane.setVvalue(1.0);
        });
    }

    public String getFormattedMessage(ILoggingEvent e) {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setPattern("%d{HH:mm:ss} - %msg%n");
        encoder.setContext(loggerContext);
        encoder.start();
        Layout<ILoggingEvent> layout = encoder.getLayout();
        return layout.doLayout(e);
    }
}
