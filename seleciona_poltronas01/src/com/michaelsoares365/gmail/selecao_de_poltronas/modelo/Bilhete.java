package com.michaelsoares365.gmail.selecao_de_poltronas.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Bilhete {
     private Usuario usuario;
     private List<Poltronas> poltronas=new ArrayList<>();
     
    Function<Poltronas,Integer> posicoes=(p)->{return p.getPosicao();};
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Poltronas> getPoltrona() {
		return poltronas;
	}
	
	public void setPoltrona(Poltronas poltrona) {
		this.poltronas.add(poltrona);
	}
     
    public String toString() {
    	StringBuilder sb=new StringBuilder();
    	sb.append("==============================================\n");
    	sb.append("=    Nome:"+this.usuario.getNome()+" =========\n");
    	sb.append("=    Poltrona(s): "+this.poltronas.stream().map(this.posicoes).findFirst().get()+"- =========\n");
    	sb.append("=                               =============\n");
    	sb.append("=                               =============\n");
    	sb.append("=============================================\n");
    	return sb.toString();
    }
}
