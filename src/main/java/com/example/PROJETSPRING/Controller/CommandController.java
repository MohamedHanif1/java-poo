package com.example.PROJETSPRING.Controller;
import com.example.PROJETSPRING.Constant.ApiPaths;
import com.example.PROJETSPRING.DTO.CommandDTO;
import com.example.PROJETSPRING.Mapper.CommandMapper;
import com.example.PROJETSPRING.Model.Command;
import com.example.PROJETSPRING.Services.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController

@RequestMapping(ApiPaths.V1 + ApiPaths.COMMANDS)
public class CommandController {

    private final CommandService commandService;
    private final CommandMapper commandMapper;

    @Autowired
    public CommandController(CommandService commandService, CommandMapper commandMapper) {
        this.commandService = commandService;
        this.commandMapper = commandMapper;
    }

    @GetMapping
    public ResponseEntity<List<CommandDTO>> getCommandes() {
        List<Command> commands = commandService.getCommandes();
        List<CommandDTO> commandDTOs = commands.stream()
                .map(commandMapper::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(commandDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommandDTO> getCommandeById(@PathVariable Long id) {
        Command command = commandService.getCommandeById(id)
                .orElseThrow(() -> new RuntimeException("Commande not found"));
        CommandDTO commandDTO = commandMapper.convertToDTO(command);
        return new ResponseEntity<>(commandDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CommandDTO> addCommande(@RequestBody CommandDTO commandDTO) {
        Command command = commandMapper.convertToEntity(commandDTO);
        Command newCommand = commandService.addCommande(command);
        CommandDTO newCommandDTO = commandMapper.convertToDTO(newCommand);
        return new ResponseEntity<>(newCommandDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommandDTO> updateCommande(@PathVariable Long id, @RequestBody CommandDTO commandDTO) {
        Command command = commandMapper.convertToEntity(commandDTO);
        Command updatedCommand = commandService.updateCommande(command);
        CommandDTO updatedCommandDTO = commandMapper.convertToDTO(updatedCommand);
        return new ResponseEntity<>(updatedCommandDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCommande(@PathVariable Long id) {
        commandService.deleteCommande(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}