package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;

import Controle.*;//import do package de controle auxiliar

@WebServlet("/ExcluirCarro")//pagina para confirmar a exclusão de um veiculo
public class ExcluirCarro extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Print Writer para fazer o HTML
		PrintWriter out = response.getWriter();
		Carro carroEx = new Carro();//carro objeto para ser excluido
		//Inicio do HTML
		out.println("<html>");
		//Titulo e cabeçalho
	    out.println("<head>");
	    out.println("<title>Rent A Car</title>");
	    out.println("<link rel='stylesheet' href='estilo.css'>");//link para o CSS
	    out.println("</head>");
	    //CORPO DO HTML
	    out.println("<body>");
	    out.println("<h1>Deseja mesmo excluir o veiculo a baixo?</h1>");
	    //procura o carro pela placa
	    carroEx = Controlador.instancia.getCarro(request.getParameter("placaParam"));
	    out.println(carroEx.getDadosHtml());//imprimi no html as informaçõs do carro
	    //botão para confirmar
	    out.println("<form align='center' method='post' action='CadastrarCarro'>"
	    		+ "<input type='hidden' name='editou' value='ex'/> "
	    		+ "<input type='hidden' name='placaParam' value='"+carroEx.getPlaca()+"'/> "
	    		+ "<input type='submit' value='Excluir' />"
	    		+"</form>");
	  //foi usado o form para os botões para facilitar o envio de informaçãos atraves das paginas
	    out.println("<form align='center' method='post' action='index'><input  type='submit' value='Cancelar'/></form>");
	    
	    //FINAL DO CORPO
	    out.println("</body>");
	    //FINAL DO HTML
	    out.println("</html>");
	    
	}

}
