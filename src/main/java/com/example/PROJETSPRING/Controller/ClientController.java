package com.example.PROJETSPRING.Controller;
import com.example.PROJETSPRING.Commands.ClientCommand;
import com.example.PROJETSPRING.Constant.ApiPaths;
import com.example.PROJETSPRING.DTO.ClientDTO;
import com.example.PROJETSPRING.Mapper.ClientMapper;
import com.example.PROJETSPRING.Model.Client;
import com.example.PROJETSPRING.Services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping(ApiPaths.V1 + ApiPaths.CLIENTS)
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> getAllClients(Pageable pageable) {
        return ResponseEntity.ok((clientService.getAllClients(pageable).map(clientMapper::convertToDTO)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        Client client = clientService.getClientById(id);
        if (client != null) {
            return ResponseEntity.ok(clientMapper.convertToDTO(client));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientCommand clientCommand) {
        return ResponseEntity.ok(clientMapper.convertToDTO(clientService.createClient(clientCommand)));
    }

    @PutMapping
    public ResponseEntity<ClientDTO> updateClient
            (@PathVariable Long id , @Valid @RequestBody ClientCommand clientCommand) {
        return ResponseEntity.ok(clientMapper.convertToDTO(clientService.updateClient(id,clientCommand)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }
}
