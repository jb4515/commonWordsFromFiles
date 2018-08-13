package com.processor.service.transformer.chain;


import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


/**
 * Created by jitesh-kumar on 12/8/18.
 */

@Data
@Component("lowerCaseProcessor")
class LowerCaseProcessor implements WordsProcessor {

  private
  @Value("${lowerCaseProcessor.next.processor}")
  String nextProcessor;

  @Autowired
  ApplicationContext applicationContext;

  private WordsProcessor next;

  @PostConstruct
  public void init() {
    this.next = StringUtils.isEmpty(nextProcessor) ? null : applicationContext.getBean(nextProcessor, WordsProcessor.class);
  }

  @Override public List<String> process(final String line) {
    return StringUtils.isEmpty(line) ? Collections.emptyList() : this.getNext().process(line.toLowerCase());
  }
}
