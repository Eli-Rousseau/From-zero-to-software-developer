package com.codewithmosh.facade;

public class Demo {
  public static void show() {
    var service = new TwitterCommunicationService();
    service.getRecentTweets("appKey", "secret");
  }
}
