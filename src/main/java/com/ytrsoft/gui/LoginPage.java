package com.ytrsoft.gui;

import com.jfoenix.controls.JFXTextField;
import com.ytrsoft.gui.config.AppSettings;
import com.ytrsoft.gui.config.Text;
import com.ytrsoft.gui.util.Modal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

public class LoginPage extends GridPane implements AppSettings, EventHandler<ActionEvent> {

    interface LoginListener {
        void login(String ip, String port);
    }

    private LoginListener listener;

    private final Button loginBtn;
    private final JFXTextField ipTextField;
    private final JFXTextField portTextField;

    public void setOnLoginListener(LoginListener listener) {
        this.listener = listener;
    }

    public LoginPage() {
        getStyleClass().add(MAIN_BG);
        setAlignment(Pos.CENTER);
        setHgap(LOGIN_GRID_GAP);
        setVgap(LOGIN_GRID_GAP);
        setPadding(new Insets(
            LOGIN_GRID_PADDING,
            LOGIN_GRID_PADDING,
            LOGIN_GRID_PADDING,
            LOGIN_GRID_PADDING
        ));

        Label ipLabel = new Label(LABEL_IP);
        ipLabel.getStyleClass().add(PRIMARY_COLOR);
        add(ipLabel, 0, 1);
        ipTextField = new JFXTextField();
        ipTextField.getStyleClass().add(PRIMARY_COLOR);
        ipTextField.setPrefWidth(200);
        add(ipTextField, 1, 1);

        Label portLabel = new Label(LABEL_PORT);
        portLabel.getStyleClass().add(PRIMARY_COLOR);
        add(portLabel, 0, 2);
        portTextField = new JFXTextField();
        portTextField.getStyleClass().add(PRIMARY_COLOR);
        portTextField.setPrefWidth(200);
        add(portTextField, 1, 2);

        loginBtn = new Button(BTN_LOGIN_TEXT);
        loginBtn.getStyleClass().add(PRIMARY_COLOR);
        loginBtn.getStyleClass().add(PRIMARY_BG);
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
        if (StringUtils.isEmpty(ip)) {
            Modal.msg(Text.LABEL_IP_HINT);
        } else if (StringUtils.isEmpty(port)) {
            Modal.msg(Text.LABEL_PORT_HINT);
        } else {
            if (ObjectUtils.isNotEmpty(listener)) {
                listener.login(ip, port);
            }
        }
    }

}
