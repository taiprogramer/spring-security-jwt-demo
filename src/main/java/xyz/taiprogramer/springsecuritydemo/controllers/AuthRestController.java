package xyz.taiprogramer.springsecuritydemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.taiprogramer.springsecuritydemo.config.JwtUtil;
import xyz.taiprogramer.springsecuritydemo.dto.JwtRequest;
import xyz.taiprogramer.springsecuritydemo.dto.JwtResponse;
import xyz.taiprogramer.springsecuritydemo.services.JwtUserDetailsService;

@RestController()
@RequestMapping("/authenticate")
public class AuthRestController {

        @Autowired
        private AuthenticationManager authenticationManager;

        @Autowired
        private JwtUtil jwtUtil;

        @Autowired
        private JwtUserDetailsService jwtUserDetailsService;

        @PostMapping("")
        private ResponseEntity<JwtResponse> login(@RequestBody JwtRequest body) {
                try {
                        authenticate(body.getUsername(), body.getPassword());
                } catch (Exception e) {
                        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
                }

                UserDetails userDetails = jwtUserDetailsService
                                .loadUserByUsername(body.getUsername());
                String token = jwtUtil.generateToken(userDetails);
                JwtResponse response = new JwtResponse();
                response.setAccessToken(token);
                return new ResponseEntity<>(response, HttpStatus.OK);
        }

        private void authenticate(String username, String password) throws Exception {
                try {
                        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
                } catch (BadCredentialsException e) {
                        throw new Exception("INVALID_CREDENTIALS", e);
                }
        }
}