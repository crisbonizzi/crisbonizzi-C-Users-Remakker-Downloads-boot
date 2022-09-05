
public class Passagens {

	private Integer id;

	private double preco_passagem;

	private String data_ida_passagem;

	private String data_volta_passagem;

	private String origem_passagem;

	private Compra compra;

	private Destino destino;

	private Pacote_Viagem pacote_viagem;

	// Contrutores
	public Passagens() {

	}

	public Passagens(int id, double preco_passagem, String data_ida_passagem, String data_volta_passagem,
			String origem_passagem, Compra compra, Destino destino, Pacote_Viagem pacote_viagem) {
		this.id = id;
		this.preco_passagem = preco_passagem;
		this.data_ida_passagem = data_ida_passagem;
		this.data_volta_passagem = data_volta_passagem;
		this.origem_passagem = origem_passagem;
		this.compra = compra;
		this.destino = destino;
		this.pacote_viagem = pacote_viagem;
	}

	// Gettters e Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getPreco_passagem() {
		return preco_passagem;
	}

	public void setPreco(double preco) {
		this.preco_passagem = preco;
	}

	public String getData_ida_passagem() {
		return data_ida_passagem;
	}

	public void setData_ida_passagem(String data_ida_passagem) {
		this.data_ida_passagem = data_ida_passagem;
	}

	public String getData_volta_passagem() {
		return data_volta_passagem;
	}

	public void setData_volta_passagem(String data_volta_passagem) {
		this.data_volta_passagem = data_volta_passagem;
	}

	public String getOrigem_passagem() {
		return origem_passagem;
	}

	public void setOrigem_passagem(String origem_passagem) {
		this.origem_passagem = origem_passagem;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public Pacote_Viagem getPacote_Viagem() {
		return pacote_viagem;
	}

	public void setPacote_Viagem(Pacote_Viagem pacote_viagem) {
		this.pacote_viagem = pacote_viagem;
	}

	// metodos

	public String mostrar() {
		return "Id: " + this.id + " " + "Preco: " + this.preco_passagem + " Data_ida: " + this.data_ida_passagem
				+ " Data_volta: " + this.data_volta_passagem + " Origem: " + this.origem_passagem + " Compra "
				+ this.compra + " Destino " + this.destino + " Pacote_viagem" + this.pacote_viagem;
	}

	public void add(Pacote_Viagem pacote_viagens) {
		// TODO Auto-generated method stub

	}

	

}
