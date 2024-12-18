package com.techeazy.RegisterAndLogin.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techeazy.RegisterAndLogin.Repositories.RegisterRepository;
import com.techeazy.RegisterAndLogin.entities.User;

@Service
public class RegisterService {
	
	@Autowired
	private RegisterRepository registerRepository;
	
	
	public User saveUser(User user)
	{
		return this.registerRepository.save(user);
	}
	
	
	public User fetchUserByEmailId(String emailId)
	{
		return this.registerRepository.findByEmailId(emailId);
				
	}
	
	public User fetchUserByEmailIdAndPassword(String emailId , String password)
	{
		return this.registerRepository.findByEmailIdAndPassword(emailId, password);
	}

}
