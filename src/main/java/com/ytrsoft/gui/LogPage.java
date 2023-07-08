package com.ytrsoft.gui;

import com.ytrsoft.gui.config.AppSettings;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;


public class LogPage extends VBox implements AppSettings {

    private final ScrollPane scrollPane;
    private final VBox labelBox;
    private final Map<String, Color> colorMap = new HashMap<>();

    private void initColorMap() {
        colorMap.put(KEY_ERROR, ERROR);
        colorMap.put(KEY_WARN, WARN);
        colorMap.put(KEY_INFO, INFO);
        colorMap.put(KEY_DEBUG, DEBUG);
        colorMap.put(KEY_TRACE, TRACE);
    }

    public LogPage() {
        getStyleClass().add(MAIN_BG);
        setPadding(new Insets(
            LOG_PADDING,
            LOG_PADDING,
            LOG_PADDING,
            LOG_PADDING
        ));
        scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.getStyleClass().add(MAIN_BG);
        labelBox = new VBox();
        labelBox.getStyleClass().add(MAIN_BG);
        scrollPane.setContent(labelBox);
        scrollPane.setFitToWidth(true);
        getChildren().add(scrollPane);
        initColorMap();
    }

    public void append(String level, String message) {
        Label label = new Label(message);
        label.getStyleClass().add(MAIN_BG);
        label.setWrapText(true);
        label.setTextFill(colorMap.get(level));
        label.maxWidthProperty().bind(scrollPane.widthProperty().subtract(20));
        Platform.runLater(() -> {
            labelBox.getChildren().add(label);
            scrollPane.setVvalue(1.0);
        });
    }


}
