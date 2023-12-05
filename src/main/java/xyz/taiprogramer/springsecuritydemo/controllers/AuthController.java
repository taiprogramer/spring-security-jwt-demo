package xyz.taiprogramer.springsecuritydemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AuthController {
        @RequestMapping("")
        private String index() {
                return "auth/login";
        }
}