package com.ucbcba.taller.repositories;

import com.ucbcba.taller.entities.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {

}
