package xyz.taiprogramer.springsecuritydemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.taiprogramer.springsecuritydemo.models.User;
import xyz.taiprogramer.springsecuritydemo.repository.UserRepository;

@Service
public class UserServiceJpaImpl implements UserService {

        @Autowired
        private UserRepository userRepository;

        @Override
        public List<User> listAll() {
                return userRepository.findAll();
        }

        @Override
        public User getById(Long id) {
                return userRepository.getById(id);
        }

        @Override
        public User saveOrUpdate(User user) {
                return userRepository.save(user);
        }

        @Override
        public void deleteById(Long id) {
                userRepository.deleteById(id);
        }

        @Override
        public User findByUsername(String username) {
                return userRepository.findByUsername(username);
        }
}
