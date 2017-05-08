package com.ucbcba.taller.services;

import com.ucbcba.taller.entities.User;

public interface UserService {

    public Iterable<User> listAllUsers();

    public Iterable<User> listAllUsersExceptOne(Integer id);

    public User getUserById(Integer id);

    public User saveUser(User user);

    public void deleteUser(Integer id);

}
