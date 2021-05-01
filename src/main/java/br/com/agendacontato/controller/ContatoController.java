package br.com.agendacontato.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agendacontato.model.dao.ContatoDao;
import br.com.agendacontato.model.entity.Contato;


@WebServlet(urlPatterns = {"/ContatoController","/main", "/insert"})
public class ContatoController extends HttpServlet {

	private static final long serialVerionUID = 1L;
	private Contato contato;
	private ContatoDao contatoDao;
	public ContatoController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String action = request.getServletPath();
		if(action.equals("/main")) {
			listaContatos(request, response);
		}else if (action.equals("/insert")) {
            novoContatos(request, response);
        }
	}
	
	protected void listaContatos(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.sendRedirect("agenda.jsp");
	}
	protected void novoContatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contato = new Contato(request.getParameter("nome"), request.getParameter("fone"), request.getParameter("email"));
        contato.setObservacao(request.getParameter("observacao"));
        try {
            contatoDao = new ContatoDao();
            contatoDao.create(contato);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("main");
    }
}
