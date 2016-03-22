package com.pokada;/**
 * Created by kyohei on 2016/03/21.
 */

import com.sun.org.apache.bcel.internal.generic.LALOAD;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("current user directory");

        AnchorPane root = FXMLLoader.load(getClass().getClassLoader().getResource("firstView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
<<<<<<< Updated upstream
        
=======

>>>>>>> Stashed changes
        // display window
        primaryStage.show();
    }
}
