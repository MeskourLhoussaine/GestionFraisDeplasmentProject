package ma.project.gestionfraisdeplacement.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Demmande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 @Column(nullable = false, length =130)
	 private String nom;
	@Column(nullable = false, length = 110)
	 private String cin;
	@Column(nullable = false, length = 200)
	private String email ;
	@Column(nullable = false, length = 115)
	private String type ;
	@Column( length = 600)
	private String etat;
	@Column(nullable = false, length = 15)
	private  Double  Montant;
	@Column(nullable = false, length = 3350)
	private String msj;
	private String codeSuivi;

	// Getter et Setter pour codeSuivi
	public String getCodeSuivi() {
		return codeSuivi;
	}

	public void setCodeSuivi(String codeSuivi) {
		this.codeSuivi = codeSuivi;
	}
	@JsonIgnore
	@OneToMany(mappedBy = "demmande",fetch = FetchType.LAZY)
	private List<Facture> factures;
	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	@Temporal(TemporalType.TIMESTAMP)
	    @Column(updatable = false)
	private  Date date ;

	@Column(length = 1999999999)
	@Lob
	private byte[] imageBon;

	@Column(nullable = false, length = 60)
	private String description;

	public byte[] getImageBon() {
		return imageBon;
	}

	public void setImageBon(byte[] imageBon) {
		this.imageBon = imageBon;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}

	public Double getMontant() {
		return Montant;
	}

	public void setMontant(Double montant) {
		Montant = montant;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Facture> getFactures() {
		return factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		if (nom != null && nom.length() > 30) {
			// Truncate the string to the first 30 characters
			this.nom = nom.substring(0, 30);
		} else {
			this.nom = nom;
		}
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}
}
