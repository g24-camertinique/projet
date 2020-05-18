package projet.view.candidat;

import java.time.LocalDate;

import javax.inject.Inject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jfox.commun.exception.ExceptionValidation;
import jfox.javafx.util.UtilFX;
import projet.commun.IMapper;
import projet.dao.DaoCandidat;
import projet.data.Candidat;


public class ModelCandidat  {
	
	
	// Données observables 
	
	private final ObservableList<Candidat> liste = FXCollections.observableArrayList(); 
	
	private final Candidat	courant = new Candidat();

	
	// Autres champs
    @Inject
	private IMapper			mapper;
    @Inject
	private DaoCandidat		daoCandidat;
	
	
	// Getters 
	
	public ObservableList<Candidat> getListe() {
		return liste;
	}
	
	public Candidat getCourant() {
		return courant;
	}
	
	
	// Actualisations
	
	public void actualiserListe() {
		liste.setAll( daoCandidat.listerTout() );
 	}


	// Actions
	
	public void preparerAjouter() {
		mapper.update( courant, new Candidat() );
	}
	
	public void preparerModifier( Candidat item ) {
		mapper.update( courant, daoCandidat.retrouver( item.getIdCandidat() ) );
	}
	
	
	public void validerMiseAJour() {

		// Vérifie la validité des données
		
		StringBuilder message = new StringBuilder();

		if( courant.getNom() == null || courant.getNom().isEmpty() ) {
			message.append( "\nLe nom ne doit pas être vide." );
		} else  if ( courant.getNom().length()> 50 ) {
			message.append( "\nLe nom est trop long : 50 maxi." );
		}

		if( courant.getClub() == null || courant.getClub().isEmpty() ) {
			message.append( "\nLe club ne doit pas être vide." );
		} else  if ( courant.getClub().length()> 50 ) {
			message.append( "\nLe club est trop long : 50 maxi." );
		}
		
		if( courant.getPrenom() == null || courant.getPrenom().isEmpty() ) {
			message.append( "\nLe prenom ne doit pas être vide." );
		} else  if ( courant.getPrenom().length()> 50 ) {
			message.append( "\nLe prenom est trop long : 50 maxi." );
		}
		
		if( courant.getDateDeN() != null ) {
			if ( courant.getDateDeN().isAfter(LocalDate.parse("2006-01-01")) ) {
				message.append( "\nUn candidat ne peut pas avoir moins de 14ans." );
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
		
		if ( courant.getIdCandidat() == null ) {
			// Insertion
			courant.setIdCandidat( daoCandidat.inserer( courant ) );
		} else {
			// modficiation
			daoCandidat.modifier( courant );
		}
	}
	
	
	public void supprimer( Candidat item ) {
		
		daoCandidat.supprimer( item.getIdCandidat() );
		System.out.println( UtilFX.findNext( liste, item ) );
		mapper.update( courant, UtilFX.findNext( liste, item ) );
	}
	
}
