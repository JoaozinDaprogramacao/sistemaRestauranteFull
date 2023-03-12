package acao;

import java.io.IOException;
import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;

public class LoginForm implements Acao {


	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		return "forward:index.html";
	
	}

	
	
}
