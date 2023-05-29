package com.training.sgorodecki.homework.homework14.service;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Post {
    private int userId;
    private int id;
    private String title;
    private String body;

    public Post(int userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString() {
        return "Article [" + getId() + "]:" +
                " User [" + getUserId() + "]" +
                " Title [" + getTitle() + "]" +
                " Message [" + getBody() + "]";
    }
}