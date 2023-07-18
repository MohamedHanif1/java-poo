package com.example.PROJETSPRING.Model;
import com.example.PROJETSPRING.Commands.ClientCommand;
import com.example.PROJETSPRING.Commands.CommandCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "command_product",
            joinColumns = @JoinColumn(name = "command_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    @ElementCollection
    private Map<Product, Integer> produit;

    private String status;

    public static Command create (CommandCommand commandCommand) {
        Command command= new Command();
        command.client = commandCommand.getClient();
        command.produit = commandCommand.getProduit();
        command.stock = commandCommand.getStock();
        command.status = commandCommand.getStatus();
        return command;
    }
    public void update (CommandCommand commandCommand) {
        this.client = commandCommand.getClient();
        this.produit = commandCommand.getProduit();
        this.stock = commandCommand.getStock();
        this.status = commandCommand.getStatus();
    }
}

