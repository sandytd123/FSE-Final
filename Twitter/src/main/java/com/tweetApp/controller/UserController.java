package com.tweetApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweetApp.Service.UserService;
import com.tweetApp.dto.LoginRequest;
import com.tweetApp.dto.LoginResponse;
import com.tweetApp.dto.ResetPasswordRequestDTO;
import com.tweetApp.dto.UserList;
import com.tweetApp.dto.UserTweetsDTO;
import com.tweetApp.model.Registration;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(tags = { "TwittersUserManagement" })
@RestController
@RequestMapping(value = "/api/v1.0/tweets")
@CrossOrigin("*")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	KafkaTemplate<String, String> kafka;
	
	public String topic ="welcome";

	
	
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 401, message = "Unauthorized access"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Registration registrationDto) {
		
		String status = userService.add(registrationDto);
		return ResponseEntity.ok().body(status);
	}

	
	
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 401, message = "Unauthorized access"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> Login(@RequestBody LoginRequest loginRequest) {
		LoginResponse loginResponse = new LoginResponse();
		loginResponse = userService.Login(loginRequest);

		return ResponseEntity.ok().body(loginResponse);
	}

	
	
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 401, message = "Unauthorized access"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@PutMapping("/reset")
	public ResponseEntity<ResetPasswordRequestDTO> resetpassword(@RequestBody ResetPasswordRequestDTO resetRequest) {
		ResetPasswordRequestDTO resetPasswordResponseDTO = new ResetPasswordRequestDTO();
		resetPasswordResponseDTO = userService.resetpassword(resetRequest);

		return ResponseEntity.ok().body(resetPasswordResponseDTO);
	}

	
	
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 401, message = "Unauthorized access"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping("/getallUsers")
	public ResponseEntity<List<UserList>> getAllUsers() {
		//kafka.send(topic,"succcess");
		return ResponseEntity.ok().body(userService.getAllUsers());
	}

	
	
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 401, message = "Unauthorized access"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping("/UsersTweet")
	public ResponseEntity<List<UserTweetsDTO>> getUsersTweet(@RequestParam("email") String email) {
		return ResponseEntity.ok().body(userService.getUsersTweet(email));
	}
}
