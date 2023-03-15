package com.ytrsoft.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginView extends GridPane implements EventHandler<ActionEvent> {

    private LoginListener listener;

    private final Button loginBtn;
    private final TextField ipTextField;
    private final TextField portTextField;

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
        setPadding(new Insets(25, 25, 25, 25));
        Label ipLabel = new Label("地址:");
        add(ipLabel, 0, 1);
        ipTextField = new TextField();
        ipTextField.setPrefWidth(200);
        add(ipTextField, 1, 1);
        Label portLabel = new Label("端口:");
        add(portLabel, 0, 2);
        portTextField = new TextField();
        portTextField.setPrefWidth(200);
        add(portTextField, 1, 2);
        loginBtn = new Button("启动");
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
