package model.dao;

import java.util.List;

import model.entities.Seller;

public interface SellerDao {

	/*
	 * Método vai inserir no banco de dados o obj que enviar como parametro de
	 * entrada
	 */
	void insert(Seller obj);

	// Método para fazer update
	void update(Seller obj);

	// Método para apagar
	void deleteById(Integer Id);

	// Operação responsaval para pegar o Id e consultar no banco de dados o obj com
	// esse Id, se existir retorna e se não retorna nulo
	Seller findById(Integer Id);

	// Retoranar todos os departamentos
	List<Seller> findAll();
}
