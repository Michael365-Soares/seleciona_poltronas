package com.michaelsoares365.gmail.selecao_de_poltronas.modelo;
import java.util.ArrayList;
import java.util.List;

import com.michaelsoares365.gmail.selecao_de_poltronas.excecao.PoltronaReservadaException;

public class Plateia {
    private List<Poltronas> poltronas=new ArrayList<>();
	private List<Usuario> usuarios=new ArrayList<>();
	
	public List<Poltronas> getPoltronas() {
		return poltronas;
	}

	public Plateia() {
    	this.preencherPlateia();
    }
    
    public void preencherPlateia() {
    	int i=0;
    	for(int l=0;l<10;l++) {
    		for(int c=0;c<10;c++) {
    			poltronas.add(new Poltronas(i));
    			i++;
    		}
    	}
    }
    
    public void  selecionarPoltrona(int posicao) {
    	try {
    		if(!this.poltronas.get(posicao).isReservada()) {
    			this.poltronas.get(posicao).reservarPoltrona();
    		}else {
    			throw new PoltronaReservadaException();
    		}
    	}catch(PoltronaReservadaException e) {
    		System.out.println("Poltrona já está reservada!");
    		this.selecionarPoltrona(posicao);
    	}
    }
    
    public String imprimirPlateia() {
       StringBuilder sb=new StringBuilder();
       int cont=0;
       for(int l=0;l<10;l++) {
	       sb.append("\n");
    	   for(int c=0;c<10;c++) {
    		   sb.append(this.poltronas.get(cont).toString());
    		   cont++;
    	   }
       }
       return sb.toString();
    }    
}
