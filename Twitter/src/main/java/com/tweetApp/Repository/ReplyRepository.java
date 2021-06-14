package com.tweetApp.Repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tweetApp.model.Reply;

@EnableScan
@Repository
public interface ReplyRepository extends CrudRepository<Reply, String> {

	List<Reply> findByTweetId(String tweetId);

}
