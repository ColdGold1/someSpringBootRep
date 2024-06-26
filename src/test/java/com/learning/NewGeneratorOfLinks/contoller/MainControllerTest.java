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

import java.util.Map;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class MainControllerTest {

    @InjectMocks
    private MainController mainController;

    @Mock
    private UrlService urlService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUpMock() {
        mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    void findUrl() throws Exception {
        String shortUrl = "123aBc";
        String fullUrl = "https://docs.spring.io/spring-boot/docs/2.1.13.RELEASE/reference/html/production-ready-endpoints.html";
        when(urlService.getFullUrl(shortUrl)).thenReturn(fullUrl);
        mockMvc.perform(get("/urls/getFullUrl/{shortUrl}", shortUrl))
                .andExpect(redirectedUrl(fullUrl));
        verify(urlService, times(1)).getFullUrl(shortUrl);
    }
}
