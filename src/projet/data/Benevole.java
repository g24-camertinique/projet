package projet.data;

import java.time.LocalDate;
import java.util.Objects;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Benevole {
	
	
	// Champs
	
	private final Property<Integer>		idBenevole			= new SimpleObjectProperty<>();
	private final StringProperty   	 	nom       			= new SimpleStringProperty();
	private final StringProperty   		prenom 				= new SimpleStringProperty();
	private final Property<LocalDate>	dateDeN				= new SimpleObjectProperty<>();
	private final StringProperty   		adresse 			= new SimpleStringProperty();
	private final Property<Integer>		numTelephone		= new SimpleObjectProperty<>();
	private final StringProperty   		mail 				= new SimpleStringProperty();
	private final Property<Boolean>		interne				= new SimpleObjectProperty<>( false );
	private final StringProperty   		disponibilite		= new SimpleStringProperty();
	private final Property<Boolean>		validation			= new SimpleObjectProperty<>( false );
	private final Property<LocalDate>	dateInscriptionB	= new SimpleObjectProperty<>();
	private final Property<Integer>		idCompte			= new SimpleObjectProperty<>();

	
	
	// Getters & setters
	
		//idBenevole
	public final Property<Integer> idBenevoleProperty() {
		return this.idBenevole;
	}
	
	public final Integer getIdBenevole() {
		return this.idBenevoleProperty().getValue();
	}
	
	public final void setIdBenevole(final Integer idBenevole) {
		this.idBenevoleProperty().setValue(idBenevole);
	}
	
		//nom
	public final StringProperty nomProperty() {
		return this.nom;
	}
	
	public final String getNom() {
		return this.nomProperty().get();
	}

	public final void setNom(final String nom) {
		this.nomProperty().set(nom);
	}
	
		//prenom
	public final StringProperty prenomProperty() {
		return this.prenom;
	}
	
	public final String getPrenom() {
		return this.prenomProperty().get();
	}
	
	public final void setPrenom(final String prenom) {
		this.prenomProperty().set(prenom);
	}
	
		//dateDeN
	public final Property<LocalDate> dateDeNProperty() {
		return this.dateDeN;
	}
	
	public final LocalDate getDateDeN() {
		return this.dateDeNProperty().getValue();
	}
	
	public final void setDateDeN(final LocalDate dateDeN) {
		this.dateDeNProperty().setValue(dateDeN);
	}
	
		//adresse
	public final StringProperty adresseProperty() {
		return this.adresse;
	}
	
	public final String getAdresse() {
		return this.adresseProperty().get();
	}
	
	public final void setAdresse(final String adresse) {
		this.adresseProperty().set(adresse);
	}
	
		//numTelephone
	public final Property<Integer> numTelephoneProperty() {
		return this.numTelephone;
	}
	
	public final Integer getNumTelephone() {
		return this.numTelephoneProperty().getValue();
	}
	
	public final void setNumTelephone(final Integer numTelephone) {
		this.numTelephoneProperty().setValue(numTelephone);
	}
	
		//mail
	public final StringProperty mailProperty() {
		return this.mail;
	}
	
	public final String getMail() {
		return this.mailProperty().get();
	}
	
	public final void setMail(final String mail) {
		this.mailProperty().set(mail);
	}
	
		//interne
	public final Property<Boolean> interneProperty() {
		return this.interne;
	}
	
	public final Boolean getInterne() {
		return this.interneProperty().getValue();
	}
	
	public final void setInterne(final Boolean interne) {
		this.interneProperty().setValue(interne);
	}
	
		//disponibilite
	public final StringProperty disponibiliteProperty() {
		return this.disponibilite;
	}
	
	public final String getDisponibilite() {
		return this.disponibiliteProperty().get();
	}
	
	public final void setDisponibilite(final String disponibilite) {
		this.disponibiliteProperty().set(disponibilite);
	}
	
		//validation
	public final Property<Boolean> validationProperty() {
		return this.validation;
	}

	public final Boolean getValidation() {
		return this.validationProperty().getValue();
	}
	
	public final void setValidation(final Boolean validation) {
		this.validationProperty().setValue(validation);
	}
	
		//dateInscriptionB
	public final Property<LocalDate> dateInscriptionBProperty() {
		return this.dateInscriptionB;
	}
	
	public final LocalDate getDateInscriptionB() {
		return this.dateInscriptionBProperty().getValue();
	}
	
	public final void setDateInscriptionB(final LocalDate dateInscriptionB) {
		this.dateInscriptionBProperty().setValue(dateInscriptionB);
	}
	
		//idCompte
	public final Property<Integer> idCompteProperty() {
		return this.idCompte;
	}
	
	public final Integer getIdCompte() {
		return this.idCompteProperty().getValue();
	}
	
	public final void setIdCompte(final Integer idCompte) {
		this.idCompteProperty().setValue(idCompte);
	}
	
	
	// hashCode() & equals()

		@Override
		public int hashCode() {
			return Objects.hash( idBenevole.getValue() );
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Benevole other = (Benevole) obj;
			return Objects.equals( idBenevole.getValue(), other.idBenevole.getValue() );
		}

		
		public final String getNomComplet() {
			String nomC = this.nomProperty().get() + " " + this.prenomProperty().get();
			return nomC;
		}

}
