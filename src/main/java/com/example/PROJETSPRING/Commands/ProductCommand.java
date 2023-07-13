package com.example.PROJETSPRING.Commands;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductCommand {
    @NotBlank
    private final String name;
    @NotNull
    private final String description;
    @NotNull
    private final BigDecimal price;

}
