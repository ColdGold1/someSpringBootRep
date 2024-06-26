package com.learning.NewGeneratorOfLinks.service;


import com.learning.NewGeneratorOfLinks.models.Url;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UrlServiceTest {
   private UrlService urlService;

   @BeforeEach
   public void setUpService(){
      urlService = new UrlService();
   }

   @Test
   public void test_findUrl_returningUrl(){
      String fullUrl = "https://wago.io/";
      Url url = urlService.addUrl(fullUrl);
      String result = urlService.findUrl(url.getShortUrl());
      Assertions.assertEquals(fullUrl,result);
   }

   @Test
   public void test_findUrl_returningNothing(){
      String fullUrl = "https://wago.io/";
      String result = urlService.findUrl("...");
      Assertions.assertNotEquals(fullUrl,result);
   }
}
