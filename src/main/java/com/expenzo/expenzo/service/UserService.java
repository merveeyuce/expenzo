package com.expenzo.expenzo.service;

import com.expenzo.expenzo.entity.User;
import java.util.List;

/**
 * Service interface for user-related business logic.
 */
public interface UserService {
    User saveUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    void deleteUser(Long id);
}
