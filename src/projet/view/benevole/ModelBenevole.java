package projet.view.benevole;

import java.time.LocalDate;

import javax.inject.Inject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jfox.commun.exception.ExceptionValidation;
import jfox.javafx.util.UtilFX;
import projet.commun.IMapper;
import projet.dao.DaoBenevole;
import projet.dao.DaoCandidat;
import projet.data.Benevole;
import projet.data.Candidat;


public class ModelBenevole  {
	
	
	// Données observables 
	
	private final ObservableList<Benevole> liste = FXCollections.observableArrayList(); 
	
	private final Benevole	courant = new Benevole();

	
	// Autres champs
    @Inject
	private IMapper			mapper;
    @Inject
	private DaoBenevole	daoBenevole;
	
	
	// Getters 
	
	public ObservableList<Benevole> getListe() {
		return liste;
	}
	
	public Benevole getCourant() {
		return courant;
	}
	
	
	// Actualisations
	
	public void actualiserListe() {
		liste.setAll( daoBenevole.listerTout() );
 	}


	// Actions
	
	public void preparerAjouter() {
		mapper.update( courant, new Benevole() );
	}
	
	public void preparerModifier( Benevole item ) {
		mapper.update( courant, daoBenevole.retrouver( item.getIdBenevole() ) );
	}
	
	
	public void validerMiseAJour() {

		// Vérifie la validité des données
		
		StringBuilder message = new StringBuilder();

		if( courant.getNom() == null || courant.getNom().isEmpty() ) {
			message.append( "\nLe nom ne doit pas être vide." );
		} else  if ( courant.getNom().length()> 50 ) {
			message.append( "\nLe nom est trop long : 50 maxi." );
		}
		
		if( courant.getDisponibilite() == null || courant.getDisponibilite().isEmpty() ) {
			message.append( "\nLa disponibilite ne doit pas être vide." );
		} else  if ( courant.getDisponibilite().length()> 50 ) {
			message.append( "\nLa disponibilite est trop longue : 50 maxi." );
		}

		//if( courant.getDateInscriptionB() != null ) {
		//	if ( courant.getDateInscriptionB().isAfter(LocalDate.parse("2006-01-01")) ) {
		//		message.append( "\nUn benevole ne peut pas avoir moins de 14ans." );
		//	}
		//}
		
		if( courant.getPrenom() == null || courant.getPrenom().isEmpty() ) {
			message.append( "\nLe prenom ne doit pas être vide." );
		} else  if ( courant.getPrenom().length()> 50 ) {
			message.append( "\nLe prenom est trop long : 50 maxi." );
		}
		
		if( courant.getDateDeN() != null ) {
			if ( courant.getDateDeN().isAfter(LocalDate.parse("2006-01-01")) ) {
				message.append( "\nUn benevole ne peut pas avoir moins de 14ans." );
			}
		}
		
		if( courant.getMail() == null || courant.getMail().isEmpty() ) {
			message.append( "\nLe mail ne doit pas être vide." );
		} else  if ( courant.getMail().length()> 50 ) {
			message.append( "\nLe mail est trop long : 50 maxi." );
		}
		
		if ( message.length() > 0 ) {
			throw new ExceptionValidation( message.toString().substring(1) );
		}
		
		
		// Effectue la mise à jour
		
		if ( courant.getIdBenevole() == null ) {
			// Insertion
			courant.setIdBenevole( daoBenevole.inserer( courant ) );
		} else {
			// modficiation
			daoBenevole.modifier( courant );
		}
	}
	
	
	public void supprimer( Benevole item ) {
		
		daoBenevole.supprimer( item.getIdBenevole() );
		System.out.println( UtilFX.findNext( liste, item ) );
		mapper.update( courant, UtilFX.findNext( liste, item ) );
	}
	
}
