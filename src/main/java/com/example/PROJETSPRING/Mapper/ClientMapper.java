package com.example.PROJETSPRING.Mapper;

import com.example.PROJETSPRING.DTO.ClientDTO;
import com.example.PROJETSPRING.Model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientDTO convertToDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setAdress(client.getAdress());
        clientDTO.setMail(client.getMail());
        clientDTO.setPhonenumber(client.getPhonenumber());
        return clientDTO;
    }

    public Client convertToEntity(ClientDTO clientDTO) {
        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setName(clientDTO.getName());
        client.setAdress(clientDTO.getAdress());
        client.setMail(clientDTO.getMail());
        client.setPhonenumber(clientDTO.getPhonenumber());
        return client;
    }
}