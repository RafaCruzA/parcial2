package com.uca.capas.parcial2.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;



@Entity
@Table(schema="public", name = "cat_libro")
public class Libro {
	
	@Id
	@NotNull
	@GeneratedValue(generator="cat_libro_c_libro_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "cat_libro_c_libro_seq", sequenceName = "public.cat_libro_c_libro_seq")
	@Column(name="c_libro")
	private Integer clibro;
	
	@Column(name="s_titulo")
	private String stitulo;
	
	@Column(name="s_autor")
	private String sautor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="c_categoria")
	private Categoria categoria;
	
	@Transient
	private Integer ccategoria;
	
	@Column(name="f_ingreso")
	private Date fingreso;
	
	@Column(name="b_estado")
	private Boolean bestado;
	
	
	public Integer getClibro() {
		return clibro;
	}
	public void setClibro(Integer clibro) {
		this.clibro = clibro;
	}
	public String getStitulo() {
		return stitulo;
	}
	public void setStitulo(String stitulo) {
		this.stitulo = stitulo;
	}
	public String getSautor() {
		return sautor;
	}
	public void setSautor(String sautor) {
		this.sautor = sautor;
	}
	public Integer getCcategoria() {
		return ccategoria;
	}
	public void setCcategoria(Integer ccategoria) {
		this.ccategoria = ccategoria;
	}
	public Date getFingreso() {
		return fingreso;
	}
	public void setFingreso(Date fingreso) {
		this.fingreso = fingreso;
	}
	public Boolean getBestado() {
		return bestado;
	}
	public void setBestado(Boolean bestado) {
		this.bestado = bestado;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String getEstadoDelegate(){
		if(this.bestado == null){
			return "";
		}
		else{
			if(this.bestado) return "ACTIVO";
			else return "INACTIVO";
		}
	}

}
