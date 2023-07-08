package com.ytrsoft.gui.util;

import org.apache.commons.lang3.ObjectUtils;

import java.io.InputStream;
import javafx.scene.image.Image;

public final class Logo {

    private Logo() {
        throw new UnsupportedOperationException();
    }

    public static Image load() {
        InputStream stream = Logo.class.getResourceAsStream("/fx/logo.png");
        if (ObjectUtils.isNotEmpty(stream)) {
            return new Image(stream);
        }
        return null;
    }

}
