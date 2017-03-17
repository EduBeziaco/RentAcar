package Controle;

public class Carro {
	//classe Carro 
	private String placa; //placa como string dever� ser �nica
	private String chassi;//Chassi para o seguro do veiculo
	private String modelo;//Modelo para o cliente poder escolher
	private String cor;//Cor para o cliente escolher tamb�m
	private int anoFab;//Ano de fabrica��o para o seguro
	private boolean auto;//Se o carro for automatico ou n�o (false = n�o)
	
	public Carro() {
		// TODO Auto-generated constructor stub
		//um construtor default
		setPlaca("AAA0000");
		setChassi("000A000B000C000D0");
		setModelo("Fusca");
		setCor("Beje");
		setAnoFab(1990);
		setAuto(false);
	}
	
	//um construtor que possua todos os dados do carro
	public Carro(String placa, String chassi, String modelo, String cor, int anoFab, boolean auto) {
		// TODO Auto-generated constructor stub
		setPlaca(placa);
		setChassi(chassi);
		setModelo(modelo);
		setCor(cor);
		setAnoFab(anoFab);
		setAuto(auto);
	}
	
	//fun��o que devolve uma String com uma tabela em html pronta 
	public String getDadosHtml(){
		String tabela = new String();
		tabela = "<table style='width:60%' align='center'> " //Campos
	    		+ "<tr>"
	    		+ 	"<th align='left'>Modelo</th>"
	    		+ 	"<th align='left'>Ano</th>"
	    		+ 	"<th align='left'>Cor</th>"
	    		+ 	"<th align='left'>Placa</th>"
	    		+ 	"<th align='left'>Autom�tico</th>"
	    		+ 	"<th align='left'>Chassi</th>"
	    		+ "</tr>";
	    //informa��es
    	String temp = "N�O";
    	if (isAuto()) temp = "SIM";
		tabela+="<tr>"
				+ "<td>"+getModelo()+"</td>"
				+ "<td>"+getAnoFab()+"</td>"
				+ "<td>"+getCor()+"</td>"
				+ "<td>"+getPlaca()+"</td>"
				+ "<td>"+temp+"</td>"
				+ "<td>"+getChassi()+"</td>"
				+ "</tr>";
	    tabela+= "</table>";//fecha a tabela
	    return tabela;
	}
	
	//conjunto de getters e setters dos atributos da classe Carro
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public int getAnoFab() {
		return anoFab;
	}
	public void setAnoFab(int anoFab) {
		this.anoFab = anoFab;
	}
	public boolean isAuto() {
		return auto;
	}
	public void setAuto(boolean auto) {
		this.auto = auto;
	}
	
	

}
