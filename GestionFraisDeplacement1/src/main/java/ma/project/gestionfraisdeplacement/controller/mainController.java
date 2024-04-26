package ma.project.gestionfraisdeplacement.controller;

//import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import ma.project.gestionfraisdeplacement.entites.Demmande;
import ma.project.gestionfraisdeplacement.entites.Facture;
import ma.project.gestionfraisdeplacement.services.DemmandeServices;
import ma.project.gestionfraisdeplacement.services.FactureServices;
import ma.project.gestionfraisdeplacement.services.ServiceIapis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping( "/api/mains")
@AllArgsConstructor
//@Tag(name="Apis")
public class mainController {


    private DemmandeServices demmandeServices;
    private FactureServices factureServices;



    @GetMapping("/findDemmandeByType")
    public Demmande findDemmandeByType(@RequestParam String type) {
        return demmandeServices.findAll().stream().filter(demmande -> demmande.getType().equals(type))
                .findFirst().orElse(null);
    }

    @GetMapping("/findFactureByRef")
    public Facture findFactureByRef(@RequestParam String ref) {
        return factureServices.findAll().stream().filter(facture -> facture.getRef().equals(ref))
                .findFirst().orElse(null);
    }

    @PutMapping("/{id}/etat")
    public void StatDemand(@PathVariable Long id, @RequestParam String nouvelEtat,@RequestParam String nouvelMsj) {
        demmandeServices.updateDemandeState(id, nouvelEtat,nouvelMsj);
    }
/*µµ
    @PutMapping("/{id}/msj")
    public void updateDemandMsj(@PathVariable Long id, @RequestParam String nouvelMsj) {
        demmandeServices.updateDemandeMsj(id, nouvelMsj);
    }*/
    @GetMapping("/finddemandeBycodesuiv")
    public Demmande findMsjByCodsuive(@RequestParam String codeSuivi) {
        return demmandeServices.findAll().stream().filter(demmande -> demmande.getCodeSuivi().equals(codeSuivi))
                .findFirst().orElse(null);
    }
}
