package ma.project.gestionfraisdeplacement.controller;

//import io.swagger.v3.oas.annotations.tags.Tag;
import ma.project.gestionfraisdeplacement.entites.Demmande;
import ma.project.gestionfraisdeplacement.entites.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ma.project.gestionfraisdeplacement.services.FactureServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/api/facture")
//@Tag(name="Facture")
public class FactureController {
	@Autowired
private FactureServices factureServices;

@PostMapping("/save")
public Facture save(@RequestBody  Facture o) {
	return factureServices.save(o);
}

@PutMapping("/update")
public Facture update(@RequestBody Facture o) {
	return factureServices.save(o);
}
@DeleteMapping("/delete")
public void delete(@RequestBody Facture o) {
	factureServices.delete(o);
}
@GetMapping("")
public List<Facture> findAll() {
	return factureServices.findAll();
}
@GetMapping("/findbyId/{id}")
public Optional<Facture> findById(@PathVariable("id") Long id) {
	return factureServices.findById(id);
}
@DeleteMapping("/deletByid/{id}")
public void deleteById(@PathVariable("id")  Long id) {
	factureServices.deleteById(id);
}

}
