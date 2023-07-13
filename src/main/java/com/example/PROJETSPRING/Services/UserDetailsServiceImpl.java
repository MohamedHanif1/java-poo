package com.example.PROJETSPRING.Services;

import com.example.PROJETSPRING.Model.Client;
import com.example.PROJETSPRING.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Client client = clientRepository.findByName(name);
        if (client == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(client);
    }
}

