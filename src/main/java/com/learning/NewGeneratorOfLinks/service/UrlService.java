package com.learning.NewGeneratorOfLinks.service;

import com.learning.NewGeneratorOfLinks.models.Url;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UrlService {
    private final List<Url> urls = new ArrayList<>();

    UrlService() {
        urls.add(new Url("https://habr.com/ru/companies/piter/articles/676394/"));
        urls.add(new Url("https://for-each.dev/lessons/b/-lombok-builder"));
    }

    public List<Url> getUrls() {
        return urls;
    }

    public Url addUrl(String fullUrl) {
        Url url = new Url(fullUrl);
        urls.add(url);
        return url;
    }

    public String findUrl(String shortUrl) {
        for (Url url : urls) {
            if (url.getShortUrl().equals(shortUrl)) {
                return url.getFullUrl();
            }
        }
        return "There is no such url";
    }
}
