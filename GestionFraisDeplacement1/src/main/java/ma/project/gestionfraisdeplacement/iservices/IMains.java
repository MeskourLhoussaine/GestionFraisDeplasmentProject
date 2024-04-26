package ma.project.gestionfraisdeplacement.iservices;

import ma.project.gestionfraisdeplacement.entites.Demmande;
import ma.project.gestionfraisdeplacement.entites.Facture;

public interface IMains {
    public Demmande findDemmandeByType(String type);
    public Facture findFactureByRef(String ref);
    public Demmande findMsjByCodsuive(String codeSuivi );

}
