package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	private Connection conn;

	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {

	}

	@Override
	public void update(Seller obj) {

	}

	@Override
	public void deleteById(Integer Id) {
		// TODO Auto- method stub

	}

	/*
	 * Este método busca por um vendedor em um banco de dados por meio de um ID
	 * fornecido como parâmetro. Ele executa uma consulta SQL que seleciona todas as
	 * colunas da tabela "seller" e o nome do departamento associado a esse vendedor
	 * (por meio de uma junção com a tabela "department"), onde o ID do vendedor é
	 * igual ao ID fornecido como parâmetro. Se a consulta retornar algum resultado,
	 * ele cria um objeto Seller com as informações do vendedor e um objeto
	 * Department com as informações do departamento e retorna o objeto Seller. Se a
	 * consulta não retornar nenhum resultado, ele retorna null. O método também
	 * lida com exceções e garante o fechamento seguro do PreparedStatement e do
	 * ResultSet.
	 */
	@Override
	public Seller findById(Integer Id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"" + "SELECT seller.*,department.Name as DepName\r\n" + "FROM seller INNER JOIN department\r\n"
							+ "ON seller.DepartmentId = department.Id\r\n" + "WHERE seller.Id = ?");

			st.setInt(1, Id);
			rs = st.executeQuery();
			if (rs.next()) {
				Department dep = instanciateDepartment(rs);
				Seller obj = intanciateSeller(rs, dep);
				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Seller intanciateSeller(ResultSet rs, Department dep) throws SQLException {
		Seller obj = new Seller();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setBirthDate(rs.getDate("BirthDate"));
		obj.setDepartment(dep);
		return obj;
	}

	private Department instanciateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		return dep;
	}

	@Override
	public List<Seller> findAll() {
		return null;
	}

}
