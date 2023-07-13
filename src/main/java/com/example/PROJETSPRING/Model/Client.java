package com.example.PROJETSPRING.Model;

import com.example.PROJETSPRING.Commands.ClientCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String adress;

    private String mail;

    private String phonenumber;

    public String Password;

    @OneToMany(mappedBy = "client")
    private Set<Command> commands = new HashSet<>();


    public static Client create (ClientCommand clientCommand) {
        Client client = new Client();
        client.name = clientCommand.getName();
        client.adress = clientCommand.getAdress();
        client.mail = clientCommand.getMail();
        client.phonenumber = clientCommand.getPhonenumber();
        return client;
    }

    public void update (ClientCommand clientCommand) {
        this.name = clientCommand.getName();
        this.adress = clientCommand.getAdress();
        this.mail = clientCommand.getMail();
        this.phonenumber = clientCommand.getPhonenumber();
        this.Password = clientCommand.getPassword();
    }

}
