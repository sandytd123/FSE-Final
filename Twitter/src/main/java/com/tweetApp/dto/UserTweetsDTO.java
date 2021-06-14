package com.tweetApp.dto;

import java.util.List;

public class UserTweetsDTO {
	
	private String tweetId;
	
	private String tweetDesc;
	
	private String Date;
	
	private List<ReplyDTO> replyDTOList;

	public String getTweetId() {
		return tweetId;
	}

	public void setTweetId(String tweetId) {
		this.tweetId = tweetId;
	}

	public String getTweetDesc() {
		return tweetDesc;
	}

	public void setTweetDesc(String tweetDesc) {
		this.tweetDesc = tweetDesc;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public List<ReplyDTO> getReplyDTOList() {
		return replyDTOList;
	}

	public void setReplyDTOList(List<ReplyDTO> replyDTOList) {
		this.replyDTOList = replyDTOList;
	}

	

}
