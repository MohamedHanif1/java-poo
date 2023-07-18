package com.example.PROJETSPRING.Controller;
import com.example.PROJETSPRING.Commands.CommandCommand;
import com.example.PROJETSPRING.Constant.ApiPaths;
import com.example.PROJETSPRING.DTO.CommandDTO;
import com.example.PROJETSPRING.Mapper.CommandMapper;
import com.example.PROJETSPRING.Model.Command;
import com.example.PROJETSPRING.Services.CommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping(ApiPaths.V1 + ApiPaths.COMMANDS)
public class CommandController {

    private final CommandService commandService;
    private final CommandMapper commandMapper;



    @GetMapping
    public ResponseEntity<Page<CommandDTO>> getCommandes (Pageable pageable) {

        return ResponseEntity.ok(commandService.getCommandes(pageable).map(commandMapper ::convertToDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommandDTO> getCommandeById(@PathVariable Long id) {
        Command command = commandService.getCommandeById(id);
        if (command != null) {
            return ResponseEntity.ok(commandMapper.convertToDTO(command));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CommandDTO> addCommande(@RequestBody CommandCommand commandCommand) {
        return ResponseEntity.ok(commandMapper.convertToDTO(commandService.addCommande(commandCommand)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommandDTO> updateCommande
            (@PathVariable Long id, @Valid @RequestBody CommandCommand commandCommand) {

        return ResponseEntity.ok(commandMapper.convertToDTO(commandService.updateCommande( id , commandCommand)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable Long id) {
        commandService.deleteCommande(id);
        return ResponseEntity.ok().build();
    }
}