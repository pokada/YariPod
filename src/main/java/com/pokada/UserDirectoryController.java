package com.pokada;

/**
 * Created by egusahiroaki on 2016/03/21.
 */
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.File;
import java.util.*;

public class UserDirectoryController {
    @FXML
    private Label userDirectoryDisplay;

    @FXML
    private void initialize() {

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
                // file name
                System.out.println(file);
            }else if (files[i].isDirectory()){
                // directory name
                System.out.println(file);
            }
        }

        userDirectoryDisplay.setText("a");
    }

}
