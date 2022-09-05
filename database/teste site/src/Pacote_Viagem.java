
public class Pacote_Viagem {
	// Atributos
	
    private Integer id;
    private String hoteis;
    private String acomodacao;
    private double preco_pacote;
    private Passagens passagens;
    private Compra compra;
    
    
  //Construtor
    
	public Pacote_Viagem() {
		
	}
	
	public Pacote_Viagem (int id, String hoteis, String acomodacao, double preco_pacote, Passagens passagens, Compra compra ) {
		
		this.id = id;
		this.hoteis = hoteis;
		this.acomodacao = acomodacao;
		this.preco_pacote = preco_pacote;
		this.passagens = passagens;
		this.compra = compra;
		
	}
	
	//Geters e Seters
	
  public Integer getId() {
        return id;
    }
    
 
   public void setId(Integer id) {
        this.id = id;
    }
    
   
   public String getHoteis() {
        return hoteis;
    }
    
 
    public void setHoteis(String hoteis) {
        this.hoteis = hoteis;
    }
    
   
    public String getAcomodacao() {
        return acomodacao;
    }
    
   
    public void setAcomodacao(String acomodacao) {
        this.acomodacao = acomodacao;
    }
    
   
   public double getPreco_pacote() {
        return preco_pacote;
    }
    
   
    public void setPreco_pacote(double preco_pacote) {
        this.preco_pacote = preco_pacote;
    }
    
    public Passagens getPassagens() {
		return passagens;
	}

	public void setPassagem(Passagens passagens) {
		this.passagens = passagens;
	}
	
	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	
    
    // metodos
    
    public String mostrar() {
		return "Id: "+ this.id +" Hoteis: " +this.hoteis
				+ " Acomodacao: " + this.acomodacao 
				+ " Preco_pacote: " + this.preco_pacote
				+ " Passagens: " + this.passagens
				+ " Compra: " + this.compra;
	}
}
