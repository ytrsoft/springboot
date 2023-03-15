package com.ytrsoft.gui;

import ch.qos.logback.classic.spi.ILoggingEvent;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class LogView extends VBox {

    private final ScrollPane scrollPane;
    private final VBox labelBox;

    public LogView() {
        scrollPane = new ScrollPane();
        labelBox = new VBox();
        scrollPane.setContent(labelBox);
        scrollPane.setFitToWidth(true);
        getChildren().add(scrollPane);
    }

    public void append(ILoggingEvent e) {
        Label label = new Label(e.getMessage());
        label.setWrapText(true);
        switch (e.getLevel().levelStr) {
            case "ERROR":
                label.setTextFill(Color.RED);
            case "WARN":
                label.setTextFill(Color.ORANGE);
            case "INFO":
                label.setTextFill(Color.BLACK);
            case "DEBUG":
                label.setTextFill(Color.BLUE);
            case "TRACE":
                label.setTextFill(Color.GREEN);
        }
        label.maxWidthProperty().bind(scrollPane.widthProperty().subtract(20));
        Platform.runLater(() -> {
            labelBox.getChildren().add(label);
            scrollPane.setVvalue(1.0);
        });
    }
}
