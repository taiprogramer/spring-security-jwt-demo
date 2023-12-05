package xyz.taiprogramer.springsecuritydemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.taiprogramer.springsecuritydemo.models.Role;
import xyz.taiprogramer.springsecuritydemo.repository.RoleRepository;

@Service
public class RoleServiceJpaImpl implements RoleService {

        @Autowired
        private RoleRepository roleRepository;

        @Override
        public List<Role> listAll() {
                return roleRepository.findAll();
        }

        @Override
        public Role getById(Long id) {
                return roleRepository.getById(id);
        }

        @Override
        public Role saveOrUpdate(Role role) {
                return roleRepository.save(role);
        }

        @Override
        public void deleteById(Long id) {
                roleRepository.deleteById(id);
        }
}
