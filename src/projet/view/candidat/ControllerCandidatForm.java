package projet.view.candidat;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jfox.javafx.util.ConverterStringInteger;
import jfox.javafx.util.ConverterStringLocalDate;
import jfox.javafx.util.UtilFX;
import jfox.javafx.view.IManagerGui;
import projet.data.Candidat;
import projet.view.EnumView;


public class ControllerCandidatForm {

	
	// Composants de la vue
	
	@FXML
	private TextField		textFieldId;
	@FXML
	private ImageView		imageLogo;
	
	//Infos
	@FXML
	private TextField		textFieldNom;
	@FXML
	private TextField		textFieldPrenom;
	@FXML
	private DatePicker		datePickerDdn;
	@FXML
	private TextField		textFieldClub;
	
	//Coordonées
	@FXML
	private TextField		textFieldTelephone;
	@FXML
	private TextArea		textAreaAdresse;
	@FXML
	private TextField		textFieldMail;


//	//Documents
//	@FXML
//	private ImageView		imageViewSchema;
//	@FXML
//	private Button			buttonOuvrirSchema;
//	@FXML
//	private Button			buttonSupprimerSchema;
	

	// Autres champs
	
	@Inject
	private IManagerGui		managerGui;
	@Inject
	private ModelCandidat	modelCandidat;

	
	

	// Initialisation du Controller

	@FXML
	private void initialize() {

		// Data binding
		
		Candidat courant = modelCandidat.getCourant();
		
		// id
		textFieldId.textProperty().bindBidirectional( courant.idCandidatProperty(), new ConverterStringInteger()  );
	
		Image image = new Image("projet/view/icone.png");
		imageLogo.setImage(image);
	//infos
		// Nom
		textFieldNom.textProperty().bindBidirectional( courant.nomProperty() );
		
		// Prenom
		textFieldPrenom.textProperty().bindBidirectional( courant.prenomProperty() );
				
		// Date de naissance
//		datePicherEcheance.getEditor().textProperty().bindBidirectional( courant.echeanceProperty(), new ConverterStringLocalDate() );
//		datePicherEcheance.getEditor().focusedProperty().addListener(new ListenerFocusValidation( courant.echeanceProperty())  );
		UtilFX.bindBidirectional( datePickerDdn.getEditor(), courant.dateDeNProperty(), new ConverterStringLocalDate() );
		
		// Club
		textFieldClub.textProperty().bindBidirectional( courant.clubProperty() );
		
	//coordonnées
		// Telephone
		textFieldTelephone.textProperty().bindBidirectional( courant.numtelephoneProperty(), new ConverterStringInteger()  );
		
		// Adresse
		textAreaAdresse.textProperty().bindBidirectional( courant.adresseProperty() );

		// Mail
		textFieldClub.textProperty().bindBidirectional( courant.mailProperty() );
	
		
//		// Schéma
//		imageViewSchema.imageProperty().bindBidirectional( modelCandidat.schemaProperty() );
//		
//		buttonSupprimerSchema.disableProperty().bind( Bindings.isNull( imageViewSchema.imageProperty() ) );
//	}
//	
//	
//	public void refresh() {
//		if ( modelCandidat.getFichierSchemaCourant().exists() ) {
//			buttonOuvrirSchema.setDisable( false );
//		} else {
//			buttonOuvrirSchema.setDisable( true );
//		}
		
	}
	
	
	// Actions
	
	
	
//	@FXML
//	private void doChoisirSchema() {
//		FileChooser fileChooser = new FileChooser();
//		fileChooser.setTitle("Choisissez un fichier image");
//		File fichier = fileChooser.showOpenDialog( managerGui.getStage() );
//		if ( fichier != null ) {
//			imageViewSchema.setImage( new Image( fichier.toURI().toString() ) );
//		}
//	}
//	
//	@FXML
//	private void doOuvrirSchema() {
//		try {
//			Desktop.getDesktop().open( modelCandidat.getFichierSchemaCourant() );
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//	}
//	
//	@FXML
//	private void doSupprimerSchema() {
//		imageViewSchema.setImage(null);
//	}
//	
	@FXML
	private void doAnnuler() {
		verifierValiditeSaisie();
		managerGui.showView( EnumView.CandidatListe );
	}
	
	@FXML
	private void doValider() {
		verifierValiditeSaisie();
		modelCandidat.validerMiseAJour();
		managerGui.showView( EnumView.CandidatListe );
	}
	
	
	// Gestion des évènements

	// Clic sur la liste
//	@FXML
//	private void gererClicSurSchema( MouseEvent event ) {
//		if (event.getButton().equals(MouseButton.PRIMARY)) {
//			if (event.getClickCount() == 2) {
//				if ( ! buttonOuvrirSchema.isDisable()  ) {
//					doOuvrirSchema();
//				}
//			}
//		}
//	}

	
	// Méthodes auxiliaires	
	
	private void verifierValiditeSaisie() {
		Candidat courant = modelCandidat.getCourant();
		UtilFX.checkParseError( textFieldNom, courant.nomProperty() );
		UtilFX.checkParseError( textFieldPrenom, courant.prenomProperty() );
		UtilFX.checkParseError( datePickerDdn.getEditor(), courant.dateDeNProperty() );
		UtilFX.checkParseError( textFieldMail, courant.mailProperty() );
	}
}
