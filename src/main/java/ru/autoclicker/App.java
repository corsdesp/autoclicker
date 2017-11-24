package ru.autoclicker;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    public static void main(String[] args) throws NativeHookException, IOException {
        disableLogging();

        GlobalScreen.registerNativeHook();

        MouseListener mouseListener = new MouseListener(getDelay(args[0]));

        GlobalScreen.addNativeMouseListener(mouseListener);
        GlobalScreen.addNativeMouseMotionListener(mouseListener);
    }

    private static void disableLogging() {
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.WARNING);
        logger.setUseParentHandlers(false);
    }

    private static int getDelay(String delay) {
        return Integer.parseInt(delay);
    }
}
