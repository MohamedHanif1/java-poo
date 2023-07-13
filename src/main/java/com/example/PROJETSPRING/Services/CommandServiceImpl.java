package com.example.PROJETSPRING.Services;
import com.example.PROJETSPRING.Model.Command;
import com.example.PROJETSPRING.Repository.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandServiceImpl implements CommandService {

    private final CommandRepository commandRepository;

    @Autowired
    public CommandServiceImpl(CommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }

    @Override
    public List<Command> getCommandes() {
        return commandRepository.findAll();
    }

    @Override
    public Optional<Command> getCommandeById(Long id) {
        return commandRepository.findById(id);
    }

    @Override
    public Command addCommande(Command command) {
        return commandRepository.save(command);
    }

    @Override
    public Command updateCommande(Command command) {
        return commandRepository.save(command);
    }

    @Override
    public void deleteCommande(Long id) {
        commandRepository.deleteById(id);
    }
}
