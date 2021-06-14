package com.tweetApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweetApp.Service.TweetService;
import com.tweetApp.dto.ReplyDTO;
import com.tweetApp.dto.TweetResponseDTO;
import com.tweetApp.dto.UserTweetsDTO;
import com.tweetApp.model.Reply;
import com.tweetApp.model.Tweet;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = { "TwitterManagement" })
@RestController
@RequestMapping(value = "/api/v1.0/tweets")
public class TweetController {

	@Autowired
	TweetService tweetService;

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 401, message = "Unauthorized access"),
			@ApiResponse(code = 500, message = "Internal server error") })

	@PostMapping("/posttweet")
	public Tweet postTweet(@RequestBody Tweet tweetRequest) {
		return tweetService.posttweet(tweetRequest);

	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 401, message = "Unauthorized access"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping("/gettweets")
	public ResponseEntity<List<TweetResponseDTO>> getAllTweets() {

		return ResponseEntity.ok().body(tweetService.getAllTweets());
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 401, message = "Unauthorized access"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@PostMapping("/reply")
	public Reply postReply(@RequestBody Reply replyDTO) {
		return tweetService.postReply(replyDTO);

	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 401, message = "Unauthorized access"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@DeleteMapping("/delete")
	public String deleteTweet(@RequestParam("tweetId") String tweetId) {
		String message = tweetService.deleteTweet(tweetId);

		return message;

	}
}
