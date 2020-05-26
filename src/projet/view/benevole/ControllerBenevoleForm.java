package projet.view.benevole;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import jfox.javafx.util.ConverterStringInteger;
import jfox.javafx.util.ConverterStringLocalDate;
import jfox.javafx.util.UtilFX;
import jfox.javafx.view.IManagerGui;
import projet.data.Benevole;
import projet.data.Candidat;
import projet.view.EnumView;


public class ControllerBenevoleForm {

	
	// Composants de la vue
	
	@FXML
	private TextField		textFieldId;
	
	@FXML
	private TextField		textFieldIdCompte;
	
	//Infos
	@FXML
	private TextField		textFieldNom;
	@FXML
	private TextField		textFieldPrenom;
	@FXML
	private DatePicker		datePicherDdn;
	@FXML
	private DatePicker		datePicherDateINS;
	
	//Coordonées
	@FXML
	private TextField		textFieldTelephone;
	@FXML
	private TextArea		textAreaAdresse;
	@FXML
	private TextField		textFieldMail;
	@FXML
	private TextField		textFieldDisponibilite;
	
	 // autres
	@FXML
	private CheckBox		CheckBoxValidation;

	@FXML
	private CheckBox		CheckBoxInterne;

	

	// Autres champs
	
	@Inject
	private IManagerGui		managerGui;
	@Inject
	private ModelBenevole	modelBenevole;

	
	

	// Initialisation du Controller

	@FXML
	private void initialize() {

		// Data binding
		
		
		Benevole courant = modelBenevole.getCourant();
		
		// id
		textFieldId.textProperty().bindBidirectional( courant.idBenevoleProperty(), new ConverterStringInteger()  );
		textFieldIdCompte.textProperty().bindBidirectional( courant.idCompteProperty() , new ConverterStringInteger()  );
	//infos
		// Nom
		textFieldNom.textProperty().bindBidirectional( courant.nomProperty() );
		
		// Prenom
		textFieldPrenom.textProperty().bindBidirectional( courant.prenomProperty() );
		  // disponibilite
		
		textFieldDisponibilite.textProperty().bindBidirectional( courant.disponibiliteProperty() );
		// Date de naissance
//		
		UtilFX.bindBidirectional( datePicherDdn.getEditor(), courant.dateDeNProperty(), new ConverterStringLocalDate() );
		
		// Date inscription
		UtilFX.bindBidirectional( datePicherDateINS.getEditor(), courant.dateInscriptionBProperty(), new ConverterStringLocalDate() );
		
	//coordonnées
		// Telephone
		textFieldTelephone.textProperty().bindBidirectional( courant.numTelephoneProperty(), new ConverterStringInteger()  );
		
		// Adresse
		textAreaAdresse.textProperty().bindBidirectional( courant.adresseProperty() );
// mail
		textFieldMail.textProperty().bindBidirectional( courant.mailProperty() );
		
	
}
	@FXML
	private void doAnnuler() {
		verifierValiditeSaisie();
		managerGui.showView( EnumView.BenevoleListe );
	}
	
	@FXML
	private void doValider() {
		verifierValiditeSaisie();
		modelBenevole.validerMiseAJour();
		managerGui.showView( EnumView.BenevoleListe );
	}
	
	
	

	
	// Méthodes auxiliaires	
	
	private void verifierValiditeSaisie() {
		Benevole courant = modelBenevole.getCourant();
		UtilFX.checkParseError( textFieldNom, courant.nomProperty() );
		UtilFX.checkParseError( datePicherDateINS.getEditor(), courant.dateInscriptionBProperty() );
		UtilFX.checkParseError( textFieldPrenom, courant.prenomProperty() );
		UtilFX.checkParseError( datePicherDdn.getEditor(), courant.dateDeNProperty() );
		UtilFX.checkParseError( textFieldMail, courant.mailProperty() );
	}
}
