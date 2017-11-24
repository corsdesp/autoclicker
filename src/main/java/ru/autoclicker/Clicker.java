package ru.autoclicker;

import java.awt.*;
import java.awt.event.InputEvent;

public class Clicker extends Thread {
    private boolean isStop;
    private int timeout = 500;

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public void run() {
        isStop = false;
        Robot robot = initializeRobot();
        while (!isStop) {
            sleep();
            if (robot != null) {
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
            }
        }

    }

    public void stopThread() {
        isStop = true;
    }

    private void sleep() {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Robot initializeRobot() {
        Robot bot = null;
        try {
            bot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return bot;
    }
}
