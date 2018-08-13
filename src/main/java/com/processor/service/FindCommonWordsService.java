package com.processor.service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


/**
 * Created by jitesh-kumar on 12/8/18.
 */

@Service
class FindCommonWordsService {

  public List<String> process(final List<List<String>> inputData) {
    List<String> commonWords = new ArrayList<>();

    if(!CollectionUtils.isEmpty(inputData)) {
      int size = inputData.size();

      List<Set<String>> maps = inputData.stream().map(HashSet::new).collect(Collectors.toList());

      int index = 0;
      boolean presentInAllFiles = true;
      for (String word : maps.get(0)) {
        index = 0;
        presentInAllFiles = true;
        for (int i = 0; i < size - 1; i++) {
          if (!maps.get(++index).contains(word)) {
            presentInAllFiles = false;
            break;
          }
        }
        if (presentInAllFiles) {
          commonWords.add(word);
        }
      }
    }
    return commonWords;
  }
}