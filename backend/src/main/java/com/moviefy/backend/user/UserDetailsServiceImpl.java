package com.moviefy.backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new RuntimeException("User not found!");
        }
        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();

        for (Role role : user.getRole()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.toString()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPasswors(), grantedAuthorities);
    }
}
