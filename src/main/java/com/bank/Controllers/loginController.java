package com.bank.Controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class loginController {
    @FXML
    private TextField tfLogin;

    @FXML
    private PasswordField tfMdp;

    @FXML
    private Button btnConn;

    @FXML
    public void initialize() {
        // Set default values for login fields
        tfLogin.setText("root");
        tfMdp.setText("root");
    }

    @FXML

    public void handleLogin() {
        String username = tfLogin.getText();
        String password = tfMdp.getText();

        if ("root".equals(username) && "root".equals(password)) {
            System.out.println("Login successful!");

            try {
                // Load the sidebar.fxml file
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Views/sidebar.fxml"));
                Parent root = fxmlLoader.load();

                // Create a new stage for the sidebar
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

                // Close the login window
                Stage loginStage = (Stage) btnConn.getScene().getWindow();
                loginStage.close();
            } catch (IOException e) {
                System.err.println("Error loading sidebar.fxml: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid username or password. Please try again.");
            // You can add code to show an error message or perform other actions on failed login
        }
    }

}

