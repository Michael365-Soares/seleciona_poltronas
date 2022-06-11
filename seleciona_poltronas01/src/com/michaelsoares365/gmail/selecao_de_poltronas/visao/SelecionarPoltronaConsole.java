package com.michaelsoares365.gmail.selecao_de_poltronas.visao;

import java.util.List;
import java.util.Scanner;

import com.michaelsoares365.gmail.selecao_de_poltronas.excecao.FinalizarException;
import com.michaelsoares365.gmail.selecao_de_poltronas.modelo.Bilhete;
import com.michaelsoares365.gmail.selecao_de_poltronas.modelo.Plateia;
import com.michaelsoares365.gmail.selecao_de_poltronas.modelo.Poltronas;
import com.michaelsoares365.gmail.selecao_de_poltronas.modelo.Usuario;

public class SelecionarPoltronaConsole {
	Plateia plateia;
	Bilhete bilhete=new Bilhete();
	Scanner entrada=new Scanner(System.in);
	private Usuario usuario=new Usuario();
	
	public SelecionarPoltronaConsole(Plateia plateia) {
		this.plateia=plateia;
		cadastrarUsuario();
	}

	public void cadastrarUsuario() {
		boolean continuar=true;
		do {
			this.usuario.setNome(this.capturarValorDigitado("Digite seu nome:"));
			this.usuario.setIdade(Integer.parseInt(this.capturarValorDigitado("Digite sua idade")));
			  try {
				  System.out.println(this.plateia.imprimirPlateia());
				  String posicaoTxt=this.capturarValorDigitado("Digite a posição da poltrona a qual deseja selecionar:");
				  this.plateia.selecionarPoltrona(Integer.parseInt(posicaoTxt));
				  this.usuario.setPoltronas(this.plateia.getPoltronas().get(Integer.parseInt(posicaoTxt)));
				  this.bilhete.setUsuario(this.usuario);
				  this.bilhete.setPoltrona(this.plateia.getPoltronas().get(Integer.parseInt(posicaoTxt)));
				  this.usuario.setBilhete(bilhete);
				  throw new FinalizarException();
			  }catch(FinalizarException e) {
				  System.out.println(this.plateia.imprimirPlateia());
				  System.out.println(this.usuario.getBilhete().toString());
			  }finally {
				  String res=this.capturarValorDigitado("Deseja realizar nova seleção(S|N)");
				  if("n".equalsIgnoreCase(res)) {
					  continuar=false;
				  }
			  }
		}while(continuar);
	}
	
	public String capturarValorDigitado(String txt) {
		System.out.println(txt);
		String valorDigitado=entrada.nextLine();
		return valorDigitado;
	}
}
