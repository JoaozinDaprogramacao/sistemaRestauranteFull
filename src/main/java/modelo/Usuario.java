package modelo;


import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private BigDecimal senha;
	
	public Usuario(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Usuario(String login, BigDecimal senha) {
		this.login = login;
		this.senha = senha;
	}
	
	public Usuario(String login, BigDecimal senha, Long id) {
		this.login = login;
		this.senha = senha;
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public BigDecimal getSenha() {
		return senha;
	}

	public void setSenha(BigDecimal senha) {
		this.senha = senha;
	}
	
}
