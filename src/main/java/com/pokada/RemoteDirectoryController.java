package com.pokada;

/**
 * Created by egusahiroaki on 2016/03/21.
 */

import com.pokada.awsaccess.S3Access;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class RemoteDirectoryController {
    @FXML
    private Label remoteDirectoryDisplay;
    @FXML
    private ListView<String> remoteDirectoryList;
    private ObservableList<String> listRecords = FXCollections.observableArrayList();

    @FXML
    private void initialize() {

        S3Access s3 = new S3Access();
        remoteDirectoryDisplay.setText("a");
        ObservableList<String> items = FXCollections.observableArrayList(s3.getFileList());

        remoteDirectoryList.setItems(items);

    }

}