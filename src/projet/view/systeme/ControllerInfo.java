package projet.view.systeme;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import projet.view.EnumView;
import jfox.javafx.view.IManagerGui;


public class ControllerInfo {
	
	
	// Composants de la vue
	
	@FXML
	private Label		labelTitre;
	@FXML
	private Label		labelMessage;
	@FXML
	private ImageView	imageLogo;

	
	// Autres champs
	@Inject
	private IManagerGui			managerGui;
	@Inject
	private ModelInfo	modelInfo;
	
	
	// Initialisation
	
	@FXML
	private void initialize() {
		
		// Data binding
		labelTitre.textProperty().bind( modelInfo.titreProperty() );
		labelMessage.textProperty().bind( modelInfo.messageProperty() );
		
		Image image = new Image("projet/view/icone.png");
		imageLogo.setImage(image);
	}
	
	// Méthodes reliées aux boutons
	@FXML
	private void doCandidat() {
		managerGui.showView( EnumView.CandidatListe );
	}
	@FXML
	private void doEquipe() {
		managerGui.showView( EnumView.EquipeListe );
	}
	@FXML
	private void doBenevole() {
		managerGui.showView( EnumView.BenevoleListe );
	}
}
