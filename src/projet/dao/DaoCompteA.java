package projet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import jfox.dao.jdbc.UtilJdbc;
import projet.data.Compte;
import projet.data.CompteA;


public class DaoCompteA {

	
	// Champs

	@Inject
	private DataSource		dataSource;
	
	
	// Actions

	public int inserer( CompteA compte )  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			// Insère le compte
			sql = "INSERT INTO compte ( login, motdepasse) VALUES ( ?, ?)";
			stmt = cn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS ); 
			stmt.setObject( 1, compte.getlogin() );
			stmt.setObject( 2, compte.getMotDePasse() );
			
			stmt.executeUpdate();

			// Récupère l'identifiant généré par le SGBD
			rs = stmt.getGeneratedKeys();
			rs.next();
			compte.setId( rs.getObject( 1, Integer.class) );
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}

	
		// Retourne l'identifiant
		return compte.getId();
	}
	

	public void modifier( CompteA compte )  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String 				sql;

		try {
			cn = dataSource.getConnection();

			// Modifie le compte
			sql = "UPDATE compte SET login = ?, motdepasse = ? WHERE idcompte =  ?";
			stmt = cn.prepareStatement( sql );
			stmt.setObject( 1, compte.getlogin() );
			stmt.setObject( 2, compte.getMotDePasse() );
			
			stmt.setObject( 3, compte.getId() );
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}

		
	}
	

	public void supprimer( int idCompte )  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String 				sql;

		
		try {
			cn = dataSource.getConnection();

			// Supprime le compte
			sql = "DELETE FROM compte WHERE idcompte = ? ";
			stmt = cn.prepareStatement( sql );
			stmt.setObject( 1, idCompte );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}
	

	public CompteA retrouver( int idCompte )  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM compte WHERE idcompte = ?";
            stmt = cn.prepareStatement( sql );
            stmt.setObject( 1, idCompte );
            rs = stmt.executeQuery();

            if ( rs.next() ) {
                return construireCompte( rs );
            } else {
            	return null;
            }
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	

	public List<CompteA> listerTout()   {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM compte ORDER BY login";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();

			List<CompteA> comptes = new ArrayList<>();
			while ( rs.next() ) {
				comptes.add( construireCompte(rs) );
			}
			return comptes;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	public CompteA validerAuthentification( String login, String motDePasse )  {
		
		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM compte WHERE login = ? AND motdepasse = ?";
			stmt = cn.prepareStatement( sql );
			stmt.setObject( 1, login );
			stmt.setObject( 2, motDePasse );
			rs = stmt.executeQuery();

			if ( rs.next() ) {
				return construireCompte( rs );			
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	public boolean verifierUnicitelogin( String login, Integer idCompte )   {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		if ( idCompte == null ) idCompte = 0;
		
		try {
			cn = dataSource.getConnection();

			sql = "SELECT COUNT(*) = 0 AS unicite"
					+ " FROM compte WHERE login = ? AND idcompte <> ?";
			stmt = cn.prepareStatement( sql );
			stmt.setObject(	1, login );
			stmt.setObject(	2, idCompte );
			rs = stmt.executeQuery();
			
			rs.next();
			return rs.getBoolean( "unicite" );
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	
	
	// Méthodes auxiliaires
	
	private CompteA construireCompte( ResultSet rs ) throws SQLException {
		CompteA compte = new CompteA();
		compte.setId( rs.getObject( "idcompte", Integer.class ) );
		compte.setlogin( rs.getObject( "login", String.class ) );
		compte.setMotDePasse( rs.getObject( "motdepasse", String.class ) );
		
		return compte;
	}
	
}
