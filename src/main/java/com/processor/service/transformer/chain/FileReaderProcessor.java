package com.processor.service.transformer.chain;


import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


/**
 * Created by jitesh-kumar on 12/8/18.
 */
@Data
@Slf4j
@Component("fileReader")
class FileReaderProcessor implements WordsProcessor {

  private @Value("${filereader.next.processor}") String nextProcessor;

  @Autowired
  ApplicationContext applicationContext;

  private WordsProcessor next;

  @PostConstruct
  public void init() {
    this.next = StringUtils.isEmpty(nextProcessor) ? null : applicationContext.getBean(nextProcessor, WordsProcessor.class);
  }

  @Override public List<String> process(final String filePath) {
    List<String> words  = new ArrayList<>();
    if(!StringUtils.isEmpty(filePath)){
      Path file = Paths.get(filePath);
      if(Files.exists(file)){
        try(BufferedReader br = Files.newBufferedReader(file)){
          List<String> lines = br.lines().collect(Collectors.toList());
          lines.forEach((String line) -> words.addAll(this.getNext().process(line)));
        }catch (IOException e){
          //TODO logging
        }
      }
      else {
      log.error("Unable to find file {}", file.getFileName());
      }

    }
    return words;
  }
}
