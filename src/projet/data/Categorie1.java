package projet.data;

import java.util.Objects;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Categorie1 {
	
	
	// Champs
	
	private final Property<Integer>		idCategorie1	= new SimpleObjectProperty<>();
	private final StringProperty 		nomCategorie	= new SimpleStringProperty();

	
	// Getters & setters
	
		//idCategorie1
	public final Property<Integer> idCategorie1Property() {
		return this.idCategorie1;
	}
	
	public final Integer getIdCategorie1() {
		return this.idCategorie1Property().getValue();
	}
	
	public final void setIdCategorie1(final Integer idCategorie1) {
		this.idCategorie1Property().setValue(idCategorie1);
	}
	
		//nomCategorie
	public final StringProperty nomCategorieProperty() {
		return this.nomCategorie;
	}
	
	public final String getNomCategorie() {
		return this.nomCategorieProperty().get();
	}
	
	public final void setNomCategorie(final String nomCategorie) {
		this.nomCategorieProperty().set(nomCategorie);
	}
	
	
	// hashCode() & equals()

	@Override
	public int hashCode() {
		return Objects.hash( idCategorie1.getValue() );
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categorie1 other = (Categorie1) obj;
		return Objects.equals( idCategorie1.getValue(), other.idCategorie1.getValue() );
	}


	// toString()
	
	@Override
	public String toString() {
		return this.getNomCategorie();
	}

	

	
}
