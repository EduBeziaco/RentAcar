package Controle;
import java.util.ArrayList;


public class Controlador {
	//Classe criada para "simular" um BD, apenas um local aonde eu posso manter meus dados ao longo da execu��o
	private ArrayList<Carro> carros;//arraylist pra armazenar um n�mero qualquer de carros
	/*
	 * Instancia do proprio objeto dentro da classe, me permite criar uma especie de persistencia entre as telas
	 */
	public static Controlador instancia = new Controlador(); 
	public Controlador() {
		// TODO Auto-generated constructor stub
		if(carros==null){//verifica so por seguran�a se j� foi criado uma instancia do objeto Controlador e sempre haver� apenas uma
			carros = new ArrayList<>();//inicializa��o da lista
			carros.add(new Carro());//o primeiro carro da lista sempre ser� o default
			//adicionando outros dois carros para testes
			carros.add(new Carro("AAA0001", "12345678901234567", "Uno", "Vermelho", 2012, false));
			carros.add(new Carro("AAA0002", "09876543210987654", "Civic", "Prata", 2015, true));
			instancia = this;
		}
	}
	
	//fun��o para add um carro novo a minha lista
	public boolean addCarro(Carro carroNovo){
		for (Carro carro : carros) {
			//verificamos aqui mesmo para saber se a placa � �nica
			if(carro.getPlaca().equals(carroNovo.getPlaca())){
				//retorna falso pois a placa j� existe
				return false;
			}
		}
		//se for �nica, add o novo carro para a lista
		carros.add(carroNovo);
		//retorno true caso for sucesso
		return true;
	}
	
	//fun��o para remover um carro da minha lista
	public boolean removeCarro(String placa){
		for (Carro carro : carros) {
			//procuramos na lista pela placa do carro
			if(carro.getPlaca().equals(placa)){
				//se achou oficializa a exclus�o
				carros.remove(carro);
				//retorna true pois achamos a placa e excluimos o carro
				return true;
			}
		}
		//retorno falso se n�o achou a placa e alguma coisa deu errado
		return false;
	}
	
	//fun��o para editar um carro, ir� receber um objeto carro j� pronto
	public boolean editaCarro(Carro carroEditado){
		for (Carro carro : carros) {
			//procuramos pelo carro correto
			if(carro.getPlaca().equals(carroEditado.getPlaca())){
				carro.setModelo(carroEditado.getModelo());
				carro.setPlaca(carroEditado.getPlaca());
				carro.setCor(carroEditado.getCor());
				carro.setChassi(carroEditado.getChassi());
				carro.setAuto(carroEditado.isAuto());
				carro.setAnoFab(carroEditado.getAnoFab());
				//carros.remove(carro);
				//addCarro(carroEditado);
				
				//retorna true, a atualiza��o j� foi feita
				return true;
			}
		}
		//retorno falso se n�o achou a placa e algo deu errado
		return false;
	}
	
	//fun��o que procura um carro pela placa
	public Carro getCarro(String placa){
		for (Carro carro : carros) {
			//procuramos na lista pela placa do carro
			if(carro.getPlaca().equals(placa)){
				//retorna o carro achado pela placa
				return carro;
			}
		}
		//se n�o achar retorna null
		return null;
	}
	
	//retorna a lista inteira de carros(n�o foi nescess�rio)
	public ArrayList<Carro> getCarros() {
		return carros;
	}
	
}
