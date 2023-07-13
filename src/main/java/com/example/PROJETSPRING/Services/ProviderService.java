package com.example.PROJETSPRING.Services;


import com.example.PROJETSPRING.DTO.ProviderDTO;
import com.example.PROJETSPRING.Model.Provider;
import java.util.List;

public interface ProviderService {
    List<Provider> getAllProviders();
    Provider getProviderById(Long id);
    Provider createProvider(Provider provider);
    Provider updateProvider(Provider provider);
    void deleteProvider(Long id);

}
