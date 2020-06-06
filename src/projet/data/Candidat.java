package projet.data;

import java.time.LocalDate;
import java.util.Objects;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Candidat {
	
	
	// Champs
	
	private final Property<Integer>		idCandidat			= new SimpleObjectProperty<>();
	private final StringProperty   	 	club      	= new SimpleStringProperty();
	private final StringProperty   		nom			= new SimpleStringProperty();
	private final StringProperty 	prenom		= new SimpleStringProperty();
	private final Property<LocalDate>		dateDeN		= new SimpleObjectProperty<>();
	private final StringProperty		adresse		= new SimpleStringProperty();
	private final Property<Integer>	numtelephone	= new SimpleObjectProperty<>();
	private final StringProperty 	mail	= new SimpleStringProperty();
	//private final ObservableList<Personne> personnes = FXCollections.observableArrayList();

	
	// hashCode() & equals()

	@Override
	public int hashCode() {
		return Objects.hash( idCandidat.getValue() );
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
		return Objects.equals( idCandidat.getValue(), other.idCandidat.getValue() );
	}

	// Getters & setters
	
	
	public final Property<Integer> idCandidatProperty() {
		return this.idCandidat;
	}
	

	public final Integer getIdCandidat() {
		return this.idCandidatProperty().getValue();
	}
	

	public final void setIdCandidat(final Integer idCandidat) {
		this.idCandidatProperty().setValue(idCandidat);
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

	public final Property<LocalDate> dateDeNProperty() {
		return this.dateDeN;
	}
	

	public final LocalDate getDateDeN() {
		return this.dateDeNProperty().getValue();
	}
	

	public final void setDateDeN(final LocalDate dateDeN) {
		this.dateDeNProperty().setValue(dateDeN);
	}

	public final StringProperty adresseProperty() {
		return this.adresse;
	}
	

	public final String getAdresse() {
		return this.adresseProperty().get();
	}
	

	public final void setAdresse(final String adresse) {
		this.adresseProperty().set(adresse);
	}
	
	
	
	public final String getNomComplet() {
		String nomC = this.nomProperty().get() + " " + this.prenomProperty().get();
		return nomC;
	}
		
	

}
