package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controle.*;//import do package de controle auxiliar

@WebServlet("/index")
public class IndexServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Print Writer para fazer o HTML
		PrintWriter out = response.getWriter();
		//string para crriar uma tabela
		String tabela = new String();
		
		//Inicio do HTML
		out.println("<html>");
		//Titulo e cabeçalho
	    out.println("<head>");
	    out.println("<title>Rent A Car</title>");
	    out.println("<link rel='stylesheet' href='estilo.css'>");//link para o CSS
	    out.println("</head>");
	    //CORPO DO HTML
	    out.println("<body>");
	    out.println("<h1>Seja bem vimdo ao RentAcar.</h1>");
	    out.println("<h3>Seu aluguel de carros preferido!</h3>");
	    
	    out.println("<h2>Nossa lista de veiculos, prontos para locação.</h2><br/><br/><br/>");
	    //lista de todos os carros em uma tabela 
	    tabela = "<table style='width:60%' align='center'> " //Campos
	    		+ "<tr>"
	    		+ 	"<th align='left'>Modelo</th>"
	    		+ 	"<th align='left'>Ano</th>"
	    		+ 	"<th align='left'>Cor</th>"
	    		+ 	"<th align='left'>Placa</th>"
	    		+ 	"<th align='left'>Automático</th>"
	    		+ 	"<th align='left' colspan='2'>Opções</th>"
	    		+ "</tr>";
	    
	    //criando a tabela com todos os carros
	    for (Carro carro : Controlador.instancia.getCarros()) {
	    	//string temp para imprimir sim ou não no atributo automatico
	    	String temp = "NÃO";
	    	if (carro.isAuto()) temp = "SIM";
	    	//corpo da tabela
			tabela+="<tr>"
					+ "<td>"+carro.getModelo()+"</td>"
					+ "<td>"+carro.getAnoFab()+"</td>"
					+ "<td>"+carro.getCor()+"</td>"
					+ "<td>"+carro.getPlaca()+"</td>"
					+ "<td>"+temp+"</td>"
					//Criando botoes para editar e excluir dentro da tabela
					//cada botão terá armazenado dentro do form a placa do carro
					//com a placa será possivel editar e ou excluir corretamente o carro correto 
					+ "<td><form method='post' action='EditarCarro'><input type='hidden' name='placaParam' value='"+carro.getPlaca()+"' /><input type='submit' value='Editar'/></form></td>"
					+ "<td><form method='post' action='ExcluirCarro'><input type='hidden' name='placaParam' value='"+carro.getPlaca()+"' /><input type='submit' value='Excluir'/></form></td>"
					+ "</tr>";
		}
	    
	    tabela+= "</table>";//fecha a tabela
	    out.print(tabela);//emprime a tabela no HTML
	    
	    //parte para cadastro de novos veiculos
	    out.println("<br/><br/><br/><h2>Cadastros de novos Veiculos.</h2>");
	    //foi usado o form para os botões para facilitar o envio de informaçãos atraves das paginas
	    out.println("<form align='center' method='post' action='CadastroDeVeiculo.html'><input  type='submit' value='Cadastrar Novo Carro'/></form>");
	    
	    out.println("<br/><br/><br/><h3>Feito por edubeziaco@gmail.com</h3>");//creditos
	    //FINAL DO CORPO
	    out.println("</body>");
	    //FINAL DO HTML
	    out.println("</html>");
	    
	}
}
