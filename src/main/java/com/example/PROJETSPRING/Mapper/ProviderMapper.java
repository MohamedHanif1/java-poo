package com.example.PROJETSPRING.Mapper;

import com.example.PROJETSPRING.DTO.ProviderDTO;
import com.example.PROJETSPRING.Model.Provider;
import org.springframework.stereotype.Component;


@Component
public class ProviderMapper {

    public ProviderDTO convertToDTO(Provider provider) {
        ProviderDTO providerDTO = new ProviderDTO();
        providerDTO.setId(provider.getId());
        providerDTO.setName(provider.getName());
        providerDTO.setAdress(provider.getAdress());
        providerDTO.setMail(provider.getMail());
        providerDTO.setPhoneNumber(provider.getPhonenumber());
        return providerDTO;
    }
    public Provider convertToEntity(ProviderDTO providerDTO){
        Provider provider = new Provider();
        provider.setId(providerDTO.getId());
        provider.setName(providerDTO.getName());
        provider.setAdress(providerDTO.getAdress());
        provider.setMail(providerDTO.getMail());
        provider.setPhonenumber(providerDTO.getPhoneNumber());
        return provider;
    }

}
