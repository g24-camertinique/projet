package projet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import jfox.dao.jdbc.UtilJdbc;
import projet.data.Benevole;



public class DaoBenevole {

	
	// Champs

	@Inject
	private DataSource		dataSource;

	
	// Actions

	public int inserer( Benevole benevole ) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs		= null;
		String				sql;
		
		try {
			cn = dataSource.getConnection();
			sql = "INSERT INTO benevole ( nom, prenom, dateden, adresse, numtelephone, mail, interne, disponibilite, validation, dateinscriptionb, idcompte ) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ";
			stmt = cn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
			stmt.setObject( 1, benevole.getNom() );
			stmt.setObject( 2, benevole.getPrenom() );
			stmt.setObject( 3, benevole.getDateDeN() );
			stmt.setObject( 4, benevole.getAdresse() );
			stmt.setObject( 5, benevole.getNumTelephone() );
			stmt.setObject( 6, benevole.getMail() );
			stmt.setObject( 7, benevole.getInterne() );
			stmt.setObject( 8, benevole.getDisponibilite() );
			stmt.setObject( 9, benevole.getValidation() );
			stmt.setObject( 10, benevole.getDateInscriptionB() );
			stmt.setObject( 11, benevole.getIdCompte() );
			
			stmt.executeUpdate();

			// Récupère l'identifiant généré par le SGBD
			rs = stmt.getGeneratedKeys();
			rs.next();
			benevole.setIdBenevole( rs.getObject( 1, Integer.class) );
			return benevole.getIdBenevole();
	
		} catch ( SQLException e ) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	public void modifier( Benevole benevole ) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "UPDATE benevole SET nom = ?, prenom = ?, dateden = ?, adresse = ?, numtelephone = ?, mail = ?, interne = ?, disponibilite = ?, validation = ?, dateinscriptionb = ?, idcompte = ? WHERE idbenevole =  ?";
			stmt = cn.prepareStatement( sql );
			stmt.setObject( 1, benevole.getNom() );
			stmt.setObject( 2, benevole.getPrenom() );
			stmt.setObject( 3, benevole.getDateDeN() );
			stmt.setObject( 4, benevole.getAdresse() );
			stmt.setObject( 5, benevole.getNumTelephone() );
			stmt.setObject( 6, benevole.getMail() );
			stmt.setObject( 7, benevole.getInterne() );
			stmt.setObject( 8, benevole.getDisponibilite() );
			stmt.setObject( 9, benevole.getValidation() );
			stmt.setObject( 10, benevole.getDateInscriptionB() );
			stmt.setObject( 11, benevole.getIdCompte() );
			stmt.setObject( 12, benevole.getIdBenevole() );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}


	public void supprimer( int idBenevole ) {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		String				sql;

		try {

			cn = dataSource.getConnection();
			sql = "DELETE FROM benevole WHERE idbenevole = ? ";
			stmt = cn.prepareStatement( sql );
			stmt.setInt( 1, idBenevole );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}

	
	public Benevole retrouver( int idBenevole ) {

		Connection			cn 		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM benevole WHERE idbenevole = ?";
			stmt = cn.prepareStatement( sql );
			stmt.setInt(1, idBenevole);
			rs = stmt.executeQuery();

			if ( rs.next() ) {
				return construireBenevole( rs, true );
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	public List<Benevole> listerTout() {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM benevole ORDER BY nom";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();

			List<Benevole> benevoles = new LinkedList<>();
			while (rs.next()) {
				benevoles.add( construireBenevole( rs, false ) );
			}
			return benevoles;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	
 
	
	// Méthodes auxiliaires
	
	private Benevole construireBenevole( ResultSet rs, boolean flagComplet ) throws SQLException {
		Benevole benevole = new Benevole();
		benevole.setIdBenevole( rs.getObject( "idbenevole", Integer.class ) );
		benevole.setNom( rs.getObject( "nom", String.class ) );
		benevole.setPrenom( rs.getObject( "prenom", String.class ) );
		benevole.setDateDeN( rs.getObject( "dateden", LocalDate.class ) );
		benevole.setAdresse( rs.getObject( "adresse", String.class ) );
		benevole.setNumTelephone( rs.getObject( "numtelephone", Integer.class ) );
		benevole.setMail( rs.getObject( "mail", String.class ) );
		benevole.setInterne( rs.getObject( "interne", Boolean.class ) );
		benevole.setDisponibilite( rs.getObject( "disponibilite", String.class ) );
		benevole.setValidation( rs.getObject( "validation", Boolean.class ) );
		benevole.setDateInscriptionB( rs.getObject( "dateinscriptionb", LocalDate.class ) );
		benevole.setIdCompte( rs.getObject( "idcompte", Integer.class ) );
		
		return benevole;
	}


}
