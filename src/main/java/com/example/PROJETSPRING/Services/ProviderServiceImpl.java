package com.example.PROJETSPRING.Services;


import com.example.PROJETSPRING.Commands.ProviderCommand;
import com.example.PROJETSPRING.Exception.IdException;
import com.example.PROJETSPRING.Model.Client;
import com.example.PROJETSPRING.Model.Provider;
import com.example.PROJETSPRING.Repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderRepository providerRepository;
    private PasswordEncoder passwordEncoder;


    public Page<Provider> getAllProviders(Pageable pageable) {

        return providerRepository.findAll(pageable);
    }

    @Override
    public Provider getProviderById(Long id) {
        Optional<Provider> providers = providerRepository.findById(id);
        return providers.orElse(null);
    }


    public Provider createProvider(ProviderCommand providerCommand) {
        String hashedPassword = passwordEncoder.encode(providerCommand.getPassword());
        Provider provider = Provider.create(providerCommand);
        provider.setPassword(hashedPassword);
        return providerRepository.save(provider);
    }


    public Provider updateProvider(Long id , ProviderCommand providerCommand) {
        Provider provider = providerRepository.findById(id)
                .orElseThrow(() -> new IdException("Provider not found with customerId: " + id));
        provider.update(providerCommand);
        return providerRepository.save(provider);
    }


    public void deleteProvider(Long id) {
        Provider provider = providerRepository.findById(id)
                .orElseThrow(() -> new IdException("Provider not found with customerId: " + id));
        providerRepository.deleteById(id);
    }
}
