package ma.project.gestionfraisdeplacement.controller;


import ma.project.gestionfraisdeplacement.entites.Message;
import ma.project.gestionfraisdeplacement.services.MessageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/messages")
public class MessageController {
    @Autowired
    private MessageServices messageServices;

    @PostMapping("")
    public Message save(@RequestBody Message o) {
        return messageServices.save(o);
    }
  /*
   @PutMapping("/{id}")
	    public Ville update(@PathVariable int id, @RequestBody Ville ville) {
	        Ville existingVille = villeService.findById(id);
	        if (existingVille != null) {
	            existingVille.setNom(ville.getNom());
	            return villeService.update(existingVille);
	        }
	        return null;
	    }
   */

    @PutMapping("/{id}")
    public Message update(@PathVariable int id,@RequestBody Message o) {
        return messageServices.update(o);
    }
}
