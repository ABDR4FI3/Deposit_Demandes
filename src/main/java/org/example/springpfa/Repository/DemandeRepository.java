package org.example.springpfa.Repository;

import org.example.springpfa.entities.Demande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeRepository extends JpaRepository<Demande,Long> {
    public Demande findByIdDemande(long id);
}
