
import java.util.ArrayList;
import java.util.List;



public class Compra {

	// Atributos

	private Integer id;
	private double valor_compra;
	private String  data_compra;
	private String qtd_itens_compra;

	private Cliente_Cadastro cliente_cadastro;
	private Pacote_Viagem pacote_viagem;
	private Passagens passagens;

	private List<Compra> itens = new ArrayList<Compra>();


	// Construtores

	public Compra() {

	}

	public Compra(int id, double valor_compra, String data_compra, String qtd_itens_compra, Cliente_Cadastro cliente_cadastro,
			Pacote_Viagem pacote_viagem, Passagens passagens) {

		this.id = id;
		this.data_compra = data_compra;
		this.valor_compra = valor_compra;
		this.qtd_itens_compra = qtd_itens_compra;
		this.cliente_cadastro = cliente_cadastro;
		this.pacote_viagem = pacote_viagem;
		this.passagens = passagens;
	}

	// Getters e Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getValor_compra() {
		return valor();
	}

	public void setValor(double valor) {
		this.valor_compra = valor;
	}

	// convertendo data do tipo LocalDate (yyyy-MM-dd) para String (dd/MM/yyyy)

	public String getData_compra() {
		return data_compra;
	}

	public void setData(String data_compra) {
		this.data_compra = data_compra;
	}

	public String getQtd_itens() {
		return qtd_itens_compra;
	}

	public void setQtd_itens(String qtd_itens) {
		this.qtd_itens_compra = qtd_itens;
	}

	public Cliente_Cadastro getCliente_Cadastro() {
		return cliente_cadastro;
	}

	public void setCliente_Cadastro(Cliente_Cadastro cliente_cadastro) {
		this.cliente_cadastro = cliente_cadastro;
	}

	public Pacote_Viagem getPacote_Viagem() {
		return pacote_viagem;
	}

	public void setPacote_Viagem(Pacote_Viagem pacote_viagem) {
		this.pacote_viagem = pacote_viagem;
	}

	public Passagens getPassagens() {
		return passagens;
	}

	public void setPassagens(Passagens passagens) {
		this.passagens = passagens;
	}

	// Metodo mostrar

	@Override

	public String toString() {
		return "Compra [id=" + id + ", data=" + data_compra + ", valor=" + valor_compra + ", qtd_iten=" + qtd_itens_compra
				+ " cliente_cadastro=" + cliente_cadastro + ", pacote_viagem=" + pacote_viagem + ", passagens="
				+ passagens + "]";
	}

	public double valor() {
		for (int i = 0; i < itens.size(); i++) {
			this.valor_compra += itens.get(i).getValor_compra();
		}
		return this.valor_compra;
		
		
	}
}
