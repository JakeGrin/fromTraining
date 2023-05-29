package com.training.sgorodecki.homework.homework14.model;

import com.google.gson.Gson;
import com.training.sgorodecki.homework.homework14.service.Post;
import com.training.sgorodecki.homework.homework14.serviceImpl.WebClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClient implements WebClient {
    private static final String JSONPLACEHOLDER_POSTS = "https://jsonplaceholder.typicode.com/posts/";
    private static final String ACCEPT = "application/json";
    private static final String PROPERTY = "application/json; charset=UTF-8";
    private static final String BODY = "message";
    private static final String ACCEPT_NAME = "Accept";
    private static final String PROPERTY_NAME = "Content-type";

    @Override
    public void getPostById(int id) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(JSONPLACEHOLDER_POSTS + id);
            ResponseHandler<String> responseHandler = httpResponse -> EntityUtils.toString(httpResponse.getEntity());
            String httpResponse = httpClient.execute(httpGet, responseHandler);
            Post post = new Gson().fromJson(httpResponse, Post.class);
            System.out.println(post);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void publishPost(String title) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(JSONPLACEHOLDER_POSTS);
            String gson = new Gson().toJson(new Post(1, title, BODY));
            StringEntity entityObject = new StringEntity(gson);
            httpPost.setEntity(entityObject);
            httpPost.setHeader(ACCEPT_NAME, ACCEPT);
            httpPost.setHeader(PROPERTY_NAME, PROPERTY);
            ResponseHandler<String> responseHandler = httpResponse -> EntityUtils.toString(httpResponse.getEntity());
            String httpResponse = httpClient.execute(httpPost, responseHandler);
            Post post = new Gson().fromJson(httpResponse, Post.class);
            System.out.println(post.toString());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}