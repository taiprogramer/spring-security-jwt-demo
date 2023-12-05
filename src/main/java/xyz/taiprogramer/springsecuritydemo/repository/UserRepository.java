package xyz.taiprogramer.springsecuritydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.taiprogramer.springsecuritydemo.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
        User findByUsername(String username);
}
