package com.developper.restapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.developper.restapp.object.HttpResponse;
import com.developper.restapp.object.NewsModel;
import com.developper.restapp.object.UserModel;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import org.springframework.stereotype.Service;

/**
 * FirebaseService
 */
@Service
public class FirebaseService {

    public UserModel getAllUsers() {
        final Firestore db = FirestoreClient.getFirestore();
        final DocumentReference ref = db.collection("users").document("jessy");
        final ApiFuture<DocumentSnapshot> future = ref.get();

        DocumentSnapshot snap = null;
        try {
            snap = future.get();
        } catch (final InterruptedException e) {
            e.printStackTrace();
        } catch (final ExecutionException e) {
            e.printStackTrace();
        }
        UserModel user = null;
        if (!(snap == null) && snap.exists()) {
            user = snap.toObject(UserModel.class);
            return user;
        } else {
            return null;
        }
    }

    public List<NewsModel> getAllTopic() throws InterruptedException, ExecutionException {
        
        final Firestore db = FirestoreClient.getFirestore();
        final ApiFuture<QuerySnapshot> future = db.collection("news").get();
        // future.get() blocks on response
        final List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        final List<NewsModel> news = new ArrayList();
        for (final QueryDocumentSnapshot document : documents) {
            news.add(document.toObject(NewsModel.class));
        }
        return news;

    }

    public List<UserModel> getUserAll() throws InterruptedException, ExecutionException {
        
        final Firestore db = FirestoreClient.getFirestore();
        final ApiFuture<QuerySnapshot> future = db.collection("users").get();
        // future.get() blocks on response
        final List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        final List<UserModel> news = new ArrayList();
        for (final QueryDocumentSnapshot document : documents) {
            news.add(document.toObject(UserModel.class));
        }
        return news;
    }

    public HttpResponse addTopic(NewsModel newsModel){

        final Firestore db = FirestoreClient.getFirestore();
        db
        .collection("news")
        .add(newsModel);

        return new HttpResponse(200, "Enregistré avec succès");

    }

    public HttpResponse addUser(UserModel user){

        final Firestore db = FirestoreClient.getFirestore();
        db
        .collection("users")
        .add(user);

        return new HttpResponse(200, "Enregistré avec succès");
    }
}