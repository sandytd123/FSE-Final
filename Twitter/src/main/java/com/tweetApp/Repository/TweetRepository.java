package com.tweetApp.Repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tweetApp.model.Tweet;

@EnableScan
@Repository
public interface TweetRepository extends CrudRepository<Tweet, Integer> {

	public List<Tweet> findByEmail(String email);

	public void  deleteById(String id);
}
