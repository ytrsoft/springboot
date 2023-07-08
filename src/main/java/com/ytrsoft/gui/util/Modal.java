package com.ytrsoft.gui.util;

import com.ytrsoft.gui.config.AppSettings;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;

public final class Modal implements AppSettings {

    private static final Alert INFO_ALERT = new Alert(Alert.AlertType.INFORMATION);
    private static final Alert ERROR_ALERT = new Alert(Alert.AlertType.ERROR);

    static {
        initAlter(INFO_ALERT);
        initAlter(ERROR_ALERT);
    }

    private Modal() {
        throw new UnsupportedOperationException();
    }

    private static void initAlter(Alert alert) {
        DialogPane dialogPane = alert.getDialogPane();
        Scene scene = dialogPane.getScene();
        Style.deploy(scene);
        dialogPane.getStyleClass().add(MAIN_BG);
        Node label = dialogPane.lookup(".content.label");
        label.getStyleClass().add(PRIMARY_COLOR);
        Node button = dialogPane.lookupButton(ButtonType.OK);
        button.getStyleClass().add(PRIMARY_BG);
    }

    public static void msg(String content) {
        INFO_ALERT.setContentText(content);
        INFO_ALERT.showAndWait();
    }

}
