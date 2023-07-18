package com.example.PROJETSPRING.Model;
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
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    private Map<Product, Integer> products;
    @OneToMany(mappedBy = "stock")
    private Set<Command> commands = new HashSet<>();
    @OneToMany(mappedBy = "stock")
    private Set<Product> product = new HashSet<>();
    @OneToMany(mappedBy = "stock")
    private Set<Provider> provider = new HashSet<>();
    private String location;





}
