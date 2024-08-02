package com.codewithmosh.facade;

import java.util.List;

public class TwitterCommunicationService {

    public List<Tweet> getRecentTweets(String appKey, String secret) {
        var oauth = new OAuth();
        var requestToken = oauth.requestToken(appKey, secret);
        var accessToken = oauth.getAccessToken(requestToken);

        var twitterClient = new TwitterClient();
        var tweets = twitterClient.getRecentTweets(accessToken);
        return tweets;
    }
}
