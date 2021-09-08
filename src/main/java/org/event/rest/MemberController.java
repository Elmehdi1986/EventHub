package org.event.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.event.model.Members;
import org.event.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@CrossOrigin(origins = "http://localhost:4200")
public class MemberController {
            @Autowired
	private MembersRepository membersRepository;
  
	@RequestMapping(value = "/allM",method = RequestMethod.GET)
	public ResponseEntity<List<Members>> getMembers(){
		List<Members> members=membersRepository.findMembersByIsMember(true);
		if(members == null) {
			throw new NullPointerException();
		}
		return new ResponseEntity<List<Members>>(members, HttpStatus.ACCEPTED);
	}
 
	@RequestMapping(value = "/allG",method = RequestMethod.GET)
	public ResponseEntity<List<Members>> getGests(){
		List<Members> members=membersRepository.findMembersByIsMember(false);
		if(members == null) {
			throw new NullPointerException();
		}
		return new ResponseEntity<List<Members>>(members, HttpStatus.ACCEPTED);
	}
	
}
