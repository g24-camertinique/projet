package projet.view.systeme;

import javax.inject.Inject;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jfox.javafx.view.IManagerGui;
import projet.data.Compte;
import projet.view.EnumView;


public class ControllerConnexion {
	

	// Composants de la vue
	
	@FXML
	private TextField		fieldPseudo;
	@FXML
	private PasswordField	fieldMotDePasse;
	@FXML
	private ImageView		imageLogo;
	
	// Autres champs
	
	@Inject
	private IManagerGui		managerGui;
	@Inject
	private ModelConnexion	modelConnexion;
	@Inject
	private ModelInfo		modelInfo;
	
	
	// Initialisation du Controller
	
	@FXML
	private void initialize() {
		
		// Data binding
		Compte courant = modelConnexion.getCourant();
		fieldPseudo.textProperty().bindBidirectional( courant.pseudoProperty() );
		fieldMotDePasse.textProperty().bindBidirectional( courant.motDePasseProperty() );

		Image image = new Image("projet/view/icone.png");
		imageLogo.setImage(image);
	}
	
	
	public void refresh() {
		// Ferme la session si elle est ouverte
		if ( modelConnexion.getCompteActif() != null ) {
			modelConnexion.fermerSessionUtilisateur();
		}
	}
	

	// Actions
	
	@FXML
	private void doConnexion() {
		managerGui.execTask( () -> {
			modelConnexion.ouvrirSessionUtilisateur();
			Platform.runLater( () -> {
         			modelInfo.titreProperty().setValue( "Bienvenue" );
        			modelInfo.messageProperty().setValue( "Connexion réussie" );
        			managerGui.showView(EnumView.Info);
            }) ;
		} );
	}
	

}
