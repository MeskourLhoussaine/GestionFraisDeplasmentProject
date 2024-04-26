package ma.project.gestionfraisdeplacement.services;


import ma.project.gestionfraisdeplacement.entites.Demmande;
import ma.project.gestionfraisdeplacement.iservices.IMetier;
import ma.project.gestionfraisdeplacement.repository.DemmandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class DemmandeServices implements IMetier<Demmande> {
	@Autowired
	private DemmandeRepository demmandeRepository;

	@Override
	public Demmande save(Demmande o) {
		// TODO Auto-generated method stub
		return demmandeRepository.save(o);
	}



	@Override
	public Demmande update(Demmande o) {
		// TODO Auto-generated method stub
		return demmandeRepository.save(o);
	}


	public Demmande findById(int id) {
		return demmandeRepository.findById(id);
	}

	@Override
	public void delete(Demmande o) {
		demmandeRepository.delete(o);
		
	}

	@Override
	public List<Demmande> findAll() {
		// TODO Auto-generated method stub
		return demmandeRepository.findAll();
	}



	@Override
	public void deleteById(Long id) {
		
		demmandeRepository.deleteById(id);
	}
	public void updateDemandeState(Long id, String nouvelEtat, String nouvelMsj) {
		Demmande demande = demmandeRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Demande non trouvée avec l'ID : " + id));

		// Mettre à jour l'état de la demande
		demande.setEtat(nouvelEtat);
		demande.setMsj(nouvelMsj);

		// Mettre à jour le message de la demande


		// Enregistrer la demande mise à jour dans la base de données
		demmandeRepository.save(demande);
	}


	

}
