package com.pokada;

/**
 * Created by egusahiroaki on 2016/03/21.
 */
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.util.*;

public class UserDirectoryController {
    @FXML
    private Label userDirectoryDisplay;
    @FXML
    private ListView<String> userDirectoryList;
    private ObservableList<String> listRecords = FXCollections.observableArrayList();

    @FXML
    private void initialize() {

        // get current user name
        String path = "/Users/";
        String username = System.getProperty("user.name");
        StringBuilder userCurrentPath = new StringBuilder();
        userCurrentPath.append(path);
        userCurrentPath.append(username);
        File dir = new File(userCurrentPath.toString());

        userDirectoryDisplay.setText("a");
        //ObservableList<String> items =FXCollections.observableArrayList ("Single", "Double", "Suite", "Family App");
        ObservableList<String> items =FXCollections.observableArrayList();

        File[] files = dir.listFiles();
        for(File file : files) {
            if (file.isFile() && !file.isHidden()){
                // file name
                System.out.println(file);
                String fileName = String.valueOf(file).replace(new String(userCurrentPath + "/"), "");
                items.add(fileName);
            }else if (file.isDirectory() && !file.isHidden()){
                // directory name
                System.out.println(file);
                String directoryName = String.valueOf(file).replace(new String(userCurrentPath + "/"), "");
                items.add(directoryName);
            }
        }

        userDirectoryList.setItems(items);

    }

}