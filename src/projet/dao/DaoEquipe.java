package projet.dao;

import java.sql.CallableStatement;
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
			sql = "INSERT INTO equipe ( nom, nbreRepas, validation, dateinscriptione, idcompte, idcourse, idcategorie1, idcandidatcap, idcandidateq ) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ? ) ";
			stmt = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setObject(1, equipe.getNom());
			stmt.setObject(2, equipe.getNbreRepas());
			stmt.setObject(3, equipe.getValidation());
			stmt.setObject(4, equipe.getDateInscriptionE());
			stmt.setObject(5, equipe.getIdCompte());
			stmt.setObject(6, equipe.getIdCourse());
			stmt.setObject(7, equipe.getIdCategorie1());
			stmt.setObject(8, equipe.getIdCandidatCap());
			stmt.setObject(9, equipe.getIdCandidatEq());
			stmt.executeUpdate();

			// Récupère l'identifiant généré par le SGBD
			rs = stmt.getGeneratedKeys();
			rs.next();
			equipe.setIdEquipe(rs.getObject(1, Integer.class));

			return equipe.getIdEquipe();

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
			sql = "UPDATE equipe SET nom=?, nbreRepas=?, validation=?, dateinscriptione=?, idcompte=?, idcourse=?, idcategorie1=?, idcandidatcap=?, idcandidateq=?  WHERE idequipe =  ?";
			stmt = cn.prepareStatement(sql);
			stmt.setObject(1, equipe.getNom());
			stmt.setObject(2, equipe.getNbreRepas());
			stmt.setObject(3, equipe.getValidation());
			stmt.setObject(4, equipe.getDateInscriptionE());
			stmt.setObject(5, equipe.getIdCompte());
			stmt.setObject(6, equipe.getIdCourse());
			stmt.setObject(7, equipe.getIdCategorie1());
			stmt.setObject(8, equipe.getIdCandidatCap());
			stmt.setObject(9, equipe.getIdCandidatEq());
			stmt.setObject(10, equipe.getIdEquipe());
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
		equipe.setIdEquipe(rs.getObject("idequipe", Integer.class));
		equipe.setNom(rs.getObject("nom", String.class));
		equipe.setNbreRepas(rs.getObject("nbreRepas", Integer.class));
		equipe.setValidation(rs.getObject("validation", Boolean.class));
		equipe.setDateInscriptionE(rs.getObject("dateInscriptionE", LocalDate.class));
		equipe.setIdCompte(rs.getObject("idcompte", Integer.class));
		equipe.setIdCourse(rs.getObject("idcourse", Integer.class));
		equipe.setIdCategorie1(rs.getObject("idcategorie1", Integer.class));
		equipe.setIdCandidatCap(rs.getObject("idcandidatcap", Integer.class));
		equipe.setIdCandidatEq(rs.getObject("idcandidateq", Integer.class));

		return equipe;
	}

	public void modifierValidationEquipe( Equipe equipe )  {

		Connection			cn		= null;
		CallableStatement	stmt	= null;
		String 				sql;

		try {
			cn = dataSource.getConnection();

			// Modifie la validation de benevole 
			sql = "{ CALL validationEQUIPE_modifier( ?,? ) } ";
			stmt = cn.prepareCall( sql );
			stmt.setObject( 1, equipe.getIdEquipe() );
			stmt.setObject( 2, equipe.getValidation() );
						
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}
}
