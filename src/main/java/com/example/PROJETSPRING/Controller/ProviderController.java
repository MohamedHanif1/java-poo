package com.example.PROJETSPRING.Controller;

import com.example.PROJETSPRING.Commands.ProviderCommand;
import com.example.PROJETSPRING.Constant.ApiPaths;
import com.example.PROJETSPRING.DTO.ProviderDTO;
import com.example.PROJETSPRING.Mapper.ProviderMapper;
import com.example.PROJETSPRING.Model.Provider;
import com.example.PROJETSPRING.Services.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiPaths.V1 + ApiPaths.PROVIDERS)
public class ProviderController {

    private final ProviderService providerService;
    private final ProviderMapper providerMapper;


    @GetMapping
    public ResponseEntity<Page<ProviderDTO>> getAllProviders(Pageable pageable) {

        return ResponseEntity.ok(providerService.getAllProviders(pageable).map(providerMapper ::convertToDTO));
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
    public ResponseEntity<ProviderDTO> createProvider(@RequestBody ProviderCommand providerCommand) {
        return ResponseEntity.ok(providerMapper.convertToDTO(providerService.createProvider(providerCommand)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProviderDTO> updateProvider
            (@PathVariable Long id, @Valid @RequestBody ProviderCommand providerCommand) {
        return ResponseEntity.ok(providerMapper.convertToDTO(providerService.updateProvider(id , providerCommand)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvider(@PathVariable Long id) {
        providerService.deleteProvider(id);
        return ResponseEntity.ok().build();
    }
}