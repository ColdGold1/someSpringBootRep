package com.learning.NewGeneratorOfLinks.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

class UrlServiceTest {
   private UrlService urlService;

   @BeforeEach
   public void setUpService(){
      urlService = new UrlService();
   }

   @Test
   public void test_getFullUrl_returningUrl(){
      String fullUrl = "https://wago.io/";
      Map.Entry<String,String> url = urlService.addUrl(fullUrl);
      String result = urlService.getFullUrl(url.getKey());
      Assertions.assertEquals(fullUrl,result);
   }

   @Test
   public void test_getFullUrl_returningNothing(){
      String fullUrl = "https://wago.io/";
      String result = urlService.getFullUrl("...");
      Assertions.assertNotEquals(fullUrl,result);
   }
}
