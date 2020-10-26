package com.seem.view.pane;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public abstract class BasePane extends Pane implements EventHandler<MouseEvent> {

    public BasePane() {
        initPaneConfig();
        initPaneContent();
    }

    protected abstract void initPaneContent();
    protected abstract void initPaneConfig();

}