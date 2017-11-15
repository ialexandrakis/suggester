package org.fuzzypattern.suggester.repository;

import org.fuzzypattern.suggester.domain.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
