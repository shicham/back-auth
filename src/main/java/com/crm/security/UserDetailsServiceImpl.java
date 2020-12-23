package com.crm.security;

import java.util.ArrayList;
import java.util.Collection;
import com.crm.forms.User;
import com.crm.forms.GrantedAuthority;
import com.crm.domain.Authority;
import com.crm.domain.UserEntity;
import com.crm.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("userDetailsService")
public class UserDetailsServiceImpl {

   
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserDetails loadUserByUsername(final String login) {

        
        String lowercaseLogin = login.toLowerCase();

        UserEntity userFromDatabase;
        if(lowercaseLogin.contains("@")) {
            userFromDatabase = userRepository.findByEmail(lowercaseLogin);
        } else {
            userFromDatabase = userRepository.findByUsernameCaseInsensitive(lowercaseLogin);
        }
        /***
        if (userFromDatabase == null) {
            throw new Exception("User " + lowercaseLogin + " was not found in the database");
        } else if (!userFromDatabase.isActivated()) {
            throw new Exception("User " + lowercaseLogin + " is not activated");
        }
        **/
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority : userFromDatabase.getAuthorities()) {
            grantedAuthorities.add(authority.getId());
        }

        return new User(userFromDatabase.getUsername(), userFromDatabase.getPassword(), grantedAuthorities);
    }

}