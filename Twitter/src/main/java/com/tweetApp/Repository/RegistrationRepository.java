package com.tweetApp.Repository;

import java.util.List;
import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tweetApp.model.Registration;

@EnableScan
@Repository
public interface RegistrationRepository extends  CrudRepository<Registration,Integer> {
	
	Optional<Registration> findByemail(String email);
	
	List<Registration> findAll();

}
