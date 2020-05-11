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
	
	private final Property<Integer>		id					= new SimpleObjectProperty<>();
	private final StringProperty		nomE					= new SimpleStringProperty();
	private final Property<Integer>		nmbreRepas			= new SimpleObjectProperty<>();
	private final Property<Boolean>		validation			= new SimpleObjectProperty<>( false );
	private final Property<LocalDate>	dateInscriptionE	= new SimpleObjectProperty<>();
	private final Property<Integer>		id_Categorie		= new SimpleObjectProperty<>();
	private final Property<Integer>		id_Course			= new SimpleObjectProperty<>();
	
	
	
	
	
	// Constructeurs
	
	public Equipe() {
	}

	public Equipe( final int id,final String nom,final int nmbreRepas,final boolean validation,final LocalDate dateInscriptionE,final int id_Categorie,final int id_Course   ) {
		setId(id);
		setNom(nom);
		setNmbreRepas(nmbreRepas);
		setValidation(validation);
		setDateInscriptionE(dateInscriptionE);
		setId_Categorie(id_Categorie);
		setId_Course(id_Course);
	}
	
	
	// Getters et Setters
	public final Property<Integer> idProperty() {
		return this.id;
	}
	

	public final Integer getId() {
		return this.idProperty().getValue();
	}
	

	public final void setId(final Integer id) {
		this.idProperty().setValue(id);
	}
	

	public final StringProperty nomProperty() {
		return this.nomE;
	}
	

	public final String getNom() {
		return this.nomProperty().get();
	}
	

	public final void setNom(final String nom) {
		this.nomProperty().set(nom);
	}
	

	public final Property<Integer> nmbreRepasProperty() {
		return this.nmbreRepas;
	}
	

	public final Integer getNmbreRepas() {
		return this.nmbreRepasProperty().getValue();
	}
	

	public final void setNmbreRepas(final Integer nmbreRepas) {
		this.nmbreRepasProperty().setValue(nmbreRepas);
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
	

	public final Property<Integer> id_CategorieProperty() {
		return this.id_Categorie;
	}
	

	public final Integer getId_Categorie() {
		return this.id_CategorieProperty().getValue();
	}
	

	public final void setId_Categorie(final Integer id_Categorie) {
		this.id_CategorieProperty().setValue(id_Categorie);
	}
	

	public final Property<Integer> id_CourseProperty() {
		return this.id_Course;
	}
	

	public final Integer getId_Course() {
		return this.id_CourseProperty().getValue();
	}
	

	public final void setId_Course(final Integer id_Course) {
		this.id_CourseProperty().setValue(id_Course);
	}

	
	// toString()
	
	@Override
	public String toString() {
		return getNom();
	}
	
	
	// hashCode() & equals()

	@Override
	public int hashCode() {
		return Objects.hash(id.getValue() );
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
		return Objects.equals(id.getValue(), other.id.getValue() );
	}

	
	
	
}

