package projet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import jfox.dao.jdbc.UtilJdbc;
import projet.data.Categorie1;


public class DaoCategorie1 {

	
	// Champs

	@Inject
	private DataSource		dataSource;

	
	// Actions

	public int inserer( Categorie1 categorie1 ) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs		= null;
		String				sql;
		
		try {
			cn = dataSource.getConnection();
			sql = "INSERT INTO categorie1 ( nomcategorie ) VALUES( ? ) ";
			stmt = cn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
			stmt.setObject( 1, categorie1.getNomCategorie());
			stmt.executeUpdate();

			// Récupère l'identifiant généré par le SGBD
			rs = stmt.getGeneratedKeys();
			rs.next();
			categorie1.setIdCategorie1( rs.getObject( 1, Integer.class) );
			return categorie1.getIdCategorie1();
	
		} catch ( SQLException e ) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	public void modifier( Categorie1 categorie1 ) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "UPDATE categorie1 SET nomcategorie = ? WHERE idcategorie1 =  ?";
			stmt = cn.prepareStatement( sql );
			stmt.setObject( 1, categorie1.getNomCategorie() );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}


	public void supprimer( int idCategorie1 ) {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "DELETE FROM categorie1 WHERE idcategorie1 = ? ";
			stmt = cn.prepareStatement( sql );
			stmt.setInt( 1, idCategorie1 );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}

	
	public Categorie1 retrouver( int idCategorie1 ) {

		Connection			cn 		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM categorie1 WHERE idcategorie1 = ?";
			stmt = cn.prepareStatement( sql );
			stmt.setInt(1, idCategorie1);
			rs = stmt.executeQuery();

			if ( rs.next() ) {
				return construireCategorie1( rs, true );
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	public List<Categorie1> listerTout() {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM categorie1 ORDER BY nomcategorie";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();

			List<Categorie1> categorie1s = new LinkedList<>();
			while (rs.next()) {
				categorie1s.add( construireCategorie1( rs, false ) );
			}
			return categorie1s;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}

	
	// Méthodes auxiliaires
	
	private Categorie1 construireCategorie1( ResultSet rs, boolean flagComplet ) throws SQLException {
		Categorie1 categorie1 = new Categorie1();
		categorie1.setIdCategorie1( rs.getObject( "idcategorie1", Integer.class ) );
		categorie1.setNomCategorie( rs.getObject( "nomcategorie", String.class ) );

		return categorie1;
	}
	

}
