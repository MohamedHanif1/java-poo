package com.example.PROJETSPRING.Services;
import com.example.PROJETSPRING.Model.Command;

import java.util.List;
import java.util.Optional;

public interface CommandService {
    List<Command> getCommandes();
    Optional<Command> getCommandeById(Long id);
    Command addCommande(Command command);
    Command updateCommande(Command command);
    void deleteCommande(Long id);
}
