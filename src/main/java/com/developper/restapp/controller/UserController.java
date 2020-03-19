package com.developper.restapp.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

import com.developper.restapp.object.Exist;
import com.developper.restapp.object.HttpResponse;
import com.developper.restapp.object.UserModel;
import com.developper.restapp.service.FirebaseService;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

/**
 * UserController
 */
@RestController
public class UserController {

    @Autowired
    FirebaseService fb;

    @GetMapping(value = "/api/user/all")
    public UserModel getUsers() {
        return fb.getAllUsers();
    }

    @GetMapping(value = "/api/user")
    public Exist getUser(@RequestParam String pseudo) throws InterruptedException, ExecutionException { 
        for (UserModel newss : fb.getUserAll()) {
            if (newss.getPseudo().equals(pseudo)) {
                return new Exist(true);
            }
        }
        return new Exist(false);
    }

    @PostMapping(value = "/api/user")
    public HttpResponse newUser(@RequestBody UserModel model) {
        return fb.addUser(model);
    }
}