package com.ytrsoft.gui;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class LoginView extends GridPane implements EventHandler<ActionEvent> {

    private LoginListener listener;

    private final Button loginBtn;
    private final JFXTextField ipTextField;
    private final JFXTextField portTextField;

    interface LoginListener {
        void login(String ip, String port);
    }

    public void setOnLoginListener(LoginListener listener) {
        this.listener = listener;
    }

    public LoginView() {
        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setStyle("-fx-background-color: rgb(60, 63, 65)");
        setPadding(new Insets(25, 25, 25, 25));
        Label ipLabel = new Label("地址:");
        ipLabel.setTextFill(Color.valueOf("#ffffff"));
        add(ipLabel, 0, 1);
        ipTextField = new JFXTextField();
        ipTextField.setStyle("-fx-text-fill: #FFFFFF;");
        ipTextField.setPrefWidth(200);
        add(ipTextField, 1, 1);
        Label portLabel = new Label("端口:");
        portLabel.setTextFill(Color.valueOf("#ffffff"));
        add(portLabel, 0, 2);
        portTextField = new JFXTextField();
        portTextField.setStyle("-fx-text-fill: #FFFFFF;");
        portTextField.setPrefWidth(200);
        add(portTextField, 1, 2);
        loginBtn = new Button("启动");
        loginBtn.setTextFill(Color.valueOf("#ffffff"));
        loginBtn.setStyle("-fx-background-color: #1890ff");
        loginBtn.setPrefWidth(200);
        loginBtn.setOnAction(this);
        add(loginBtn, 1, 3);
    }

    @Override
    public void handle(ActionEvent event) {
        Button handleLoginBtn = (Button) event.getSource();
        if (handleLoginBtn.equals(loginBtn)) {
            handleLogin();
        }
    }

    private void handleLogin() {
        String ip = ipTextField.getText().trim();
        String port = portTextField.getText().trim();
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.getDialogPane().setStyle("-fx-background-color: rgb(60, 63, 65)");
        alert.getDialogPane().lookup(".content.label").setStyle("-fx-text-fill: #ffffff;");
        alert.getDialogPane().lookupButton(ButtonType.OK).setStyle("-fx-background-color: #1890ff;-fx-text-fill: #FFFFFF;");
        alert.setTitle("提示");
        alert.setHeaderText(null);
        if (ip.length() == 0) {
            alert.setContentText("请填写地址");
            alert.showAndWait();
        } else if (port.length() == 0) {
            alert.setContentText("请填写端口");
            alert.showAndWait();
        } else {
            if (listener != null) {
                listener.login(ip, port);
            }
        }
    }
}
