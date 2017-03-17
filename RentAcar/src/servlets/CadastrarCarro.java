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
		//Titulo e cabeçalho
	    out.println("<head>");
	    out.println("<link rel='stylesheet' href='estilo.css'>");//link para o CSS
	    out.println("<title>Rent A Car</title>");
	    out.println("</head>");
	    //CORPO DO HTML
	    out.println("<body>");
	    //verifica se é uma exclusão
		if(request.getParameter("editou").equals("ex")){
			if(Controlador.instancia.removeCarro(request.getParameter("placaParam"))){
				out.println("<h1>Veiculo excluido com sucesso!.</h1><br/>");//info pro usuario
			}else{
				out.println("<h1>Veiculo não excluido, algum erro ocorreu.</h1>");
			}
		}else{//se não for uma exclusão é uma adição ou edição
			// pegando os parâmetros do request
			//carro auxiliar
		    Carro novoCarro = new Carro();
	        novoCarro.setModelo(request.getParameter("modelo"));
	        novoCarro.setAnoFab(Integer.parseInt(request.getParameter("ano")));
	        novoCarro.setCor(request.getParameter("cor"));
	        //concatena a placa em uma única string
	        String placaAux =""+ request.getParameter("placa")+ request.getParameter("placaN");
	        novoCarro.setPlaca(placaAux);
	        novoCarro.setChassi(request.getParameter("chassi"));
	        //se for nulo não marcou a opção de automatico
	        if(request.getParameter("auto")!=null){
	        	novoCarro.setAuto(true);
	        }else novoCarro.setAuto(false);
	        
	      //se for sim é uma edição
	        if(request.getParameter("editou").equals("sim")){
	        	if(Controlador.instancia.editaCarro(novoCarro)){
	        		out.println("<h1>Cadastro atualizado com sucesso.</h1><br/>");//info pro usuario
	        		out.println(novoCarro.getDadosHtml());//mostra os dados do carro
	        	}else{
	        		out.println("<h1>Cadastro não foi atualizado, algum erro ocorreu.</h1>");
	        	}
	        }else{//se não é nem "ex" e nem "sim" é um cadastro novo
	        	if(Controlador.instancia.addCarro(novoCarro)){
	    			out.println("<h1>Cadastro realizado com sucesso.</h1><br/>");//info pro usuario
	    			out.println(novoCarro.getDadosHtml());//mostra os dados do carro
	    		}else{
	    			out.println("<h1>Cadastro não efetuado, algum erro ocorreu.</h1>");
	    		}
	        }
		}
	    
        
	    //Cadastrar outro veiculo, voltar
	    out.println("<br/><br/><br/><h2>O que deseja fazer em seguida?.</h2>");
	    //foi usado o form para os botões para facilitar o envio de informaçãos atraves das paginas
	    out.println("<form align='center' method='post' action='CadastroDeVeiculo.html'><input  type='submit' value='Cadastrar Outro Carro'/></form>");
	    out.println("<form align='center' method='post' action='index'><input  type='submit' value='Voltar para a pagina inicial'/></form>");
	    
	    //FINAL DO CORPO
	    out.println("</body>");
	    //FINAL DO HTML
	    out.println("</html>");
				
	}
}
