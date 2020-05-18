package projet.data;

import java.time.LocalDate;
import java.util.Objects;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Equipe  {

	
	
	//candidat lien a l'équipe
	
	// Données observables
	
	private final Property<Integer>		idEquipe			= new SimpleObjectProperty<>();
	private final StringProperty		nom					= new SimpleStringProperty();
	private final Property<Integer>		nbreRepas			= new SimpleObjectProperty<>();
	private final Property<Boolean>		validation			= new SimpleObjectProperty<>( false );
	private final Property<LocalDate>	dateInscriptionE	= new SimpleObjectProperty<>();
	private final Property<Integer>		idCompte			= new SimpleObjectProperty<>();
	private final Property<Integer>		idCourse			= new SimpleObjectProperty<>();
	private final Property<Integer>		idCategorie1		= new SimpleObjectProperty<>();
	private final Property<Integer>		idCandidatCap		= new SimpleObjectProperty<>();
	private final Property<Integer>		idCandidatEq		= new SimpleObjectProperty<>();
	
	
	//Getters & setters
	public final Property<Integer> idEquipeProperty() {
		return this.idEquipe;
	}
	

	public final Integer getIdEquipe() {
		return this.idEquipeProperty().getValue();
	}
	

	public final void setIdEquipe(final Integer idEquipe) {
		this.idEquipeProperty().setValue(idEquipe);
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
	

	public final Property<Integer> nbreRepasProperty() {
		return this.nbreRepas;
	}
	

	public final Integer getNbreRepas() {
		return this.nbreRepasProperty().getValue();
	}
	

	public final void setNbreRepas(final Integer nbreRepas) {
		this.nbreRepasProperty().setValue(nbreRepas);
	}
	

	public final Property<Boolean> validationProperty() {
		return this.validation;
	}
	

	public final Boolean getValidation() {
		return this.validationProperty().getValue();
	}
	

	public final void setValidation(final Boolean validation) {
		this.validationProperty().setValue(validation);
	}
	

	public final Property<LocalDate> dateInscriptionEProperty() {
		return this.dateInscriptionE;
	}
	

	public final LocalDate getDateInscriptionE() {
		return this.dateInscriptionEProperty().getValue();
	}
	

	public final void setDateInscriptionE(final LocalDate dateInscriptionE) {
		this.dateInscriptionEProperty().setValue(dateInscriptionE);
	}
	

	public final Property<Integer> idCompteProperty() {
		return this.idCompte;
	}
	

	public final Integer getIdCompte() {
		return this.idCompteProperty().getValue();
	}
	

	public final void setIdCompte(final Integer idCompte) {
		this.idCompteProperty().setValue(idCompte);
	}
	

	public final Property<Integer> idCourseProperty() {
		return this.idCourse;
	}
	

	public final Integer getIdCourse() {
		return this.idCourseProperty().getValue();
	}
	

	public final void setIdCourse(final Integer idCourse) {
		this.idCourseProperty().setValue(idCourse);
	}
	

	public final Property<Integer> idCategorie1Property() {
		return this.idCategorie1;
	}
	

	public final Integer getIdCategorie1() {
		return this.idCategorie1Property().getValue();
	}
	

	public final void setIdCategorie1(final Integer idCategorie1) {
		this.idCategorie1Property().setValue(idCategorie1);
	}
	

	public final Property<Integer> idCandidatCapProperty() {
		return this.idCandidatCap;
	}
	

	public final Integer getIdCandidatCap() {
		return this.idCandidatCapProperty().getValue();
	}
	

	public final void setIdCandidatCap(final Integer idCandidatCap) {
		this.idCandidatCapProperty().setValue(idCandidatCap);
	}
	

	public final Property<Integer> idCandidatEqProperty() {
		return this.idCandidatEq;
	}
	

	public final Integer getIdCandidatEq() {
		return this.idCandidatEqProperty().getValue();
	}
	

	public final void setIdCandidatEq(final Integer idCandidatEq) {
		this.idCandidatEqProperty().setValue(idCandidatEq);
	}
	
	
	// hashCode() & equals()

	@Override
	public int hashCode() {
		return Objects.hash(idEquipe.getValue() );
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipe other = (Equipe) obj;
		return Objects.equals(idEquipe.getValue(), other.idEquipe.getValue() );
	}

	
	

	
	
	
}

