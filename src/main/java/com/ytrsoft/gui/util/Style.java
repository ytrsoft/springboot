package com.ytrsoft.gui.util;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import org.apache.commons.lang3.ObjectUtils;

import java.net.URL;

public final class Style {

    private Style() {
        throw new UnsupportedOperationException();
    }

    public static void deploy(Scene scene) {
        ObservableList<String> stylesheets = scene.getStylesheets();
        URL resource = Style.class.getResource("/fx/style.css");
        if (ObjectUtils.isNotEmpty(resource)) {
            String form = resource.toExternalForm();
            stylesheets.add(form);
        }
    }

}
