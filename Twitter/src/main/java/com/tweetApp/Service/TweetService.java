package com.tweetApp.Service;

import java.util.List;

import com.tweetApp.dto.TweetResponseDTO;
import com.tweetApp.model.Reply;
import com.tweetApp.model.Tweet;

public interface TweetService {

	public Tweet posttweet(Tweet tweet);

	public List<TweetResponseDTO> getAllTweets();

	public Reply postReply(Reply reply);

	public String deleteTweet(String tweetId);

}
