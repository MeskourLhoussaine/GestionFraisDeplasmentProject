package ma.project.gestionfraisdeplacement.services;

import ma.project.gestionfraisdeplacement.entites.Facture;
import ma.project.gestionfraisdeplacement.entites.Message;
import ma.project.gestionfraisdeplacement.iservices.IMetier;
import ma.project.gestionfraisdeplacement.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServices implements IMetier<Message> {
    @Autowired
    private MessageRepository messageRepository;


    @Override
    public Message save(Message o) {
        return messageRepository.save(o);
    }

    @Override
    public Message update(Message o) {
        return messageRepository.save(o);
    }

    public Optional<Message> findById(Long aLong) {
        return messageRepository.findById(aLong);
    }

    @Override
    public void delete(Message o) {
        messageRepository.delete(o);
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        messageRepository.deleteById(id);
    }
}
