package com.AppIcar.service;

import com.AppIcar.entity.Fournisseur;
import com.AppIcar.exception.FournisseurNotFoudException;
import com.AppIcar.repo.FournisseurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurService {

    @Autowired
    private FournisseurRepo fournisseurRepo;

    public List<Fournisseur> findAllFournisseur() {
        return fournisseurRepo.findAll();
    }

    public Fournisseur addFournisseur(Fournisseur fournisseur) {
        return fournisseurRepo.save(fournisseur);
    }

    public Fournisseur findFournisseurById(Long id) {
        return fournisseurRepo.findFournisseurById(id)
                .orElseThrow(() -> new FournisseurNotFoudException("Fournisseur by id" + id + "was not found"));
    }

    public Fournisseur updateFournisseu(Fournisseur fournisseur) {
        return fournisseurRepo.save(fournisseur);
    }

    public void deleteFournisseur(Long id) {
        fournisseurRepo.deleteById(id);
    }
}
