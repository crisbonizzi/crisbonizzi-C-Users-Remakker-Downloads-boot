
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Compra {

	// Atributos

	private Integer id;
	private double valor;
	private LocalDate data;
	private String qtd_itens;

	private Cliente_Cadastro cliente_cadastro;
	private Pacote_Viagem pacote_viagem;
	private Passagens passagens;

	private List<Compra> itens = new ArrayList<Compra>();

	// classe responsavel por formatar um padrao diferente do formato ISO
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	// Construtores

	public Compra() {

	}

	public Compra(int id, double valor, String data, String qtd_itens, Cliente_Cadastro cliente_cadastro,
			Pacote_Viagem pacote_viagem, Passagens passagens) {

		this.id = id;
		
		// convertendo data do tipo String ("dd/MM/yyyy") para LocalDate (yyyy-MM-dd)

		this.data = LocalDate.parse(data, formatter);
		
		this.valor = valor;
		this.qtd_itens = qtd_itens;
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

	public double getValor() {
		return valor();
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	// convertendo data do tipo LocalDate (yyyy-MM-dd) para String (dd/MM/yyyy)

	public String getData() {
		return formatter.format(data);
	}

	public void setData(String data) {
		this.data = LocalDate.parse(data, formatter);
	}

	public String getQtd_itens() {
		return qtd_itens;
	}

	public void setQtd_itens(String qtd_itens) {
		this.qtd_itens = qtd_itens;
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
		return "Compra [id=" + id + ", data=" + data + ", valor=" + valor + ", qtd_itens=" + qtd_itens
				+ " cliente_cadastro=" + cliente_cadastro + ", pacote_viagem=" + pacote_viagem + ", passagens="
				+ passagens + "]";
	}

	public double valor() {
		for (int i = 0; i < itens.size(); i++) {
			this.valor += itens.get(i).getValor();
		}
		return this.valor;
	}
}
