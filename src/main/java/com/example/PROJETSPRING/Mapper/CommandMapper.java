package com.example.PROJETSPRING.Mapper;

import com.example.PROJETSPRING.DTO.CommandDTO;
import com.example.PROJETSPRING.Model.Command;
import org.springframework.stereotype.Component;

@Component
public class CommandMapper {

    public CommandDTO convertToDTO(Command command) {
        CommandDTO commandDTO = new CommandDTO();
        commandDTO.setId(command.getId());
        commandDTO.setStatus(command.getStatus());
        // ... copy other fields from command to commandDTO
        return commandDTO;
    }

    public Command convertToEntity(CommandDTO commandDTO) {
        Command command = new Command();
        command.setId(commandDTO.getId());
        command.setStatus(commandDTO.getStatus());
        // ... copy other fields from commandDTO to command
        return command;
    }
}
