package com.pokada;/**
 * Created by kyohei on 2016/03/21.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.File;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("FXMLサンプル");

        // get current user name

        String path = "/Users/";
        String username = System.getProperty("user.name");
        StringBuilder userCurrentPath = new StringBuilder();
        userCurrentPath.append(path);
        userCurrentPath.append(username);
        File dir = new File(new String(userCurrentPath));



        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (files[i].isFile()){
                //ファイル名表示
                System.out.println(file);
            }else if (files[i].isDirectory()){
                //ディレクトリ名表示(※１)
                System.out.println(file);
            }
        }

        
        
        
        
        
        
        AnchorPane root = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
