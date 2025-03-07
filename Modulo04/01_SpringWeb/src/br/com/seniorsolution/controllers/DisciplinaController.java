package br.com.seniorsolution.controllers;

import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.seniorsolution.entidades.Curso;
import br.com.seniorsolution.entidades.Disciplina;
import br.com.seniorsolution.jdbc.JdbcCursoDao;
import br.com.seniorsolution.jdbc.JdbcDisciplinaDao;

@Controller
public class DisciplinaController {

	@RequestMapping("/disciplina/cadastro")
	public String incluir(@RequestParam("id") int idcurso, ModelMap model) {
		
		try {
			model.addAttribute("idcurso", idcurso);
			return "cadastros/incluirDisciplina";
			
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return "paginas/erro";
			
		}
	}
	
	@RequestMapping(value="/caddisciplina", method=RequestMethod.POST)
	public String incluir(@RequestParam("idcurso") int idcurso, 
			 		      @Valid Disciplina disciplina,
			 		      BindingResult result,
			 		      ModelMap model) {
		
		if(result.hasErrors()) {
			return "forward:/disciplina/cadastro";
		}
		try {
			ApplicationContext ctx = 
					new ClassPathXmlApplicationContext("beanJdbc.xml");
			JdbcCursoDao dao = (JdbcCursoDao) ctx.getBean("jdbcCursoDao");
			Curso curso = dao.buscarCurso(idcurso);
			disciplina.setCurso(curso);
			
			JdbcDisciplinaDao daod = (JdbcDisciplinaDao) ctx.getBean("jdbcDisciplinaDao");
			daod.incluirDisciplina(disciplina);
			
			model.addAttribute("mensagem", "Disciplina " 
					+ curso.getDescricao() + " inclu�da.");
			
			
			return "paginas/sucesso";			
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return "paginas/erro";
		}
	}
	
	@RequestMapping("/disciplina/remover")
	public String remover(@RequestParam("id") int id, ModelMap model) {
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("beanJdbc.xml");
			
			JdbcDisciplinaDao dao = (JdbcDisciplinaDao) ctx.getBean("jdbcDisciplinaDao");
			
			Disciplina disciplina = dao.buscarDisciplina(id);
			
			dao.remover(disciplina);
			
			model.addAttribute("mensagem", "Disciplina " 
					+ disciplina.getDescricao() + " removida.");
			
			
			return "paginas/sucesso";	
			
		} catch (Exception e) {
			// TODO: handle exception
			
			model.addAttribute("mensagem", e.getMessage());
			
			
			return "paginas/erro";	
		}
	}
}
