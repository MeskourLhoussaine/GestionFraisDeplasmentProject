package ma.project.gestionfraisdeplacement.entites;





import javax.persistence.*;
import java.util.Date;



@Entity
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nom;
	private String message;

	@Column(nullable = false, length = 60)
	private String position;

	@Column(length = 1999999999)
	@Lob
	private byte[] imageBon;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date date;

	// Constructors, getters, and setters

	public Article() {
		// Default constructor
	}

	public Article(String nom, String message, String position, byte[] imageBon, Date date) {
		this.nom = nom;
		this.message = message;
		this.position = position;
		this.imageBon = imageBon;
		this.date = date;
	}

	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public byte[] getImageBon() {
		return imageBon;
	}

	public void setImageBon(byte[] imageBon) {
		this.imageBon = imageBon;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
