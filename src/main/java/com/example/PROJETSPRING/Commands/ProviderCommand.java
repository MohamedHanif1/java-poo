package com.example.PROJETSPRING.Commands;

import com.example.PROJETSPRING.Model.Stock;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Getter
@Setter
@RequiredArgsConstructor
public class ProviderCommand {
    @NotNull
    private final String name;
    @NotNull
    private final String adress;
    @NotNull
    @Email
    private final String mail;
    @NotBlank
    private final String phonenumber;
    @NotBlank
    private final Stock stock;

}
