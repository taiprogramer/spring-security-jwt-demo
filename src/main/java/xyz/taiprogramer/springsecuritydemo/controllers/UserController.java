package xyz.taiprogramer.springsecuritydemo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.taiprogramer.springsecuritydemo.dto.UserDto;
import xyz.taiprogramer.springsecuritydemo.models.Role;
import xyz.taiprogramer.springsecuritydemo.models.User;
import xyz.taiprogramer.springsecuritydemo.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

        @Autowired
        private UserService userService;

        @GetMapping("")
        private List<UserDto> index() {
                List<User> users = userService.listAll();
                List<UserDto> listUserDto = new ArrayList<>();
                for (User user : users) {
                        UserDto userDto = new UserDto();
                        userDto.setUsername(user.getUsername());
                        List<String> roles = new ArrayList<>();
                        for (Role role : user.getRoles()) {
                                roles.add(role.getName());
                        }
                        userDto.setRole(roles);
                        listUserDto.add(userDto);
                }
                return listUserDto;
        }
}
