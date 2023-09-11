package com.wire.kava.repositories;

import com.wire.kava.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}