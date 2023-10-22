package com.AppIcar.repo;

import com.AppIcar.entity.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FournisseurRepo extends JpaRepository<Fournisseur,Long> {

    Optional<Fournisseur> findFournisseurById(Long aLong);
}
