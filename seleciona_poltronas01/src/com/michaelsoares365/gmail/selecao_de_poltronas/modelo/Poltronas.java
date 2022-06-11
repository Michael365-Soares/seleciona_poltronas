package com.michaelsoares365.gmail.selecao_de_poltronas.modelo;

import com.michaelsoares365.gmail.selecao_de_poltronas.excecao.PoltronaReservadaException;

public class Poltronas {
	private Usuario usuario;
    private  boolean reservada=false;
    private int posicao;
    
    public Poltronas(int posicao) {
    	this.posicao=posicao;
    }
    
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	  public void reservarPoltrona() {
	    	if(!reservada) {
	    		this.reservada=!reservada;
	    	}else {
	        	throw new PoltronaReservadaException();
	    	}
	  }

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	
	public boolean isReservada() {
		return this.reservada;
	}
	
	public String toString() {
		StringBuilder sb=new StringBuilder();
		if(!isReservada()) {
			if(this.posicao<10) { 
  			   sb.append("|R"+this.posicao+"|");
  		   }else {
  		       sb.append("|"+this.posicao+"|");
  		   }  
		}else {
			   sb.append("|**|");
		}
		return sb.toString();
	}
    
}
