package com.uca.capas.parcial2.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(schema= "public", name="cat_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="c_categoria")
	private Integer ccategoria;
	
	@Size(max = 50, message = "no puede exceder 50 caracteres")
	@NotBlank(message = "El campo nombre categoría no puede estar vacío")
	@Column(name="s_categoria")
	private String scategoria;
	
	
	
	public Categoria() {
		
	}
	
	public Integer getCcategoria() {
		return ccategoria;
	}
	
	public void setCcategoria(Integer ccategoria) {
		this.ccategoria = ccategoria;
	}
	public String getScategoria() {
		return scategoria;
	}
	public void setScategoria(String scategoria) {
		this.scategoria = scategoria;
	}

	
	
	
	


	
}
