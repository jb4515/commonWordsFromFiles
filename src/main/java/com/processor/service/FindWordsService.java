package com.processor.service;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


/**
 * Created by jitesh-kumar on 12/8/18.
 */

@Service
@Slf4j
class FindWordsService implements IFindWordsService {

  @Autowired
  private StringTransformationService stringTransformationService;

  private @Value("${default.filenames}") String defaultFileNames;


  @Override public List<String> getWords(final List<String> fileNames) {
    return stringTransformationService.process(validateFileNames(fileNames));
  }

  private List<String> validateFileNames(final List<String> inputFileNames) {
    //TODO running fine with spring boot, fix for tomcat package classpath
    if(CollectionUtils.isEmpty(inputFileNames)){
      log.debug("No input file names provided, using default files.");
      return Arrays.stream(defaultFileNames.split(",")).collect(Collectors.toList());
    }
    log.debug("Finding common words for files {}", inputFileNames.toString());
    return inputFileNames;
  }
}
