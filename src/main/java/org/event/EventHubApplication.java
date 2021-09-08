package org.event;

import org.event.model.Members;
import org.event.model.User;
import org.event.repository.MembersRepository;
import org.event.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventHubApplication implements CommandLineRunner{
    
	@Autowired
	MembersRepository membersRepository;
	@Autowired
	UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EventHubApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Members m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15;
	    m1=new Members("mehdi", "Matrane", true);
	    m2=new Members("morad", "Matrane", true);
	    m3=new Members("hicham", "Matrane", true);
	    m4=new Members("abdelhadi", "Matrane", true);
	    m5=new Members("Abdelmajid", "Matrane", true);
	    m6=new Members("simo", "Matrane", true);
	    m7=new Members("Ahmed", "Matrane", true);
	    
	    m8=new Members("noredine", "tamtamani", false);
	    m9=new Members("zobir", "Fadid", false);
	    m10=new Members("younes", "Abid", false);
	    m11=new Members("abdelali", "Matrane",false);
	    m12=new Members("nizar", "tafani", false);
	    m13=new Members("khalid", "khibo", false);
	    m14=new Members("zakaria", "Mardi", false);
	    m15=new Members("amine", "Mardi", false);
	    
	    membersRepository.save(m1);
	    membersRepository.save(m2);
	    membersRepository.save(m3);
	    membersRepository.save(m4);
	    membersRepository.save(m5);
	    membersRepository.save(m6);
	    membersRepository.save(m7);
	    membersRepository.save(m8);
	    membersRepository.save(m9);
	    membersRepository.save(m10);
	    membersRepository.save(m11);
	    membersRepository.save(m12);
	    membersRepository.save(m13);
	    membersRepository.save(m14);
	    membersRepository.save(m15);
	    
	    
	    
	    User u1=new User("user", "user",true,"user");
	    User u2=new User("admin", "admin",true,"admin");
	    
	    userRepository.save(u1);
	    userRepository.save(u2);
	}

}
