package com.example.PROJETSPRING.Model;
import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import com.example.PROJETSPRING.Commands.ClientCommand;
import com.example.PROJETSPRING.Commands.ProviderCommand;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "products")
@ToString(exclude = "products")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String adress;

    private String mail;

    private String phonenumber;
    public String Password;
    @ManyToMany
    @JoinTable(
            name = "provider_product",
            joinColumns = @JoinColumn(name = "provider_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    public static Provider create (ProviderCommand providerCommand) {
        Provider provider = new Provider();
        provider.name = providerCommand.getName();
        provider.adress = providerCommand.getAdress();
        provider.mail = providerCommand.getMail();
        provider.phonenumber = providerCommand.getPhonenumber();
        provider.Password = providerCommand.getPassword();
        provider.stock = providerCommand.getStock();
        return provider;
    }

    public void update (ProviderCommand providerCommand) {
        this.name = providerCommand.getName();
        this.adress = providerCommand.getAdress();
        this.mail = providerCommand.getMail();
        this.phonenumber = providerCommand.getPhonenumber();
        this.Password = providerCommand.getPassword();
        this.stock = providerCommand.getStock();
    }
}
