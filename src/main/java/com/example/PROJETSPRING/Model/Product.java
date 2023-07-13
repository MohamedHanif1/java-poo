package com.example.PROJETSPRING.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

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
}
