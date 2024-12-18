package com.techeazy.RegisterAndLogin.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techeazy.RegisterAndLogin.Services.RegisterService;
import com.techeazy.RegisterAndLogin.entities.User;

@RestController
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	
	@PostMapping("/register")
	public User RegisterUser(@RequestBody User user) throws Exception
	{
		User userobj = null;
		
		String tempemailId = user.getEmailId();
		String tempusername = user.getUsername();
		String temppassword = user.getPassword();
		
		if(tempemailId==null || tempemailId.equals(""))
		{
			throw new Exception("Enter email Id");
		}
		
		if(tempusername==null || tempusername.equals(""))
		{
			throw new Exception("Enter UserName");
		}
		
		if(temppassword==null || temppassword.equals(""))
		{
			throw new Exception("Enter Password");
		}
		
		
		if(tempemailId!=null && !tempemailId.equals(""))
		{
			userobj = this.registerService.fetchUserByEmailId(tempemailId);
			
			if(userobj!=null)
			{
				throw new Exception("EmailId : " + tempemailId + " already exists");
			}
		}
		
		userobj = this.registerService.saveUser(user);
		return userobj;
	}
	
	@PostMapping("login")
	public User LoginUser(@RequestBody User user) throws Exception
	{
		User userobj = null;
		
		String tempemailId = user.getEmailId();
		String temppassword = user.getPassword();
		
		if(tempemailId==null || tempemailId.equals(""))
		{
			throw new Exception("Enter email Id");
		}
		

		if(temppassword==null || temppassword.equals(""))
		{
			throw new Exception("Enter Password");
		}
		
		
		if(tempemailId!=null && temppassword!=null)
		{
			userobj = this.registerService.fetchUserByEmailIdAndPassword(tempemailId, temppassword);
			
			if(userobj==null)
			{
				throw new Exception("Bad credentials");
			}
		}
		
		return userobj;
	}
}
