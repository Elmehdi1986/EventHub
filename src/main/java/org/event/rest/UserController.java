package org.event.rest;

import java.util.Optional;

import org.event.model.User;
import org.event.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
     
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public ResponseEntity<User> create(@RequestBody User user) {
		if(user.getUserName() == null)
			throw new NullPointerException();
		User u=userRepository.save(user);
	  return new ResponseEntity<User>(u, HttpStatus.CREATED);
	}
	@RequestMapping(value = "/{name}",method = RequestMethod.GET)
	public ResponseEntity<Boolean> getUser(@PathVariable(name = "name") String username) {
		Optional<User> user=userRepository.findByUserName(username);
		if(!user.isPresent()) {
			return new ResponseEntity<Boolean>(false,HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity<Boolean>(true,HttpStatus.ACCEPTED);
	}
	
}
