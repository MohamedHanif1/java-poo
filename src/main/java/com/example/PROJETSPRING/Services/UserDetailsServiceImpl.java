package com.example.PROJETSPRING.Services;

import com.example.PROJETSPRING.Model.Client;
import com.example.PROJETSPRING.Model.Provider;
import com.example.PROJETSPRING.Repository.ClientRepository;
import com.example.PROJETSPRING.Repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProviderRepository providerRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Client client = clientRepository.findByName(name);
        Provider provider = providerRepository.findByName(name);

        if (client == null && provider == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(client, provider);
    }
}






