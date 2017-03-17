package Controle;
import java.util.ArrayList;


public class Controlador {
	//Classe criada para "simular" um BD, apenas um local aonde eu posso manter meus dados ao longo da execução
	private ArrayList<Carro> carros;//arraylist pra armazenar um número qualquer de carros
	/*
	 * Instancia do proprio objeto dentro da classe, me permite criar uma especie de persistencia entre as telas
	 */
	public static Controlador instancia = new Controlador(); 
	public Controlador() {
		// TODO Auto-generated constructor stub
		if(carros==null){//verifica so por segurança se já foi criado uma instancia do objeto Controlador e sempre haverá apenas uma
			carros = new ArrayList<>();//inicialização da lista
			carros.add(new Carro());//o primeiro carro da lista sempre será o default
			//adicionando outros dois carros para testes
			carros.add(new Carro("AAA0001", "12345678901234567", "Uno", "Vermelho", 2012, false));
			carros.add(new Carro("AAA0002", "09876543210987654", "Civic", "Prata", 2015, true));
			instancia = this;
		}
	}
	
	//função para add um carro novo a minha lista
	public boolean addCarro(Carro carroNovo){
		for (Carro carro : carros) {
			//verificamos aqui mesmo para saber se a placa é única
			if(carro.getPlaca().equals(carroNovo.getPlaca())){
				//retorna falso pois a placa já existe
				return false;
			}
		}
		//se for única, add o novo carro para a lista
		carros.add(carroNovo);
		//retorno true caso for sucesso
		return true;
	}
	
	//função para remover um carro da minha lista
	public boolean removeCarro(String placa){
		for (Carro carro : carros) {
			//procuramos na lista pela placa do carro
			if(carro.getPlaca().equals(placa)){
				//se achou oficializa a exclusão
				carros.remove(carro);
				//retorna true pois achamos a placa e excluimos o carro
				return true;
			}
		}
		//retorno falso se não achou a placa e alguma coisa deu errado
		return false;
	}
	
	//função para editar um carro, irá receber um objeto carro já pronto
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
				
				//retorna true, a atualização já foi feita
				return true;
			}
		}
		//retorno falso se não achou a placa e algo deu errado
		return false;
	}
	
	//função que procura um carro pela placa
	public Carro getCarro(String placa){
		for (Carro carro : carros) {
			//procuramos na lista pela placa do carro
			if(carro.getPlaca().equals(placa)){
				//retorna o carro achado pela placa
				return carro;
			}
		}
		//se não achar retorna null
		return null;
	}
	
	//retorna a lista inteira de carros(não foi nescessário)
	public ArrayList<Carro> getCarros() {
		return carros;
	}
	
}
