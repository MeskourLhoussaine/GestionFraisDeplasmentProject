package ma.project.gestionfraisdeplacement.repository;

import ma.project.gestionfraisdeplacement.entites.Demmande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemmandeRepository extends JpaRepository<Demmande, Long> {
    public Demmande findById(int id);
}