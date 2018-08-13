package com.processor.service;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import com.processor.service.transformer.chain.WordsProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;


/**
 * Created by jitesh-kumar on 12/8/18.
 */

@Service
@Slf4j
public class StringTransformationService {

  @Autowired
  private FindCommonWordsService findCommonWordsService;

  @Autowired
  private ApplicationContext applicationContext;

  private
  @Value("${transformer.first.processor}")
  String initialProcessorValue;

  private WordsProcessor initialProcessor;

  @PostConstruct
  public void init() {
    this.initialProcessor = applicationContext.getBean(initialProcessorValue, WordsProcessor.class);
  }

  public List<String> process(final List<String> fileNames) {
    List<List<String>> filesContent = new ArrayList<>(fileNames.size());
    log.info("Transforming through different processors for files {}", fileNames.toString());
    fileNames.parallelStream().forEach(f ->
                                         filesContent.add(initialProcessor.process(f)));
    log.info("Counting common words for files {}", fileNames.toString());
    return findCommonWordsService.process(filesContent);
  }
}
