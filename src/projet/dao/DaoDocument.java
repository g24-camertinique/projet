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
import projet.data.Document;

public class DaoDocument {

	
	// Champs

	@Inject
	private DataSource		dataSource;

	
	// Actions

	public int inserer( Document document ) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs		= null;
		String				sql;
		
		try {
			cn = dataSource.getConnection();
			sql = "INSERT INTO document (libelle , iddocument ) VALUES( ?, ?) ";
			stmt = cn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
			stmt.setObject( 1,  document.getLibelle() );
			
		/*	if ( document.getCandidat() == null ) {
				stmt.setObject( 2, null );
			} else {
				stmt.setObject( 2,document.getCandidat().getId() );
			}
			*/
			stmt.executeUpdate();

			// Récupère l'identifiant généré par le SGBD
			rs = stmt.getGeneratedKeys();
			rs.next();
			document.setId( rs.getObject( 1, Integer.class) );
			return document.getId();
	
		} catch ( SQLException e ) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	public void modifier( Document document ) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "UPDATE service SET libelle = ?, idcandidat = ?,? WHERE iddocument =  ?";
			stmt = cn.prepareStatement( sql );
			stmt.setObject( 1, document.getLibelle() );
			/*
			if ( document.getIdcandidat() == null ) {
				stmt.setObject( 2, null );
			} else {
				stmt.setObject( 2, document.getidCandidat().getId() );
			}
			stmt.setObject( 3, document.getId() );
			stmt.executeUpdate();
			
			supprimerConcerner( document.getId() );
			insererConcerner(document );
*/
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}


	public void supprimer( int idDocument ) {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "DELETE FROM document WHERE iddocument = ? ";
			stmt = cn.prepareStatement( sql );
			stmt.setInt( 1, idDocument );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}

	
	public Document retrouver( int idDocument ) {

		Connection			cn 		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM service WHERE idservice = ?";
			stmt = cn.prepareStatement( sql );
			stmt.setInt(1, idDocument);
			rs = stmt.executeQuery();

			if ( rs.next() ) {
				return construireDocument( rs );
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	public List<Document> listerTout() {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM document ORDER BY nom";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();

			List<Document> documents = new LinkedList<>();
			while (rs.next()) {
				documents.add( construireDocument( rs ) );
			}
			return documents;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	
	
	// Méthodes auxiliaires
	
	private Document construireDocument( ResultSet rs ) throws SQLException {
		Document document = new Document();
		document.setId( rs.getObject( "iddocument", Integer.class ) );
		document.setLibelle( rs.getObject( "libelle", String.class ) );
		
		/*
		if ( flagComplet ) {
			Integer idCategorie = rs.getObject( "idcandidat", Integer.class  );
			if ( idCategorie != null ) {
				document.setCategorie( daoCandidat.retrouver(idCategorie) );
			}
			*/
		return document;
	}

}
