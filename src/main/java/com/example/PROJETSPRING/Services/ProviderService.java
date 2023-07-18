package com.example.PROJETSPRING.Services;


import com.example.PROJETSPRING.Commands.ProviderCommand;
import com.example.PROJETSPRING.DTO.ProviderDTO;
import com.example.PROJETSPRING.Model.Provider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProviderService {
    Page<Provider> getAllProviders(Pageable pageable);
    Provider getProviderById(Long id);
    Provider createProvider(ProviderCommand providerCommand);
    Provider updateProvider(Long id , ProviderCommand providerCommand);
    void deleteProvider(Long id);

}
