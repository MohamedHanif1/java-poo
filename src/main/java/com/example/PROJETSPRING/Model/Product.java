package com.example.PROJETSPRING.Model;
import com.example.PROJETSPRING.Commands.ProductCommand;
import com.example.PROJETSPRING.Commands.ProviderCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.security.access.method.P;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;
    @ManyToMany(mappedBy = "products")
    private Set<Command> commands = new HashSet<>();
    @ManyToMany(mappedBy = "products")
    private Set<Provider> providers = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;


    public static Product create (ProductCommand productCommand) {
        Product product = new Product();
        product.name = productCommand.getName();
        product.description = productCommand.getDescription();
        product.price = productCommand.getPrice();
        return product;
    }

    public void update (ProductCommand productCommand) {
        this.name = productCommand.getName();
        this.description = productCommand.getDescription();
        this.price = productCommand.getPrice();
    }
}
