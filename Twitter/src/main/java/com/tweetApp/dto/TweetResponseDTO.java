package com.tweetApp.dto;

import java.util.List;

public class TweetResponseDTO {
	
	private String tweetDesc;
	
	private String tweetBy;
	
	private String tweetId;
	
	private String date;
	
	private List<ReplyDTO> replyDTOList;

	public String getTweetDesc() {
		return tweetDesc;
	}

	public void setTweetDesc(String tweetDesc) {
		this.tweetDesc = tweetDesc;
	}

	public String getTweetBy() {
		return tweetBy;
	}

	public void setTweetBy(String tweetBy) {
		this.tweetBy = tweetBy;
	}

	public String getTweetId() {
		return tweetId;
	}

	public void setTweetId(String tweetId) {
		this.tweetId = tweetId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<ReplyDTO> getReplyDTOList() {
		return replyDTOList;
	}

	public void setReplyDTOList(List<ReplyDTO> replyDTOList) {
		this.replyDTOList = replyDTOList;
	}

	
	
	
	

}
