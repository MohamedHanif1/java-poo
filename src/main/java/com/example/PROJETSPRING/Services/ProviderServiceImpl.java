package com.example.PROJETSPRING.Services;


import com.example.PROJETSPRING.Model.Provider;
import com.example.PROJETSPRING.Repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    @Override
    public List<Provider> getAllProviders() {

        return providerRepository.findAll();
    }

    @Override
    public Provider getProviderById(Long id) {
        Optional<Provider> providers = providerRepository.findById(id);
        return providers.orElse(null);
    }

    @Override
    public Provider createProvider(Provider provider) {

        return providerRepository.save(provider);
    }

    @Override
    public Provider updateProvider(Provider provider) {

        return providerRepository.save(provider);
    }

    @Override
    public void deleteProvider(Long id) {

        providerRepository.deleteById(id);
    }
}
