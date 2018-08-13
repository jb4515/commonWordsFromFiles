package com.processor.service;


import java.util.List;


/**
 * Created by jitesh-kumar on 12/8/18.
 */

public interface IFindWordsService {

  List<String> getWords(List<String> fileNames);

}
