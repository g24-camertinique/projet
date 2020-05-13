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
import projet.data.Equipe;

public class DaoEquipe {

	// Champs

	@Inject
	private DataSource dataSource;

	// Actions

	public int inserer(Equipe equipe) {

		Connection cn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;

		try {
			cn = dataSource.getConnection();
			sql = "INSERT INTO equipe ( nom,nmbreRepas,validation,dateInscriptionE,id_Categorie,id_Course ) VALUES( ?,?,?,?,?,? ) ";
			stmt = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setObject(1, equipe.getNom());
			stmt.setObject(2, equipe.getValidation());
			stmt.setObject(3, equipe.getNmbreRepas());
			stmt.setObject(4, equipe.getDateInscriptionE());
			stmt.setObject(5, equipe.getId_Categorie());
			stmt.setObject(6, equipe.getId_Course());
			stmt.executeUpdate();

			// Récupère l'identifiant généré par le SGBD
			rs = stmt.getGeneratedKeys();
			rs.next();
			equipe.setId(rs.getObject(1, Integer.class));

			return equipe.getId();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close(rs, stmt, cn);
		}
	}

	public void modifier(Equipe equipe) {

		Connection cn = null;
		PreparedStatement stmt = null;
		String sql;

		try {

			cn = dataSource.getConnection();
			sql = "UPDATE equipe SET nom = ? ,nmbreRepas=?,validation=?,dateInscriptionE=?,id_Categorie=?,id_Course=?  WHERE idequipe =  ?";
			stmt = cn.prepareStatement(sql);
			stmt.setObject(1, equipe.getNom());
			stmt.setObject(2, equipe.getValidation());
			stmt.setObject(3, equipe.getNmbreRepas());
			stmt.setObject(4, equipe.getDateInscriptionE());
			stmt.setObject(5, equipe.getId_Categorie());
			stmt.setObject(6, equipe.getId_Course());
			stmt.setObject(7, equipe.getId());
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close(stmt, cn);
		}
	}

	public void supprimer(int idEquipe) {

		Connection cn = null;
		PreparedStatement stmt = null;
		String sql;

		try {
			cn = dataSource.getConnection();
			sql = "DELETE FROM equipe WHERE idequipe = ? ";
			stmt = cn.prepareStatement(sql);
			stmt.setObject(1, idEquipe);
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close(stmt, cn);
		}
	}

	public Equipe retrouver(int idequipe) {

		Connection cn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM equipe WHERE idequipe = ?";
			stmt = cn.prepareStatement(sql);
			stmt.setObject(1, idequipe);
			rs = stmt.executeQuery();

			if (rs.next()) {
				return construireEquipe(rs);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close(rs, stmt, cn);
		}
	}

	public List<Equipe> listerTout() {

		Connection cn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM equipe ORDER BY nom";
			stmt = cn.prepareStatement(sql);
			rs = stmt.executeQuery();

			List<Equipe> equipes = new LinkedList<>();
			while (rs.next()) {
				equipes.add(construireEquipe(rs));
			}
			return equipes;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close(rs, stmt, cn);
		}
	}

	// Méthodes auxiliaires

	private Equipe construireEquipe(ResultSet rs) throws SQLException {
		Equipe equipe = new Equipe();
		equipe.setId(rs.getObject("idequipe", Integer.class));
		equipe.setNom(rs.getObject("nom", String.class));
		equipe.setNmbreRepas(rs.getObject("nmbreRepas", Integer.class));
		equipe.setValidation(rs.getObject("validation", boolean.class));
		equipe.setDateInscriptionE(rs.getObject("dateInscriptionE", LocalDate.class));
		equipe.setId_Categorie(rs.getObject("id_categorie", Integer.class));
		equipe.setId_Course(rs.getObject("id_Course", Integer.class));

		return equipe;
	}

}
