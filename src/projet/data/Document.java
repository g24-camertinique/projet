package projet.data;

import java.util.Objects;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Document {
	
	
	// Champs
	
	private final Property<Integer>		id			= new SimpleObjectProperty<>();
	private final StringProperty   	 	libelle       = new SimpleStringProperty();
	private final Property<Integer> 	idCandidat = new SimpleObjectProperty<Integer>();

	
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
		Document other = (Document) obj;
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
	

	public final StringProperty libelleProperty() {
		return this.libelle;
	}
	

	public final String getLibelle() {
		return this.libelleProperty().get();
	}
	

	public final void setLibelle(final String libelle) {
		this.libelleProperty().set(libelle);
	}
	

	public final Property<Integer> idCandidatProperty() {
		return this.idCandidat;
	}
	

	public final Integer getIdCandidat() {
		return this.idCandidatProperty().getValue();
	}
	

	public final void setIdCandidat(final Integer idCandidat) {
		this.idCandidatProperty().setValue(idCandidat);
	}
	

}
