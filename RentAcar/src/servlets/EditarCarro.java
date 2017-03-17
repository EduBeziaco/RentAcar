package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import Controle.*;//import do package de controle auxiliar

@WebServlet("/EditarCarro")
public class EditarCarro extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Print Writer para fazer o HTML
		PrintWriter out = response.getWriter();
		
		//Inicio do HTML
		out.println("<html>");
		//Titulo e cabeçalho
	    out.println("<head>");
	    out.println("<title>Rent A Car</title>");
	    out.println("<link rel='stylesheet' href='estilo.css'>");
	    out.println("</head>");
	    //CORPO DO HTML
	    out.println("<body>");
	    out.println("<h1>Editar Veiculo</h1><br/>"
	    		+ "<h2>Altere o formulario a baixo.</h2><br/>");
	    //pega a instancia do carro que possua a placa do botão do index
	    Carro carro = Controlador.instancia.getCarro(request.getParameter("placaParam"));
	    
	    //formulario em string para facilitar
	    String formAux = "<form align='center' method='post' action='CadastrarCarro'>"+
	      "Modelo: <input type='text' name='modelo' required pattern='([A-z0-9\\s]){2,}' value='"+carro.getModelo()+"' /><br />"+
	      "Ano de Fabricação:  <input type='number' name='ano' min='2000' max='2017' value='"+carro.getAnoFab()+"'><br />"+
	      "Cor: <input type='text' name='cor' required pattern='([A-z\\s]){2,}' value='"+carro.getCor()+"'/><br />"+
	      "Placa: (Apenas 3 Letras MAIUSCULAS e apenas 4 Digitos!) Não pode ser Editada! "+
	      //input com a tag readonly, a placa não pode ser alterada
	      "<br/>Letras <input readonly type='text' name='placa' required pattern='(?=.*[A-Z]){3}' value='"+carro.getPlaca().substring(0, 3)+"' /> "
	      		+ "<br/> Numeros <input readonly type='text' name='placaN' required pattern='[0-9]{4}' value='"+carro.getPlaca().substring(3, 7)+"' /><br/>";
	      //marcar se o carro é automatico ou não com a tag checked
		    if(carro.isAuto()){
		    	 formAux+= "Automatico : <input type='checkbox' name='auto' checked> <br/>"; 
		      }else {
		    	  formAux+= "Automatico : <input type='checkbox' name='auto'> <br/>"; 
		      }
	      
	      formAux+="Chassi: (Precisa conter os 17 Characteres.)"+
	      "<br/><input type='text' name='chassi' required pattern='([A-z0-9]){17}' value='"+carro.getChassi()+"'/><br />"+
	      "<input type='hidden' name='editou' value='sim'/>"+
	      "<input type='submit' value='Atualizar' />"+
	    "</form>";
	    
	    out.println(formAux);
	    //FINAL DO CORPO
	    out.println("</body>");
	    //FINAL DO HTML
	    out.println("</html>");	    
				
	}

}
