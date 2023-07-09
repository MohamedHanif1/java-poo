package com.example.PROJETSPRING.Services;
import com.example.PROJETSPRING.Model.Fournisseur;
import com.example.PROJETSPRING.Repository.FournisseurRepository;
import com.example.PROJETSPRING.Security.ClientPrincipal;
import com.example.PROJETSPRING.Model.Client;
import com.example.PROJETSPRING.Repository.ClientRepository;
import com.example.PROJETSPRING.Security.FournisseurPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    private ClientRepository clientRepository;
    private FournisseurRepository fournisseurRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.findByEmail(username);
        if (client == null) {
            throw new UsernameNotFoundException(username);
        }
        return new ClientPrincipal(client);
    }

    public UserDetails chargeUserByUsername(String username) throws UsernameNotFoundException {
        Fournisseur fournisseur = fournisseurRepository.findByEmail(username);
        if (fournisseur == null) {
            throw new UsernameNotFoundException(username);
        }
        return new FournisseurPrincipal(fournisseur);
    }

}
