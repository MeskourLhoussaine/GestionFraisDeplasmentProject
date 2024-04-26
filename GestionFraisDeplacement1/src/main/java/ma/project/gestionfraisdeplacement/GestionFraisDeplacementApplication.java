package ma.project.gestionfraisdeplacement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@EntityScan("ma/project/gestionfraisdeplacement/entites")
//@ComponentScan("ma.project.gestionfraisdeplacement.controller")
//@ComponentScan("ma.project.gestionfraisdeplacement.repository")
public class GestionFraisDeplacementApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionFraisDeplacementApplication.class, args);
	}

}
