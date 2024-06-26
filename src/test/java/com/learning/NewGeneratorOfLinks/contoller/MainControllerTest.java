package com.learning.NewGeneratorOfLinks.contoller;

import com.learning.NewGeneratorOfLinks.controllers.MainController;
import com.learning.NewGeneratorOfLinks.models.Url;
import com.learning.NewGeneratorOfLinks.service.UrlService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class MainControllerTest {

    @InjectMocks
    private MainController mainController;

    @Mock
    private UrlService urlService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUpMock(){
        mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    void findUrl() throws Exception {
        Url url = urlService.addUrl("newUrl");
        System.out.println(url.getFullUrl());
        System.out.println(url.getShortUrl());
        when(urlService.findUrl(url.getShortUrl())).thenReturn(url.getFullUrl());
        mockMvc.perform(get("/urls/findUrl/{shortUrl}"))
               .andExpect(status().isOk());
        verify(urlService,times(1)).findUrl(url.getShortUrl());
    }
}
