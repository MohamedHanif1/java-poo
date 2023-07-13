package com.example.PROJETSPRING.Services;
import com.example.PROJETSPRING.Commands.ClientCommand;
import com.example.PROJETSPRING.Model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientService {
    Page<Client> getAllClients(Pageable pageable);
    Client getClientById(Long id);
    Client createClient(ClientCommand clientCommand);
    Client updateClient(Long id, ClientCommand clientCommand);
    void deleteClient(Long id);
}
