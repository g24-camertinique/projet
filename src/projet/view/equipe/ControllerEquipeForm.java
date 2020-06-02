package projet.view.equipe;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javax.inject.Inject;

import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import jfox.javafx.util.ConverterStringDouble;
import jfox.javafx.util.ConverterStringInteger;
import jfox.javafx.util.ConverterStringLocalDate;
import jfox.javafx.util.UtilFX;
import jfox.javafx.view.IManagerGui;
import projet.data.Categorie;
import projet.data.Equipe;
import projet.data.Memo;
import projet.data.Personne;
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
	private DatePicker		datePicherInscription;
	@FXML
	private TextField		textFieldCategorie;
	
	//Info
	@FXML
	private TextField		textFieldNbrRepas;
	@FXML
	private TextField		textFieldIdCompte;
	@FXML
	private CheckBox		checkBoxValidation;
	//Button
	@FXML
	private Button			buttonOkay;
	@FXML
	private Button			buttonAnnuler;
	

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
		textFieldNom.textProperty().bindBidirectional( courant.nomProperty() );
		//Équipier
		textFieldNom.textProperty().bindBidirectional( courant.nomProperty() );
		// Date inscription
		UtilFX.bindBidirectional( datePicherInscription.getEditor(), courant.dateInscriptionEProperty(), new ConverterStringLocalDate() );
		// Catégorie
		textFieldCategorie.textProperty().bindBidirectional( courant.nomProperty() );
		
		
		//NmbreRepas
		textFieldNbrRepas.textProperty().bindBidirectional( courant.idEquipeProperty(), new ConverterStringInteger()  );
		//IdCompte
		textFieldIdCompte.textProperty().bindBidirectional( courant.idEquipeProperty(), new ConverterStringInteger()  );
		// Validation
		checkBoxValidation.selectedProperty().bindBidirectional( courant.validationProperty() );
		
	
	}
	
	
	// Actions
	
	
	

	

	@FXML
	private void doAnnuler() {
		verifierValiditeSaisie();
		managerGui.showView( EnumView.MemoListe );
	}
	
	@FXML
	private void doOkay() {
		verifierValiditeSaisie();
		modelEquipe.validerMiseAJour();
		managerGui.showView( EnumView.MemoListe );
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
		UtilFX.checkParseError( textFieldCapitaine, courant.idCandidatCapProperty() );
		UtilFX.checkParseError( textFieldEquipier, courant.idCandidatEqProperty() );
		UtilFX.checkParseError( textFieldNom, courant.nomProperty() );
		UtilFX.checkParseError( datePicherInscription.getEditor(), courant.dateInscriptionEProperty() );
	}
}
