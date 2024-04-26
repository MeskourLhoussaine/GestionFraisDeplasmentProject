package ma.project.gestionfraisdeplacement.iservices;

import java.util.List;

public interface IMetier <T>{
	
	  T save(T o);

	    T update(T o);

	    void delete(T o);

	    List<T> findAll();

	    void deleteById(Long id);


}
