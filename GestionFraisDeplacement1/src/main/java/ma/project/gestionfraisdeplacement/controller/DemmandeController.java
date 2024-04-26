package ma.project.gestionfraisdeplacement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
//import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.multipart.MultipartFile;
import ma.project.gestionfraisdeplacement.entites.Demmande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ma.project.gestionfraisdeplacement.services.DemmandeServices;
import org.springframework.web.multipart.MultipartFile;


import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/demmandes")
//@Tag(name="Demmande")
public class DemmandeController {
	@Autowired
	private DemmandeServices demmandeServices;



	@PostMapping("/save")
	public ResponseEntity<?> save(
			@RequestParam("montant") double montant,
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
			@RequestParam("description") String description,
			@RequestParam("type") String type,
			@RequestParam("etat") String etat,
			@RequestParam("cin") String cin,
			@RequestParam("nom") String nom,
			@RequestParam("email") String email,
			@RequestParam("msj") String msj,
			@RequestParam("imageBon") MultipartFile imageBon) {

		try {
			// Valider les données si nécessaire (par exemple, vérifier si des champs obligatoires sont vides)

			Demmande demmande = new Demmande();
			demmande.setMontant(montant);
			demmande.setDate(date);
			demmande.setDescription(description);
			demmande.setType(type);
			demmande.setEtat(etat);
			demmande.setCin(cin);
			demmande.setNom(nom);
			demmande.setEmail(email);
			demmande.setMsj(msj);
			String codeSuivi = generateRandomCode(6);
			demmande.setCodeSuivi(codeSuivi);

			if (imageBon != null && !imageBon.isEmpty()) {
				demmande.setImageBon(imageBon.getBytes());
			}

			Demmande savedDemande = demmandeServices.save(demmande);

			// Si la sauvegarde est réussie, retourner la demande sauvegardée avec un statut 200
			return new ResponseEntity<>(savedDemande, HttpStatus.OK);
		} catch (Exception e) {
			// Gérer toute exception survenue pendant la sauvegarde
			return new ResponseEntity<>("Erreur lors de la sauvegarde de la demande : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	// Méthode pour générer un code aléatoire de longueur donnée en majuscules
	private String generateRandomCode(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuilder code = new StringBuilder();

		for (int i = 0; i < length; i++) {
			int index = random.nextInt(characters.length());
			code.append(characters.charAt(index));
		}

		return code.toString();
	}


// ...

	@PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> updateDemmande(@PathVariable int id,
											@RequestPart("data") Demmande updatedDemmande) {
		try {
			Demmande existingDemmande = demmandeServices.findById(id);
			if (existingDemmande == null) {
				return new ResponseEntity<>("Demande not found with ID: " + id, HttpStatus.NOT_FOUND);
			}

			// Update all fields
			existingDemmande.setMontant(updatedDemmande.getMontant());
			existingDemmande.setDate(updatedDemmande.getDate());
			existingDemmande.setDescription(updatedDemmande.getDescription());
			existingDemmande.setType(updatedDemmande.getType());
			existingDemmande.setEtat(updatedDemmande.getEtat());
			existingDemmande.setCin(updatedDemmande.getCin());
			existingDemmande.setNom(updatedDemmande.getNom());
			existingDemmande.setEmail(updatedDemmande.getEmail());
			existingDemmande.setMsj(updatedDemmande.getMsj());
			// ... add other fields according to your Demmande entity

			Demmande savedDemmande = demmandeServices.save(existingDemmande);

			return new ResponseEntity<>(savedDemmande, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error updating the Demmande: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/delete")
	public void delete(@RequestBody Demmande o) {
		demmandeServices.delete(o);
	}
	@GetMapping("")
	public List<Demmande> findAll() {
		return demmandeServices.findAll();
	}


	@DeleteMapping("/deletByid/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		demmandeServices.deleteById(id);
	}


}
