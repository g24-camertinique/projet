package projet.data;

import java.util.Objects;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class CompteA  {

	
	// Données observables
	
	private final Property<Integer>	id			= new SimpleObjectProperty<>();
	private final StringProperty	login		= new SimpleStringProperty();
	private final StringProperty	motDePasse	= new SimpleStringProperty();
	
	
	
	// Constructeurs
	
	public CompteA() {
	}

	public CompteA( int id, String login, String motDePasse ) {
		setId(id);
		setlogin(login);
		setMotDePasse(motDePasse);
		
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

	public final StringProperty loginProperty() {
		return this.login;
	}

	public final String getlogin() {
		return this.loginProperty().getValue();
	}

	public final void setlogin(final String login) {
		this.loginProperty().setValue(login);
	}

	public final StringProperty motDePasseProperty() {
		return this.motDePasse;
	}

	public final String getMotDePasse() {
		return this.motDePasseProperty().getValue();
	}

	public final void setMotDePasse(final String motDePasse) {
		this.motDePasseProperty().setValue(motDePasse);
	}

	

	
	// toString()
	
	@Override
	public String toString() {
		return getlogin();
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
		CompteA other = (CompteA) obj;
		return Objects.equals(id.getValue(), other.id.getValue() );
	}
	
}
