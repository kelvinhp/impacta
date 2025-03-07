package br.com.seniorsolution.jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ModelAndView;

import br.com.seniorsolution.entidades.Escola;
import br.com.seniorsolution.entidades.Usuario;
import br.com.seniorsolution.utils.Utilitarios;

public class JdbcUsuarioDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	//propriedade: dataSource
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void incluirUsuario(Usuario usuario) throws Exception {
		try {
			String sql = "INSERT INTO USUARIO "
					+ "(NOME,SENHA,NIVEL) VALUES (?,?,?)";
			
			this.jdbcTemplate.update(
					sql, 
					usuario.getNome(), 
					usuario.getSenha(), 
					usuario.getNivel());
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Usuario validarUsuario(String nome, String senha) throws Exception {
		Usuario usuario = null;
		try {
			String query = "SELECT * FROM USUARIO WHERE NOME=? AND SENHA=? ";
			usuario = this.jdbcTemplate.queryForObject(
					query, 
					new String[] {nome, senha},
					new UsuarioMapper());
		} catch (Exception e) {
			throw e;
		}
		return usuario;
	}
}
