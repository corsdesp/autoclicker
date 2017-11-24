package ru.autoclicker;

import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

public class MouseListener implements NativeMouseInputListener {
    private boolean isRun;
    private int timeout;
    private Clicker clicker = new Clicker();

    public MouseListener(int timeout) {
        this.timeout = timeout;
    }

    public void nativeMouseClicked(NativeMouseEvent nativeMouseEvent) {
    }

    public void nativeMousePressed(NativeMouseEvent nativeMouseEvent) {
    }

    public void nativeMouseReleased(NativeMouseEvent nativeMouseEvent) {
        if (nativeMouseEvent.getButton() == NativeMouseEvent.BUTTON3) {
            if (!isRun) {
                if (clicker.getState() == Thread.State.TERMINATED) {
                    clicker = new Clicker();
                }
                clicker.setTimeout(timeout);
                clicker.start();
                isRun = true;
            } else {
                clicker.stopThread();
                isRun = false;
            }
        }
    }

    public void nativeMouseMoved(NativeMouseEvent nativeMouseEvent) {
    }

    public void nativeMouseDragged(NativeMouseEvent nativeMouseEvent) {
    }
}
