package ma.project.gestionfraisdeplacement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.project.gestionfraisdeplacement.entites.Contact;
import ma.project.gestionfraisdeplacement.repository.ContactRepository;

@Service
public class ContactServices {
   @Autowired
   private ContactRepository contactRepository;       
   public List<Contact> findAll() {
       return contactRepository.findAll();
   }

   public int save(Contact contact) {
       if (contact != null) {
    	   contactRepository.save(contact);
           return 1;
       } else return -1;
   }

   public Contact updateContact(Long id, Contact contact) {
       Contact c = findById(id).get();
       c.setEmail(contact.getEmail());
       c.setMessage(contact.getMessage());
       contactRepository.save(c);
       return c;
   }
   public Optional<Contact> findById(Long id) {
       return contactRepository.findById(id);
   }

   public void deleteById(Long id) {
	   contactRepository.deleteById(id);
   }

   public void deleteAll() {
	   contactRepository.deleteAll();
   }

}