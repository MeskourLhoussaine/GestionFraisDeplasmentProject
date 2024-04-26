package ma.project.gestionfraisdeplacement.entites;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	 @Column(nullable = false, length = 15)
	private String Ref ;
	 @Column(nullable = false, length = 15)
	private  Double  MontTotal;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Demmande demmande;

	public Demmande getDemmande() {
		return demmande;
	}

	public void setDemmande(Demmande demmande) {
		this.demmande = demmande;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRef() {
		return Ref;
	}

	public void setRef(String ref) {
		Ref = ref;
	}

	public Double getMontTotal() {
		return MontTotal;
	}

	public void setMontTotal(Double montTotal) {
		MontTotal = montTotal;
	}


}
