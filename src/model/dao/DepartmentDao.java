package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {

	/*
	 * Método vai inserir no banco de dados o obj que enviar como parametro de
	 * entrada
	 */
	void insert(Department obj);

	// Método para fazer update
	void update(Department obj);

	// Método para apagar
	void deleteById(Integer Id);

	// Operação responsaval para pegar o Id e consultar no banco de dados o obj com
	// esse Id, se existir retorna e se não retorna nulo
	Department findById(Integer Id);

	// Retoranar todos os departamentos
	List<Department> findAll();

}
