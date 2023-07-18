package com.example.PROJETSPRING.Services;

import com.example.PROJETSPRING.Model.Client;
import com.example.PROJETSPRING.Model.Provider;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MyUserDetails implements UserDetails {

    private Client client;
    private Provider provider;

    public MyUserDetails(Client client, Provider provider) {
        this.client = client;
        this.provider = provider;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("CLIENT"));
        authorities.add(new SimpleGrantedAuthority("PROVIDER"));
        return authorities;
    }

    @Override
    public String getPassword() {
        if (client != null) {
            return client.getPassword();
        } else if (provider != null) {
            return provider.getPassword();
        } else {
            throw new IllegalStateException("No client or provider set");
        }
    }

    @Override
    public String getUsername() {
        if (client != null) {
            return client.getName();
        } else if (provider != null) {
            return provider.getName();
        } else {
            throw new IllegalStateException("No client or provider set");
        }
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Client getClient() {
        return client;
    }

    public Provider getProvider() {
        return provider;
    }
}
