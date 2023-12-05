package xyz.taiprogramer.springsecuritydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.taiprogramer.springsecuritydemo.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
