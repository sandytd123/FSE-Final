 package com.tweetApp.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetApp.Repository.RegistrationRepository;
import com.tweetApp.Repository.ReplyRepository;
import com.tweetApp.Repository.TweetRepository;
import com.tweetApp.Repository.UserRepository;
import com.tweetApp.Service.UserService;
import com.tweetApp.dto.LoginRequest;
import com.tweetApp.dto.LoginResponse;
import com.tweetApp.dto.ReplyDTO;
import com.tweetApp.dto.ResetPasswordRequestDTO;
import com.tweetApp.dto.UserList;
import com.tweetApp.dto.UserTweetsDTO;
import com.tweetApp.model.Registration;
import com.tweetApp.model.Reply;
import com.tweetApp.model.Tweet;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userrepo;

	@Autowired
	private RegistrationRepository registerrepo;

	@Autowired
	private TweetRepository tweetRepo;

	@Autowired
	ReplyRepository replyRepo;

	@Override
	public LoginResponse Login(LoginRequest Request) {

		LoginResponse Response = new LoginResponse();

		Registration registration = userrepo.findByemail(Request.getEmail());
		if (registration != null) {
			if (!registration.getPassword().equals(Request.getPassword())) {

				Response.setErrorMessage("Incorrect UserName/Password");

				return Response;

			}

			Response.setEmail(registration.getEmail());

			return Response;
		} else {

			Response.setErrorMessage("Incorrect UserName/Password");

		}

		return Response;
	}

	@Override
	public List<UserList> getAllUsers() {
		// TODO Auto-generated method stub

		List<UserList> userList = new ArrayList<>();
		List<Registration> registration = registerrepo.findAll();
		registration.parallelStream().forEach(user -> {
			UserList userInfo = new UserList();
			userInfo.setId(user.getId());
			userInfo.setEmail(user.getEmail());
			userInfo.setFirstName(user.getFirstName());
			userInfo.setGender(user.getGender());
			userInfo.setContactNo(user.getContactNo());

			userList.add(userInfo);
		});

		return userList;
	}

	@Override
	public List<UserTweetsDTO> getUsersTweet(String email) {
		List<UserTweetsDTO> userTweetsDTOList = new ArrayList<>();
		List<Tweet> tweetList = tweetRepo.findByEmail(email);
		tweetList.stream().forEach(tweet -> {
			UserTweetsDTO userTweetsDTO = new UserTweetsDTO();
			userTweetsDTO.setTweetId(tweet.getId());
			userTweetsDTO.setTweetDesc(tweet.getTweetDesc());
			userTweetsDTO.setDate(tweet.getDate());
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
			userTweetsDTO.setReplyDTOList(replyDTOList);
			userTweetsDTOList.add(userTweetsDTO);
		});

		return userTweetsDTOList;
	}

	@Override
	public String add(Registration register) {

		if (register.getEmail() != null) {
			Registration check = userrepo.findByemail(register.getEmail());
			
			if (check != null) {
				return "email id exist";

			} else {
				register.setId(UUID.randomUUID().toString());
				Registration r = registerrepo.save(register);
				if (r != null)
					return "succes";
				else
					return "something wrong";

			}

		}
		return "please provide email";

	}

	@Override
	public ResetPasswordRequestDTO resetpassword(ResetPasswordRequestDTO resetRequest) {
		// TODO Auto-generated method stub

		Optional<Registration> registerOptional = Optional.empty();

		ResetPasswordRequestDTO resetPasswordRequestDTO = new ResetPasswordRequestDTO();

		registerOptional = registerrepo.findByemail(resetRequest.getEmail());
		Registration registration = (registerOptional.isPresent()) ? registerOptional.get() : new Registration();
		if (registration.getPassword() != null && registration.getPassword().equals(resetRequest.getOldpassword())) {
			registration.setPassword(resetRequest.getNewpassword());
			Registration registerReturnedObject = registerrepo.save(registration);
			resetPasswordRequestDTO.setSuccesmessage("Successfully Updated the password");
		} else {
			resetPasswordRequestDTO.setErrormessage("The old password is incorrect");
		}

		return resetPasswordRequestDTO;
	}

}
