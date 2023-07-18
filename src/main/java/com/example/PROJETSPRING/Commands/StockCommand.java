package com.example.PROJETSPRING.Commands;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
@Getter
@Setter
@RequiredArgsConstructor
public class StockCommand {
    @NotEmpty
    private final String location;
}
