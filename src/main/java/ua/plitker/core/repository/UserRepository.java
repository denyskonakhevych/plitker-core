package ua.plitker.core.repository;

import org.springframework.data.repository.CrudRepository;

import ua.plitker.core.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
