package com.developper.restapp.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.PostConstruct;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

/**
 * FirebaseInitializer
 */
@Service
public class FirebaseInitializer {

    @PostConstruct
    public void initializeApp() throws IOException {
        FileInputStream serviceAccount =
        new FileInputStream("src/credential/bit-test-7b472-firebase-adminsdk-iui2q-e70738f635.json");
      
        FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl("https://bit-test-7b472.firebaseio.com")
            .build();
        
        FirebaseApp.initializeApp(options);
    }
}