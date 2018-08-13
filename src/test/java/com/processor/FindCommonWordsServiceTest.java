/*
package com.processor;


import java.util.Arrays;

import com.processor.api.FindWordsApi;
import com.processor.service.IFindWordsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


*/
/**
 * Created by jitesh-kumar on 12/8/18.
 *//*

@RunWith(SpringRunner.class)
@WebMvcTest(value = FindWordsApi.class, secure = false)
public class FindCommonWordsServiceTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private IFindWordsService commonWordsService;

  @Test
  public void findCommonWords() throws Exception {
    java.util.List<String> fileNames = Arrays.asList("files/file1.txt","files/file2.txt","files/file3.txt");

    Mockito.when(
      commonWordsService.getWords(Mockito.anyString(),
                               Mockito.any(fileNames))).thenReturn();

    RequestBuilder requestBuilder = MockMvcRequestBuilders
                                      .post("/api/v1/commonwords")
                                      .accept(MediaType.APPLICATION_JSON).content(fileNames)
                                      .contentType(MediaType.APPLICATION_JSON);


  }
}*/
