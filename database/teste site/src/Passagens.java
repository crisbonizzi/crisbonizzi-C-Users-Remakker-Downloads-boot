import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Passagens {
	
	private Integer id;

	private double preco_passagem;

	private LocalDate data_ida_passagem;

	private LocalDate data_volta_passagem;

	private String origem_passagem;

	private Compra compra;

	private Destino destino;

	private Pacote_Viagem pacote_viagem;
	
	// classe responsavel por formatar um padrao diferente do formato ISO
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	// Contrutores
	public Passagens() {

	}

	public Passagens (int id, double preco, String data_ida, String data_volta, String origem, Compra compra, Destino destino, Pacote_Viagem pacote_viagem)
	{
			this.id = id;
			this.preco_passagem = preco;
			
			// convertendo data do tipo String ("dd/MM/yyyy") para LocalDate (yyyy-MM-dd)
			
			this.data_ida_passagem = LocalDate.parse(data_ida, formatter);
			this.data_volta_passagem = LocalDate.parse(data_volta, formatter);
			
			this.origem_passagem = origem;
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

	// convertendo data do tipo LocalDate (yyyy-MM-dd) para String (dd/MM/yyyy)
	
		public String getData_ida_passagem() {
			return formatter.format(data_ida_passagem);
		}

		public void setData_ida_passagem(String data_ida_passagem) {
			this.data_ida_passagem = LocalDate.parse(data_ida_passagem, formatter);
		}


		public String getData_volta_passagem() {
			return formatter.format(data_volta_passagem);
		}

		public void setData_volta_passagem(String data_volta_passagem) {
			this.data_volta_passagem = LocalDate.parse(data_volta_passagem, formatter);
		}

	public String getOrigem() {
		return origem_passagem;
	}

	public void setOrigem(String origem) {
		this.origem_passagem = origem;
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
			return "Id: "+ this.id +" "
					+ "Preco: " +this.preco_passagem
					+ " Data_ida: " + this.data_ida_passagem
					+ " Data_volta: " + this.data_volta_passagem
					+ " Origem: " + this.origem_passagem
					+ " Compra " + this.compra
					+ " Destino " + this.destino
					+ " Pacote_viagem" + this.pacote_viagem;
		}

	public void add(Pacote_Viagem pacote_viagens) {
		// TODO Auto-generated method stub
		
	}

	
}
