package com.example.PROJETSPRING.Services;
import com.example.PROJETSPRING.Commands.CommandCommand;
import com.example.PROJETSPRING.Model.Command;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CommandService {
    Page<Command> getCommandes(Pageable pageable);
    Command getCommandeById(Long id);
    Command addCommande(CommandCommand commandCommand);
    Command updateCommande(Long id , CommandCommand commandCommand);
    void deleteCommande(Long id);
}
