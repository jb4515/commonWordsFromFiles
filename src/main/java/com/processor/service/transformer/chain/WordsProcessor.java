package com.processor.service.transformer.chain;


import java.util.List;


/**
 * Created by jitesh-kumar on 12/8/18.
 */
public interface WordsProcessor {

  void setNext(WordsProcessor wordsProcessor);
  List<String> process(String inputData);
}
