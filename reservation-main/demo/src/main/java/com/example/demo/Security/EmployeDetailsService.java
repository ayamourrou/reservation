package com.example.demo.Security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Employe;
import com.example.demo.Repositories.EmployeRepository;

import java.util.Collections;

@Service
public class EmployeDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeDetailsService.class);

    private final EmployeRepository employeRepository;

    public EmployeDetailsService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Attempting to load user by username: {}", username);
        
        Employe employe = employeRepository.findByUsername(username)
                .orElseThrow(() -> {
                    logger.error("User not found with username: {}", username);
                    return new UsernameNotFoundException("User not found with username: " + username);
                });

        String role = employe.getRole();
        if (role == null) {
            logger.error("User has no role assigned: {}", username);
            throw new UsernameNotFoundException("User has no role assigned: " + username);
        }

        logger.info("User found with username: {}, role: {}", username, role);

        return new User(employe.getUsername(), employe.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role)));
    }
}
