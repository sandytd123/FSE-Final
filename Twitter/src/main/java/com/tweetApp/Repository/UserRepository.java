package com.tweetApp.Repository;


import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tweetApp.model.Registration;

@EnableScan
@Repository
public interface UserRepository extends CrudRepository<Registration, Integer> {

	public Registration findByemail(String email);

	public Registration findById(String id);

}
