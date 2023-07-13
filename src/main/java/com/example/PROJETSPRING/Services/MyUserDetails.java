package com.example.PROJETSPRING.Services;

import com.example.PROJETSPRING.Model.Client;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class MyUserDetails implements UserDetails {

    private Client client;

    public MyUserDetails(Client client) {
        this.client = client;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // ici, vous pouvez retourner les rôles du client sous forme de collection de GrantedAuthority.
        // Pour cet exemple, nous supposerons que tous les clients ont le rôle "ROLE_USER".
        return Collections.singleton(new SimpleGrantedAuthority("ClIENT"));
    }

    @Override
    public String getPassword() {
        return client.getPassword();
    }

    @Override
    public String getUsername() {
        return client.getName();
    }

    // Les méthodes suivantes déterminent si le compte est expiré, verrouillé, etc.
    // Dans cet exemple, je suppose que ces fonctionnalités ne sont pas utilisées et retourne simplement true.

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
}
