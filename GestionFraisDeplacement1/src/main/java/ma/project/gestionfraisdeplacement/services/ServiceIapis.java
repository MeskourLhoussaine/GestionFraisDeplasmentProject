package ma.project.gestionfraisdeplacement.services;


import ma.project.gestionfraisdeplacement.entites.Demmande;
import ma.project.gestionfraisdeplacement.entites.Facture;
import ma.project.gestionfraisdeplacement.iservices.IMains;
import ma.project.gestionfraisdeplacement.repository.DemmandeRepository;
import ma.project.gestionfraisdeplacement.repository.FactureRepository;

public class ServiceIapis implements IMains {
    private DemmandeRepository demmandeRepository;
    private FactureRepository factureRepository;
    @Override
    public Demmande findDemmandeByType(String type) {
        return demmandeRepository.findAll().stream().filter(demmande -> demmande.getType().equals(type))
                .findFirst().orElse(null);
    }

    @Override
    public Facture findFactureByRef(String ref) {
        return factureRepository.findAll().stream().filter(facture -> facture.getRef().equals(ref))
                .findFirst().orElse(null);
    }

    @Override
    public Demmande findMsjByCodsuive(String codeSuivi) {
        return demmandeRepository.findAll().stream().filter(demmande -> demmande.getCodeSuivi().equals(codeSuivi))
                .findFirst().orElse(null);
    }



}
