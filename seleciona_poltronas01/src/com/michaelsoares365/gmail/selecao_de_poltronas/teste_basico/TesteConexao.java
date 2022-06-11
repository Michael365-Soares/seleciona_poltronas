package com.michaelsoares365.gmail.selecao_de_poltronas.teste_basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.michaelsoares365.gmail.selecao_de_poltronas.modelo.Usuario;

public class TesteConexao {
   public static void main(String[] args) {
	   EntityManagerFactory emf=Persistence.createEntityManagerFactory("seleciona_poltronas");
	   EntityManager em=emf.createEntityManager();
	   Usuario user=new Usuario("Michael Soares",27);
	   em.getTransaction().begin();
	   em.persist(user);
	   em.getTransaction().commit();
	   em.close();
	   emf.close();
   }
}
