package com.tweetApp.ServiceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tweetApp.Repository.ReplyRepository;
import com.tweetApp.Repository.TweetRepository;
import com.tweetApp.Repository.UserRepository;
import com.tweetApp.Service.TweetService;
import com.tweetApp.dto.ReplyDTO;
import com.tweetApp.dto.TweetResponseDTO;
import com.tweetApp.model.Reply;
import com.tweetApp.model.Tweet;

@Service
public class TweetServiceImpl implements TweetService {

	@Autowired
	TweetRepository tweetRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	ReplyRepository replyRepo;

	

	
	

	@Override
	public String deleteTweet(String tweetId) {
		
		tweetRepo.deleteById(tweetId);
		return "success";
	}

	@Override
	public Tweet posttweet(Tweet tweet) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		tweet.setDate(dtf.format(now));
		tweet.setId(UUID.randomUUID().toString());
		
//		List<Tweet> tweetList = tweetRepo.findAll();
//		if (tweetList == null) {
//			tweet.setId(1);
//		} else {
//			int count = tweetList.size();
//			tweet.setId(count + 1);
//		}
		return tweetRepo.save(tweet);
	}

	@Override
	public Reply postReply(Reply reply) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		reply.setDate(dtf.format(now));

		return replyRepo.save(reply);
	}
	public List<TweetResponseDTO> getAllTweets() {
		

		List<TweetResponseDTO> tweetResponseDTOList = new ArrayList<>();
		List<Tweet> tweetList = new ArrayList<>();
		Iterable<Tweet> iterable = tweetRepo.findAll();
		iterable.forEach(tweetList :: add);
		tweetList.stream().forEach(tweet -> {
			TweetResponseDTO tweetResponseDTO = new TweetResponseDTO();
			tweetResponseDTO.setTweetDesc(tweet.getTweetDesc());
			tweetResponseDTO.setTweetBy(tweet.getEmail());
			tweetResponseDTO.setTweetId(tweet.getId());
			tweetResponseDTO.setDate(tweet.getDate());
			List<Reply> replyList = replyRepo.findByTweetId(tweet.getId());
			List<ReplyDTO> replyDTOList = new ArrayList<>();
			replyList.stream().forEach(reply -> {
				ReplyDTO replyDTO = new ReplyDTO();
				replyDTO.setEmail(reply.getEmail());
				replyDTO.setReplyDesc(reply.getReplyDesc());
				replyDTO.setTweetId(reply.getTweetId());
				replyDTO.setDate(reply.getDate());
				replyDTOList.add(replyDTO);
			});

			tweetResponseDTO.setReplyDTOList(replyDTOList);
			tweetResponseDTOList.add(tweetResponseDTO);
		});

		return tweetResponseDTOList;

	}
}
