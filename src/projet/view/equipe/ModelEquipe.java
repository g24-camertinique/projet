package projet.view.equipe;

import javax.inject.Inject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jfox.commun.exception.ExceptionValidation;
import jfox.javafx.util.UtilFX;
import projet.commun.IMapper;
import projet.dao.DaoEquipe;
import projet.data.Equipe;

public class ModelEquipe  {
	
	
	// Données observables 
	
	private final ObservableList<Equipe> liste = FXCollections.observableArrayList(); 
	
	private final Equipe	courant = new Equipe();

	
	// Autres champs
    @Inject
	private IMapper			mapper;
    @Inject
	private DaoEquipe		daoEquipe;
	
	
	// Getters 
	
	public ObservableList<Equipe> getListe() {
		return liste;
	}
	
	public Equipe getCourant() {
		return courant;
	}
	
	
	// Actualisations
	
	public void actualiserListe() {
		liste.setAll( daoEquipe.listerTout() );
 	}


	// Actions
	
	public void preparerAjouter() {
		mapper.update( courant, new Equipe() );
	}
	
	public void preparerModifier( Equipe item ) {
		mapper.update( courant, daoEquipe.retrouver( item.getIdEquipe() ) );
	}
	
	
	public void validerMiseAJour() {

		// Vérifie la validité des données
		
		StringBuilder message = new StringBuilder();

		if( courant.getNom() == null || courant.getNom().isEmpty() ) {
			message.append( "\nLe nom ne doit pas être vide." );
		} else  if ( courant.getNom().length()> 50 ) {
			message.append( "\nLe nom est trop long : 50 maxi." );
		}

		if( courant.getNbreRepas() == null ) {
			message.append( "\nLe nombre de repas ne peut pas être vide." );
		} else  if ( courant.getNbreRepas() > 20  ) {
			message.append( "\nLe nombre de repas ne peut pas être supérieur à 20" );
		}
		
		
		if ( message.length() > 0 ) {
			throw new ExceptionValidation( message.toString().substring(1) );
		}
		
		
		// Effectue la mise à jour
		
		if ( courant.getIdEquipe() == null ) {
			// Insertion
			courant.setIdEquipe( daoEquipe.inserer( courant ) );
		} else {
			// modficiation
			daoEquipe.modifier( courant );
		}
	}
	
	
	public void supprimer( Equipe item ) {
		
		daoEquipe.supprimer( item.getIdEquipe() );
		System.out.println( UtilFX.findNext( liste, item ) );
		mapper.update( courant, UtilFX.findNext( liste, item ) );
	}
	
}
