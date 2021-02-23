package com.giacom.java.kubernetes.persistence;

import com.giacom.java.kubernetes.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}

