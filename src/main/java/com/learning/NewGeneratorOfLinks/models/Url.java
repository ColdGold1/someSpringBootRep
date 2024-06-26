package com.learning.NewGeneratorOfLinks.models;


import lombok.*;

import java.util.Random;

@Data
public class Url {

    private String fullUrl;
    private String shortUrl;

    public Url() {
    }

    public Url(String fullUrl, String shortUrl) {
        this.fullUrl = fullUrl;
        this.shortUrl = shortUrl;
    }

    public Url(String fullUrl) {
        this.fullUrl = fullUrl;
        shortUrl = makeShortUrl();
    }

    private String makeShortUrl() {
        StringBuilder newShortUrl = new StringBuilder();
        String s = "abcdefghijklmonpqrstuvwxyzABCDEFGHIJKLMOPQRSTUVWXYZ0123456789";
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            newShortUrl.append(s.charAt(random.nextInt(s.length())));
        }

        return newShortUrl.toString();
    }

}
