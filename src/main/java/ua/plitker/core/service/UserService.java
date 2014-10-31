package ua.plitker.core.service;

import org.springframework.beans.factory.annotation.Autowired;

import ua.plitker.core.model.User;
import ua.plitker.core.repository.UserRepository;

public class UserService {
	
	@Autowired
	UserRepository repository;

	public void save(User user) {
		repository.save(user);
	}
	
	public Iterable<User> findAll() {
		return repository.findAll();
	}
}
