package acao;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.NoSuchElementException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Usuario;




public class Login implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String login = request.getParameter("username");
		String senha = request.getParameter("password");
		
		boolean acertouSenha = false;

		String usuarioBanco = "joao";
		BigDecimal senhaBanco = new BigDecimal("120536");
		Long idBanco = new Long(1);
		

		Usuario usuario = new Usuario(usuarioBanco, senhaBanco, idBanco);
		if (login.equals(usuarioBanco) && senhaBanco.toString().equals(senha)) {
			
			acertouSenha = true;
		}
		
		
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("loja");
		
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		if (acertouSenha) {
			
			Usuario usuarioExistente = em.find(Usuario.class, Long.valueOf(usuario.getId()));
			if (usuarioExistente != null) {
				HttpSession sessao = request.getSession();
				sessao.setAttribute("usuarioLogado", usuarioExistente);
				
				return "redirect:entrada?acao=Menu";
				
			} else {
				
				return "redirect:entrada?acao=LoginForm";
			}	
			
		} else {
			
			return "redirect:entrada?acao=LoginForm";
			
		}
		
		
	}

}
