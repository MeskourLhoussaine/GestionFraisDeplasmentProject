package ma.project.gestionfraisdeplacement.services;

import ma.project.gestionfraisdeplacement.entites.Demmande;
import ma.project.gestionfraisdeplacement.entites.Facture;
import ma.project.gestionfraisdeplacement.iservices.IMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.project.gestionfraisdeplacement.repository.FactureRepository;

import java.util.List;
import java.util.Optional;
@Service
public class FactureServices implements IMetier<Facture >{
	@Autowired
	private FactureRepository factureRepository;



	@Override
	public Facture save(Facture o) {
		// TODO Auto-generated method stub
		return factureRepository.save(o);
	}



	@Override
	public Facture update(Facture o) {
		// TODO Auto-generated method stub
		return factureRepository.save(o);
	}

	@Override
	public void delete(Facture o) {
		factureRepository.delete(o);
		
	}

	@Override
	public List<Facture> findAll() {
		// TODO Auto-generated method stub
		return factureRepository.findAll();
	}

	public Optional<Facture> findById(Long id) {
		return factureRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		factureRepository.deleteById(id);
		
	}
}
