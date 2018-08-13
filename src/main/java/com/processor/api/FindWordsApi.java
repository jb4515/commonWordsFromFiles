package com.processor.api;


import java.util.List;

import com.processor.service.IFindWordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by jitesh-kumar on 12/8/18.
 */

@RestController
public class FindWordsApi extends BaseApi {

  @Autowired
  private IFindWordsService commonWordsService;

  @PostMapping(value = "/commonwords")
  public @ResponseBody List<String> getCommonWords(@RequestBody List<String> fileNames) {
    return commonWordsService.getWords(fileNames);
  }
}
