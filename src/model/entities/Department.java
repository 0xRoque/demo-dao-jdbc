package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Department implements Serializable {

	// Implementar Serializable(Transformar obj em sequência de bite

	private static final long serialVersionUID = 1L;

	// Atributos

	private Integer id;
	private String name;

	// Construtores
	public Department() {
	}

	public Department(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	// Getters/Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	// Gerar Hashcode e Equals para comparar obj pelo conteúdo

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(id, other.id);
	}

	// toString padrão
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

}
