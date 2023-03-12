package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Produto;
import modelo.Usuario;


public class ConsultaUsuarioExistente {
	
	public static void main(String[] args) {
		Usuario usuario = new Usuario("joao", new BigDecimal("120536"), new Long(1));
		
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("loja");
		
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		Usuario usuarioExistente = em.find(Usuario.class, Long.valueOf(usuario.getId()));

		if (usuarioExistente != null) {
		    System.out.println("nome do usuario: " + usuarioExistente.getLogin());
		} else {
		    System.out.println("Deu errado AAAAAAAA");
		}

		em.getTransaction().commit();
		em.close();
	}

}
