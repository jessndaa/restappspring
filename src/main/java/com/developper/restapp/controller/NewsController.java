package com.developper.restapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.developper.restapp.object.HttpResponse;
import com.developper.restapp.object.NewsModel;
import com.developper.restapp.object.UserModel;
import com.developper.restapp.service.FirebaseService;
import com.google.cloud.firestore.CollectionReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.google.cloud.Timestamp;
/**
 * NewsController
 */
@RestController
public class NewsController {
    @Autowired
    FirebaseService fb;

    @GetMapping(value = "/api/news/all")
    public List<NewsModel> getAllNews() throws InterruptedException, ExecutionException {
        return fb.getAllTopic();
    }
    @GetMapping(value = "/api/news")
    public List<NewsModel> getAllNews(@RequestParam String id) throws InterruptedException, ExecutionException {
        List<NewsModel> news = new ArrayList();
        for (NewsModel newss : fb.getAllTopic()) {
            if (newss.getSender().equals(id)) {}
            else
                news.add(newss);
        }
        return news;
    }
    @PostMapping(value = "/api/news")
    public HttpResponse onNews(@RequestBody NewsModel model) {
        fb.addTopic(model);
        return new HttpResponse(200, "Ok enregistré") ;
    }
    
}