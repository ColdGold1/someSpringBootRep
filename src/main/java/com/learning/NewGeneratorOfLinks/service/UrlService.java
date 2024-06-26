package com.learning.NewGeneratorOfLinks.service;

import com.learning.NewGeneratorOfLinks.models.Url;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UrlService {

    private final HashMap<String, String> urls = new HashMap<>();

    public UrlService() {

        urls.put(findUniqueUrl(), "https://habr.com/ru/companies/piter/articles/676394/");
        urls.put(findUniqueUrl(), "https://for-each.dev/lessons/b/-lombok-builder");
    }

    public Map<String, String> getUrls() {
        return urls;
    }

    public Map.Entry<String, String> addUrl(String fullUrl) {
        if (fullUrl == null || fullUrl.isEmpty()) {
            return null;
        }
        if (urls.containsValue(fullUrl)) {
            for (Map.Entry<String, String> url : urls.entrySet())
                if (url.getValue().equals(fullUrl)) {
                    return url;
                }
        }
        String shortUrl = findUniqueUrl();
        urls.put(shortUrl, fullUrl);
        return new AbstractMap.SimpleEntry<>(shortUrl, urls.get(shortUrl));
    }

    public String getFullUrl(String shortUrl) {
        return urls.get(shortUrl);
    }

    public String findUniqueUrl() {
        StringBuilder result = new StringBuilder();
        do {
            result.delete(0, result.length());
            result.append(Url.makeShortUrl());
        } while (urls.containsKey(result.toString()));
        return result.toString();
    }

}
