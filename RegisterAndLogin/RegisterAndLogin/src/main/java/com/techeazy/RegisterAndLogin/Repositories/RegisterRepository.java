package com.techeazy.RegisterAndLogin.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techeazy.RegisterAndLogin.entities.User;

@Repository
public interface RegisterRepository extends JpaRepository<User, Integer>{
	
	public User findByEmailId(String emailId);
	
	public User findByEmailIdAndPassword(String emailId , String password);

}
