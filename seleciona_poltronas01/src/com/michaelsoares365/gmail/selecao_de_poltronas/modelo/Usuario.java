package com.michaelsoares365.gmail.selecao_de_poltronas.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
    private int idade;
	@Transient
    private List<Poltronas> poltronas=new ArrayList<>();
	@Transient
    private Bilhete bilhete;
    
    public Usuario() {}
    public Usuario(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public List<Poltronas> getPoltronas() {
		return poltronas;
	}

	public void setPoltronas(Poltronas poltronas) {
		this.poltronas.add(poltronas);
	}

	public Bilhete getBilhete() {
		return bilhete;
	}

	public void setBilhete(Bilhete bilhete) {
		this.bilhete = bilhete;
	}

	public String getNome() {
		return nome;
	}
    
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
}
