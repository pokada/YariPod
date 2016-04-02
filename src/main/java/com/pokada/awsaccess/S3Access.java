package com.pokada.awsaccess;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by kyohei on 2016/03/21.
 */
public class S3Access {

    AWSCredentials credentials;
    private final String ACCESSKEY_ID = "AKIAIID3HBM573WGWYGA";
    private final String SECRET_ACCESSKEY = "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";

    public S3Access() {
        setCredentials();
    }

    private void setCredentials() {
        Properties properties = new Properties();
        try (InputStream is = ClassLoader.getSystemResourceAsStream("properties/credentials.properties")){
            properties.load(is);
            String accesskeyId= properties.getProperty("accesskey_id");
            String secretAccesskey= properties.getProperty("secret_accesskey");
            credentials = new BasicAWSCredentials(accesskeyId, secretAccesskey);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<String> getFileList() {
        AmazonS3 s3 = new AmazonS3Client(credentials);
        String bucketName = "class19";
        String prefix = null;
        String delimiter = null;
        String marker = null;

//        ListObjectsRequest request = new ListObjectsRequest("class19", null ,null, "", 1000);
        ListObjectsRequest request = new ListObjectsRequest(bucketName, prefix, marker, delimiter, null);

        List<String> keyList = new ArrayList<>();
        ObjectListing list;
        do {
            list = s3.listObjects(request);

            list.getObjectSummaries()
                    .stream()
                    .filter(s -> (s.getKey().endsWith("/") || !s.getKey().contains("/")))
                    .forEach(s -> keyList.add(s.getKey()));
            ;
            request.setMarker(list.getNextMarker());
        } while (list.isTruncated());

        return keyList;
    }
}
