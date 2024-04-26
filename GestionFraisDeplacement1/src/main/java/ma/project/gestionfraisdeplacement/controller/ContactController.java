package ma.project.gestionfraisdeplacement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.project.gestionfraisdeplacement.entites.Contact;
import ma.project.gestionfraisdeplacement.services.ContactServices;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/contact")
public class ContactController {
@Autowired
    private ContactServices contactServices;

    @GetMapping("/all")
    public List<Contact> findAll() {
        return contactServices.findAll();
    }

    @PostMapping("/save")
    public int save(@RequestBody Contact c) {
        return contactServices.save(c);
    }

    @GetMapping("/{id}")
    public Optional<Contact> findById(@PathVariable("id")Long id) {
        return contactServices.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        contactServices.deleteById(id);
    }

    @PutMapping("id/{id}")
    public Contact update(@PathVariable Long id, @RequestBody Contact contact) {
        return contactServices.updateContact(id, contact);
    }
}

