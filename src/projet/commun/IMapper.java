package projet.commun;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import projet.data.Benevole;
import projet.data.Candidat;
import projet.data.Categorie;
import projet.data.Compte;
import projet.data.Equipe;
import projet.data.Memo;
import projet.data.Personne;
import projet.data.Service;


@Mapper
public interface IMapper {  
	
	Compte update( @MappingTarget Compte target, Compte source  );
	
	Categorie update( @MappingTarget Categorie target, Categorie source );

	@Mapping( target="categorie", expression="java( source.getCategorie() )" )
	Personne update( @MappingTarget Personne target, Personne source );

	@Mapping( target="categorie", expression="java( source.getCategorie() )" )
	Memo update( @MappingTarget Memo target, Memo source );

	Service update( @MappingTarget Service target, Service source );
	
	//Ajoutés pour notre projet
	Candidat update(@MappingTarget Candidat target, Candidat source );
	Benevole update(@MappingTarget Benevole target, Benevole source );
	Equipe update(@MappingTarget Equipe target, Equipe source );
}
