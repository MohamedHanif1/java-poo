package com.example.PROJETSPRING.Services;
import com.example.PROJETSPRING.Model.Client;
import java.util.List;

public interface ClientService {
    List<Client> getAllClients();
    Client getClientById(Long id);
    Client createClient(Client client);
    Client updateClient(Client client);
    void deleteClient(Long id);
}
