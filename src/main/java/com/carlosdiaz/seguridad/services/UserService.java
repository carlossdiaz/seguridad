package com.carlosdiaz.seguridad.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.carlosdiaz.seguridad.models.Permission;
import com.carlosdiaz.seguridad.models.User;
import com.carlosdiaz.seguridad.repositories.UserRepository;





@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User getUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByNombre(username);

        List<Permission> permissions = user.getPermissions();
        

        List <GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        for(Permission p : permissions){
            roles.add(new SimpleGrantedAuthority(p.getDescripcion()));
        }
        UserDetails uDetails = org.springframework.security.core.userdetails.User.builder()
        .username(user.getNombre())
        .password(user.getPassword())
        .authorities(roles)
        .build();
        
        return uDetails;
    }
}
