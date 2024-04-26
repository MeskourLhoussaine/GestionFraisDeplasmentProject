package ma.project.gestionfraisdeplacement.controller;

import ma.project.gestionfraisdeplacement.entites.EmailDetails;
import ma.project.gestionfraisdeplacement.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody EmailDetails details) {
        emailService.sendSimpleMessage(details.getEmail(), "Follow-up Code", "Your follow-up code is: " + details.getFollowUpCode());
        return "Email sent successfully";
    }
}

