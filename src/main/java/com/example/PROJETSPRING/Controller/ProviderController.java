package com.example.PROJETSPRING.Controller;

import com.example.PROJETSPRING.Constant.ApiPaths;
import com.example.PROJETSPRING.DTO.ProviderDTO;
import com.example.PROJETSPRING.Mapper.ProviderMapper;
import com.example.PROJETSPRING.Model.Provider;
import com.example.PROJETSPRING.Services.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiPaths.V1 + ApiPaths.PROVIDERS)
public class ProviderController {

    private final ProviderService providerService;
    private final ProviderMapper providerMapper;


    @GetMapping
    public ResponseEntity<List<ProviderDTO>> getAllProviders() {
        List<Provider> providers = providerService.getAllProviders();
        List<ProviderDTO> providerDTOs = providers.stream()
                .map(providerMapper::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(providerDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProviderDTO> getProviderById(@PathVariable Long id) {
        Provider provider = providerService.getProviderById(id);
        if (provider != null) {
            ProviderDTO providerDTO = providerMapper.convertToDTO(provider);
            return ResponseEntity.ok(providerDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ProviderDTO> createProvider(@RequestBody ProviderDTO providerDTO) {
        Provider provider = providerMapper.convertToEntity(providerDTO);
        Provider savedProvider = providerService.createProvider(provider);
        ProviderDTO savedProviderDTO = providerMapper.convertToDTO(savedProvider);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProviderDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProviderDTO> updateProvider(@PathVariable Long id, @RequestBody ProviderDTO providerDTO) {
        Provider provider = providerMapper.convertToEntity(providerDTO);
        provider.setId(id); // assurez-vous de fixer l'ID pour éviter la création d'une nouvelle entité
        Provider updatedProvider = providerService.updateProvider(provider);
        ProviderDTO updatedProviderDTO = providerMapper.convertToDTO(updatedProvider);
        return ResponseEntity.ok(updatedProviderDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvider(@PathVariable Long id) {
        providerService.deleteProvider(id);
        return ResponseEntity.ok().build();
    }
}