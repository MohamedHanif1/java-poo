package com.example.PROJETSPRING.Model;
import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

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
}
