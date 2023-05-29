package com.training.sgorodecki.homework.homework14.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.sgorodecki.homework.homework14.service.Post;
import com.training.sgorodecki.homework.homework14.serviceImpl.WebClient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlConnectionImpl implements WebClient {

    private static final String JSONPLACEHOLDER_POSTS = "https://jsonplaceholder.typicode.com/posts/";
    private static final String PROPERTY = "application/json; charset=UTF-8";
    private static final String BODY = "message";


    private void readResponse(HttpURLConnection connection) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Post post = mapper.readValue(connection.getInputStream(), Post.class);
            System.out.println(post);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void getPostById(int id) {
        URL url;
        HttpURLConnection connection = null;
        try {
            url = new URL(JSONPLACEHOLDER_POSTS + id);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        assert connection != null;
        readResponse(connection);
    }

    @Override
    public void publishPost(String title) {
        URL url;
        HttpURLConnection connection = null;
        try {
            url = new URL(JSONPLACEHOLDER_POSTS);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-type", PROPERTY);
            connection.setDoOutput(true);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        Post post = new Post(1, title, BODY);
        ObjectMapper mapper = new ObjectMapper();
        try {
            assert connection != null;
            mapper.writeValue(connection.getOutputStream(), post);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        readResponse(connection);
    }
}
