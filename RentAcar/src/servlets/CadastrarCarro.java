package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;

import Controle.*;//import do package de controle auxiliar


@WebServlet("/CadastrarCarro")
public class CadastrarCarro extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Print Writer para fazer o HTML
		PrintWriter out = response.getWriter();
		
		//Inicio do HTML
		out.println("<html>");
		//Titulo e cabe�alho
	    out.println("<head>");
	    out.println("<link rel='stylesheet' href='estilo.css'>");//link para o CSS
	    out.println("<title>Rent A Car</title>");
	    out.println("</head>");
	    //CORPO DO HTML
	    out.println("<body>");
	    //verifica se � uma exclus�o
		if(request.getParameter("editou").equals("ex")){
			if(Controlador.instancia.removeCarro(request.getParameter("placaParam"))){
				out.println("<h1>Veiculo excluido com sucesso!.</h1><br/>");//info pro usuario
			}else{
				out.println("<h1>Veiculo n�o excluido, algum erro ocorreu.</h1>");
			}
		}else{//se n�o for uma exclus�o � uma adi��o ou edi��o
			// pegando os par�metros do request
			//carro auxiliar
		    Carro novoCarro = new Carro();
	        novoCarro.setModelo(request.getParameter("modelo"));
	        novoCarro.setAnoFab(Integer.parseInt(request.getParameter("ano")));
	        novoCarro.setCor(request.getParameter("cor"));
	        //concatena a placa em uma �nica string
	        String placaAux =""+ request.getParameter("placa")+ request.getParameter("placaN");
	        novoCarro.setPlaca(placaAux);
	        novoCarro.setChassi(request.getParameter("chassi"));
	        //se for nulo n�o marcou a op��o de automatico
	        if(request.getParameter("auto")!=null){
	        	novoCarro.setAuto(true);
	        }else novoCarro.setAuto(false);
	        
	      //se for sim � uma edi��o
	        if(request.getParameter("editou").equals("sim")){
	        	if(Controlador.instancia.editaCarro(novoCarro)){
	        		out.println("<h1>Cadastro atualizado com sucesso.</h1><br/>");//info pro usuario
	        		out.println(novoCarro.getDadosHtml());//mostra os dados do carro
	        	}else{
	        		out.println("<h1>Cadastro n�o foi atualizado, algum erro ocorreu.</h1>");
	        	}
	        }else{//se n�o � nem "ex" e nem "sim" � um cadastro novo
	        	if(Controlador.instancia.addCarro(novoCarro)){
	    			out.println("<h1>Cadastro realizado com sucesso.</h1><br/>");//info pro usuario
	    			out.println(novoCarro.getDadosHtml());//mostra os dados do carro
	    		}else{
	    			out.println("<h1>Cadastro n�o efetuado, algum erro ocorreu.</h1>");
	    		}
	        }
		}
	    
        
	    //Cadastrar outro veiculo, voltar
	    out.println("<br/><br/><br/><h2>O que deseja fazer em seguida?.</h2>");
	    //foi usado o form para os bot�es para facilitar o envio de informa��os atraves das paginas
	    out.println("<form align='center' method='post' action='CadastroDeVeiculo.html'><input  type='submit' value='Cadastrar Outro Carro'/></form>");
	    out.println("<form align='center' method='post' action='index'><input  type='submit' value='Voltar para a pagina inicial'/></form>");
	    
	    //FINAL DO CORPO
	    out.println("</body>");
	    //FINAL DO HTML
	    out.println("</html>");
				
	}
}
