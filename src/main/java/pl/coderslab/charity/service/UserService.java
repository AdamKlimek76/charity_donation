package pl.coderslab.charity.service;

import pl.coderslab.charity.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUserName(String name);

    void saveUser(User user);

    boolean doesUserExist(String username);
}
