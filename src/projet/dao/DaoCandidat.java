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
import projet.data.Candidat;

public class DaoCandidat {

	
	// Champs

	@Inject
	private DataSource		dataSource;
	
	
	// Actions

	public int inserer( Candidat candidat ) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs		= null;
		String				sql;
		
		try {
			cn = dataSource.getConnection();
			sql = "INSERT INTO candidat ( club, nom, prenom, dateden, adresse, numtelephone, mail ) VALUES( ?, ?, ?, ?, ?, ?, ? ) ";
			stmt = cn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
			stmt.setObject( 1, candidat.getClub() );
			stmt.setObject( 2, candidat.getNom() );
			stmt.setObject( 3, candidat.getPrenom() );
			stmt.setObject( 4, candidat.getDateDeN() );
			stmt.setObject( 5, candidat.getAdresse() );
			stmt.setObject( 6, candidat.getNumtelephone() );
			stmt.setObject( 7, candidat.getMail() );
			
			stmt.executeUpdate();
			
			// Récupère l'identifiant généré par le SGBD
			rs = stmt.getGeneratedKeys();
			rs.next();
			candidat.setIdCandidat( rs.getObject( 1, Integer.class) );			
			return candidat.getIdCandidat();
	
		} catch ( SQLException e ) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	public void modifier( Candidat candidat ) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "UPDATE candidat SET club = ?, nom = ?, prenom = ?, dateden = ?, adresse = ?, numtelephone = ?, mail = ? WHERE idcandidat =  ?";
			stmt = cn.prepareStatement( sql );
			stmt.setObject( 1, candidat.getClub() );
			stmt.setObject( 2, candidat.getNom() );
			stmt.setObject( 3, candidat.getPrenom () );
			stmt.setObject( 4, candidat.getDateDeN() );
			stmt.setObject( 5, candidat.getAdresse() );
			stmt.setObject( 6, candidat.getNumtelephone() );
			stmt.setObject( 7, candidat.getMail() );
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}


	public void supprimer( int idCandidat ) {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		String				sql;

		try {
		
			
			cn = dataSource.getConnection();
			sql = "DELETE FROM candidat WHERE idcandidat = ? ";
			stmt = cn.prepareStatement( sql );
			stmt.setInt( 1, idCandidat );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}

	
	public Candidat retrouver( int idCandidat ) {

		Connection			cn 		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM candidat WHERE idcandidat = ?";
			stmt = cn.prepareStatement( sql );
			stmt.setInt(1, idCandidat);
			rs = stmt.executeQuery();

			if ( rs.next() ) {
				return construireCandidat( rs);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
		//return null;
	}


	
	public List<Candidat> listerTout() {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM candidat ORDER BY nom";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();

			List<Candidat> candidats = new LinkedList<>();
			while (rs.next()) {
				candidats.add( construireCandidat( rs ) );
			}
			return candidats;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	// Méthodes auxiliaires



	private Candidat construireCandidat( ResultSet rs) throws SQLException {
		Candidat candidat = new Candidat();
		candidat.setIdCandidat( rs.getObject( "idcandidat", Integer.class ) );
		candidat.setClub( rs.getObject( "club", String.class ) );
		candidat.setNom( rs.getObject( "nom", String.class ) );
		candidat.setPrenom( rs.getObject( "prenom", String.class ) );
		candidat.setDateDeN( rs.getObject( "dateden", LocalDate.class ) );
		candidat.setAdresse( rs.getObject( "adresse", String.class ) );
		candidat.setNumtelephone( rs.getObject( "numtelephone", Integer.class ) );
		candidat.setMail( rs.getObject( "mail", String.class ) );
		return candidat;
		
		

	}
}
