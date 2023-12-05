package xyz.taiprogramer.springsecuritydemo.services;

import xyz.taiprogramer.springsecuritydemo.models.User;

public interface UserService extends CRUDService<User> {
        User findByUsername(String username);
}
