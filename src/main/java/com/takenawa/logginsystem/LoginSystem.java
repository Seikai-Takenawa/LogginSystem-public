package com.takenawa.loginsystem;

import com.takenawa.loginsystem.db.DatabaseManager;
import com.takenawa.loginsystem.gui.LoginFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

public class LoginSystem {
    public static final Logger LOGGER = LoggerFactory.getLogger(LoginSystem.class);

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                DatabaseManager.shutdown();
            } catch (Exception e) {
                LOGGER.error("Error occurred when shutting down database: {}", e.getMessage());
            }
        }));

        DatabaseManager.initializeDatabase();
        SwingUtilities.invokeLater(() -> LoginFrame.getInstance().setVisible(true));
    }
}