package org.event.repository;

import java.util.Optional;

import org.event.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUserName(String username);
}
