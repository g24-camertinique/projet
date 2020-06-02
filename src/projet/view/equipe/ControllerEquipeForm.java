package projet.view.equipe;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import jfox.javafx.util.ConverterStringInteger;
import jfox.javafx.util.ConverterStringLocalDate;
import jfox.javafx.util.UtilFX;
import jfox.javafx.view.IManagerGui;
import projet.data.Equipe;
import projet.view.EnumView;


public class ControllerEquipeForm {

	
	// Composants de la vue
	
	@FXML
	private TextField		textFieldId;
	@FXML
	private TextField		textFieldNom;
	@FXML
	private TextField		textFieldCapitaine;
	@FXML
	private TextField		textFieldEquipier;
	@FXML
	private DatePicker		datePickerInscription;
	@FXML
	private TextField		textFieldCategorie;
	@FXML 
	private TextField		textFieldCourse;
	
	//Info
	@FXML
	private TextField		textFieldNbrRepas;
	@FXML
	private TextField		textFieldIdCompte;
	@FXML
	private CheckBox		checkBoxValidation;
	

	// Autres champs
	
	@Inject
	private IManagerGui		managerGui;
	@Inject
	private ModelEquipe		modelEquipe;

	
	

	// Initialisation du Controller

	@FXML
	private void initialize() {

		// Data binding
		
		Equipe courant = modelEquipe.getCourant();
		
		
		// id
		textFieldId.textProperty().bindBidirectional( courant.idEquipeProperty(), new ConverterStringInteger()  );
		// Nom
		textFieldNom.textProperty().bindBidirectional( courant.nomProperty() );
		
		//Capitaine
		textFieldCapitaine.textProperty().bindBidirectional( courant.idCandidatCapProperty(), new ConverterStringInteger() );
		//Équipier
		textFieldEquipier.textProperty().bindBidirectional( courant.idCandidatEqProperty(), new ConverterStringInteger() );
		// Date inscription
		UtilFX.bindBidirectional( datePickerInscription.getEditor(), courant.dateInscriptionEProperty(), new ConverterStringLocalDate() );
		// Catégorie
		textFieldCategorie.textProperty().bindBidirectional( courant.idCategorie1Property(), new ConverterStringInteger() );
		// Course
		textFieldCourse.textProperty().bindBidirectional( courant.idCourseProperty(), new ConverterStringInteger());
		
		
		//NmbreRepas
		textFieldNbrRepas.textProperty().bindBidirectional( courant.nbreRepasProperty(), new ConverterStringInteger()  );
		//IdCompte
		textFieldIdCompte.textProperty().bindBidirectional( courant.idCompteProperty(), new ConverterStringInteger()  );
		// Validation
		checkBoxValidation.selectedProperty().bindBidirectional( courant.validationProperty() );
		
	
	}
	
	
	// Actions
	
	
	

	

	@FXML
	private void doAnnuler() {
		verifierValiditeSaisie();
		managerGui.showView( EnumView.EquipeListe );
	}
	
	@FXML
	private void doValider() {
		verifierValiditeSaisie();
		modelEquipe.validerMiseAJour();
		managerGui.showView( EnumView.EquipeListe );
	}
	
	
	// Gestion des évènements

	// Clic sur la liste
	/*
	@FXML
	private void gererClicSurSchema( MouseEvent event ) {
		if (event.getButton().equals(MouseButton.PRIMARY)) {
			if (event.getClickCount() == 2) {
				if ( ! buttonOuvrirSchema.isDisable()  ) {
					doOuvrirSchema();
				}
			}
		}
	}*/

	
	// Méthodes auxiliaires
	/*
	private void actualiserStatutDansModele() {
		// Modifie le statut en fonction du bouton radio sélectionné 
		Toggle bouton = toggleGroupStatut.getSelectedToggle();
		int statut = toggleGroupStatut.getToggles().indexOf( bouton  );
		modelMemo.getCourant().setStatut( statut );
	}
	
	private void actualiserStatutDansVue() {
		// Sélectionne le bouton radio correspondant au statut
		int statut = modelMemo.getCourant().getStatut();
		Toggle bouton = toggleGroupStatut.getToggles().get( statut );
		toggleGroupStatut.selectToggle(  bouton );
	}
	*/
	
	private void verifierValiditeSaisie() {
		Equipe courant = modelEquipe.getCourant();
		UtilFX.checkParseError( textFieldNom, courant.nomProperty() );
		UtilFX.checkParseError( textFieldNbrRepas, courant.nbreRepasProperty() );
	}
}
