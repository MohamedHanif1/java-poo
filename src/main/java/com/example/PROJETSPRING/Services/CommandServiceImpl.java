package com.example.PROJETSPRING.Services;
import com.example.PROJETSPRING.Commands.CommandCommand;
import com.example.PROJETSPRING.Exception.ErrorFactory;
import com.example.PROJETSPRING.Exception.IdException;
import com.example.PROJETSPRING.Model.Command;
import com.example.PROJETSPRING.Repository.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Command> getCommandes(Pageable pageable) {

        return commandRepository.findAll(pageable);
    }

    @Override
    public Command getCommandeById(Long id) {
        Optional<Command> command = commandRepository.findById(id);
        return command.orElse(null);
    }


    public Command addCommande(CommandCommand commandCommand) {
        Command command = Command.create(commandCommand);
        return command;
    }


    public Command updateCommande(Long id ,CommandCommand commandCommand) {
        Command command = commandRepository.findById(id)
                .orElseThrow(() -> new IdException(ErrorFactory.USER_NOT_FOUND.getExceptionPayload()));
        command.update(commandCommand);
        return commandRepository.save(command);
    }

    @Override
    public void deleteCommande(Long id) {
        Command command = commandRepository.findById(id)
                .orElseThrow(() -> new IdException(ErrorFactory.USER_NOT_FOUND.getExceptionPayload()));
        commandRepository.deleteById(id);
    }
}
