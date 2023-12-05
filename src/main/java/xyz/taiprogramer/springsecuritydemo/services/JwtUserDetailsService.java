package xyz.taiprogramer.springsecuritydemo.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import xyz.taiprogramer.springsecuritydemo.models.Role;
import xyz.taiprogramer.springsecuritydemo.models.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class JwtUserDetailsService implements UserDetailsService {

        @Autowired
        private UserService userService;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                User user = userService.findByUsername(username);
                List<GrantedAuthority> roles = new ArrayList<>();
                for (Role role : user.getRoles()) {
                        roles.add(new SimpleGrantedAuthority(role.getName()));
                }
                org.springframework.security.core.userdetails.User userDetail = new org.springframework.security.core.userdetails.User(
                                user.getUsername(),
                                user.getPassword(),
                                roles);
                return userDetail;
        }
}
