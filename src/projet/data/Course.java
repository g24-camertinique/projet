package projet.data;

import java.time.LocalDate;
import java.util.Objects;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Course  {
	

	// Données observables
	
	private final Property<Integer>	id						= new SimpleObjectProperty<>();
	private final StringProperty	nom					= new SimpleStringProperty();
	private final Property<LocalDate>	date	= new SimpleObjectProperty<>();
	
	
	// Constructeurs
	
	public Course() {
	}

	public Course( final int id, final String nom,final LocalDate date ) {
		setId(id);
		setNom(nom);
		setDate(date);
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
		return this.nom;
	}
	

	public final String getNom() {
		return this.nomProperty().get();
	}
	

	public final void setNom(final String nom) {
		this.nomProperty().set(nom);
	}
	

	public final Property<LocalDate> dateProperty() {
		return this.date;
	}
	

	public final LocalDate getDate() {
		return this.dateProperty().getValue();
	}
	

	public final void setDate(final LocalDate date) {
		this.dateProperty().setValue(date);
	}
	
	// toString()
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", nom=" + nom + ", date=" + date + "]";
	}
	
	// hashCode() & equals()

	
	
	
	
	
}

