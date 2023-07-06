package com.example.PROJETSPRING.Controller;
import com.example.PROJETSPRING.Model.Commande;
import com.example.PROJETSPRING.Services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    private final CommandeService commandeService;

    @Autowired
    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping
    public ResponseEntity<List<Commande>> getCommandes() {
        List<Commande> commandes = commandeService.getCommandes();
        return new ResponseEntity<>(commandes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable Long id) {
        Commande commande = commandeService.getCommandeById(id)
                .orElseThrow(() -> new RuntimeException("Commande not found"));
        return new ResponseEntity<>(commande, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Commande> addCommande(@RequestBody Commande commande) {
        Commande newCommande = commandeService.addCommande(commande);
        return new ResponseEntity<>(newCommande, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commande> updateCommande(@PathVariable Long id, @RequestBody Commande commande) {
        Commande updatedCommande = commandeService.updateCommande(commande);
        return new ResponseEntity<>(updatedCommande, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCommande(@PathVariable Long id) {
        commandeService.deleteCommande(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
