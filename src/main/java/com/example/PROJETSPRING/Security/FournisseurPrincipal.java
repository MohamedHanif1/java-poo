package com.example.PROJETSPRING.Security;

import com.example.PROJETSPRING.Model.Fournisseur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class FournisseurPrincipal implements UserDetails {
    private Fournisseur fournisseur;
    public FournisseurPrincipal(Fournisseur fournisseur){this.fournisseur=fournisseur;}
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }
    @Override
    public String getPassword() {
        return fournisseur.getPassword();
    }

    @Override
    public String getUsername() {
        return fournisseur.getEmail();
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
}


