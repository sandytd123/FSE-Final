
package com.tweetApp.Service;

import java.util.List;

import com.tweetApp.dto.LoginRequest;
import com.tweetApp.dto.LoginResponse;
import com.tweetApp.dto.ResetPasswordRequestDTO;
import com.tweetApp.dto.UserList;
import com.tweetApp.dto.UserTweetsDTO;
import com.tweetApp.model.Registration;

public interface UserService {

	public String add(Registration register);

	public LoginResponse Login(LoginRequest loginRequest);

	public ResetPasswordRequestDTO resetpassword(ResetPasswordRequestDTO resetRequest);

	public List<UserList> getAllUsers();

	public List<UserTweetsDTO> getUsersTweet(String email);

}
