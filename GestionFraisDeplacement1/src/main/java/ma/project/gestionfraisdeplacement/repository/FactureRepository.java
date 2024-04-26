package ma.project.gestionfraisdeplacement.repository;


import ma.project.gestionfraisdeplacement.entites.Demmande;
import ma.project.gestionfraisdeplacement.entites.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture, Long> {

}



