package com.example.PROJETSPRING.Services;

import com.example.PROJETSPRING.Commands.ClientCommand;
import com.example.PROJETSPRING.Exception.ErrorFactory;
import com.example.PROJETSPRING.Exception.IdException;
import com.example.PROJETSPRING.Model.Client;
import com.example.PROJETSPRING.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public Page<Client> getAllClients(Pageable pageable) {

        return clientRepository.findAll(pageable);
    }

    @Override
    public Client getClientById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElse(null);
    }

    @Override
    public Client createClient(ClientCommand clientCommand) {
        String hashedPassword = passwordEncoder.encode(clientCommand.getPassword());
        Client client = Client.create(clientCommand);
        client.setPassword(hashedPassword);
        return clientRepository.save(client);
    }


    public Client updateClient(Long id, ClientCommand clientCommand) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new IdException(ErrorFactory.USER_NOT_FOUND.getExceptionPayload()));
        client.update(clientCommand);
        return clientRepository.save(client);
}
        public void deleteClient (Long id ){
           Client client = clientRepository.findById(id)
                   .orElseThrow(() -> new IdException(ErrorFactory.USER_NOT_FOUND.getExceptionPayload()));
           clientRepository.deleteById(id);
    }
}