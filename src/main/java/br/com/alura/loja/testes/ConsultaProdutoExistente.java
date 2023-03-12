package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Produto;


public class ConsultaProdutoExistente {
	
	public static void main(String[] args) {
		Produto celular = new Produto("M. pequena", "marmita pequena com o cardapio"
				+ "diario", new Integer("12"));
		
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("loja");
		
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		em.contains(celular);
		em.getTransaction().commit();
		em.close();
	}

}
