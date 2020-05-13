package projet.data;

import java.time.LocalDate;
import java.util.Objects;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Candidat {
	
	
	// Champs
	
	private final Property<Integer>		id			= new SimpleObjectProperty<>();
	private final StringProperty   	 	club      	= new SimpleStringProperty();
	private final StringProperty   		nom			= new SimpleStringProperty();
	private final StringProperty 	prenom		= new SimpleStringProperty();
	private final Property<LocalDate>		datedenaissance		= new SimpleObjectProperty<>();
	private final Property<Integer>		adresse		= new SimpleObjectProperty<>();
	private final Property<Integer>	numtelephone	= new SimpleObjectProperty<>();
	private final StringProperty 	mail	= new SimpleStringProperty();
	//private final ObservableList<Personne> personnes = FXCollections.observableArrayList();

	
	// hashCode() & equals()

	@Override
	public int hashCode() {
		return Objects.hash( id.getValue() );
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidat other = (Candidat) obj;
		return Objects.equals( id.getValue(), other.id.getValue() );
	}

	// Getters & setters
	
	public final Property<Integer> idProperty() {
		return this.id;
	}
	

	public final Integer getId() {
		return this.idProperty().getValue();
	}
	

	public final void setId(final Integer id) {
		this.idProperty().setValue(id);
	}
	

	public final StringProperty clubProperty() {
		return this.club;
	}
	

	public final String getClub() {
		return this.clubProperty().get();
	}
	

	public final void setClub(final String club) {
		this.clubProperty().set(club);
	}
	

	public final StringProperty nomProperty() {
		return this.nom;
	}
	

	public final String getNom() {
		return this.nomProperty().get();
	}
	

	public final void setNom(final String nom) {
		this.nomProperty().set(nom);
	}
	

	public final StringProperty prenomProperty() {
		return this.prenom;
	}
	

	public final String getPrenom() {
		return this.prenomProperty().get();
	}
	

	public final void setPrenom(final String prenom) {
		this.prenomProperty().set(prenom);
	}
	

	public final Property<LocalDate> datedenaissanceProperty() {
		return this.datedenaissance;
	}
	

	public final LocalDate getDatedenaissance() {
		return this.datedenaissanceProperty().getValue();
	}
	

	public final void setDatedenaissance(final LocalDate datedenaissance) {
		this.datedenaissanceProperty().setValue(datedenaissance);
	}
	

	public final Property<Integer> adresseProperty() {
		return this.adresse;
	}
	

	public final Integer getAdresse() {
		return this.adresseProperty().getValue();
	}
	

	public final void setAdresse(final Integer adresse) {
		this.adresseProperty().setValue(adresse);
	}
	

	public final Property<Integer> numtelephoneProperty() {
		return this.numtelephone;
	}
	

	public final Integer getNumtelephone() {
		return this.numtelephoneProperty().getValue();
	}
	

	public final void setNumtelephone(final Integer numtelephone) {
		this.numtelephoneProperty().setValue(numtelephone);
	}

	public final StringProperty mailProperty() {
		return this.mail;
	}
	

	public final String getMail() {
		return this.mailProperty().get();
	}
	

	public final void setMail(final String mail) {
		this.mailProperty().set(mail);
	}
	
	

		
	

}
