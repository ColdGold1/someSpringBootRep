package com.learning.NewGeneratorOfLinks.controllers;


import ch.qos.logback.core.model.Model;
import com.learning.NewGeneratorOfLinks.models.Url;
import com.learning.NewGeneratorOfLinks.service.UrlService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/urls")
@AllArgsConstructor
public class MainController {

    private final UrlService service;

    @GetMapping("")
    public List<Url> getUrls() {
        return service.getUrls();
    }


    @PutMapping("addUrl")
    public Url addUrl(@RequestParam String fullUrl) {
        return service.addUrl(fullUrl);
    }

    @GetMapping("findUrl/{shortUrl}")
    public void findUrl(@PathVariable String shortUrl, HttpServletResponse response) throws IOException {
        String fullUrl = service.findUrl(shortUrl);
        if (fullUrl != null) {
            response.sendRedirect(fullUrl);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

}
