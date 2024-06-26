package com.learning.NewGeneratorOfLinks.controllers;


import com.learning.NewGeneratorOfLinks.service.UrlService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/urls")
@AllArgsConstructor
public class MainController {

    private final UrlService service;

    @GetMapping("")
    public Map<String, String> getUrls() {
        return service.getUrls();
    }


    @PutMapping("addUrl")
    public Map.Entry<String,String> addUrl(@RequestParam String fullUrl) {
        return service.addUrl(fullUrl);
    }

    @GetMapping("findUrl/{shortUrl}")
    public void findUrl(@PathVariable String shortUrl, HttpServletResponse response) throws IOException {
        String fullUrl = service.getFullUrl(shortUrl);
        if (fullUrl != null) {
            response.sendRedirect(fullUrl);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

}
