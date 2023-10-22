package com.AppIcar.controller;

import com.AppIcar.entity.Fournisseur;
import com.AppIcar.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FournisseurController {
    @Autowired
    private FournisseurService fournisseurService;

    @GetMapping("/allFournisseur")
    public ResponseEntity<List<Fournisseur>> getAllFournisseur () {
        List<Fournisseur> fournisseurs = fournisseurService.findAllFournisseur();
        return new ResponseEntity<>(fournisseurs, HttpStatus.OK);
    }

    @GetMapping("/findFournisseur/{id}")
    public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable("id") Long id) {
        Fournisseur fournisseur =fournisseurService.findFournisseurById(id);
        return new ResponseEntity<>(fournisseur, HttpStatus.OK);
    }

    @PostMapping("/addFournisseur")
    public ResponseEntity<Fournisseur> addFournisseur(@RequestBody Fournisseur fournisseur) {
        Fournisseur fournisseur1 = fournisseurService.addFournisseur(fournisseur);
        return new ResponseEntity<>(fournisseur1, HttpStatus.CREATED);
    }

    @PutMapping("/updateFournisseur")
    public ResponseEntity<Fournisseur> updateFournisseur(@RequestBody Fournisseur fournisseur) {
        Fournisseur fournisseur1 = fournisseurService.updateFournisseu(fournisseur);
        return new ResponseEntity<>(fournisseur1, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteFournisseur/{id}")
    public ResponseEntity<?> deleteFournisseur(@PathVariable("id") Long id) {
        fournisseurService.deleteFournisseur(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
