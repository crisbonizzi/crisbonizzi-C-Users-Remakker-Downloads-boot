
public class Destino {
	// Atributos
    private Integer id;
    private String cidade;
    private String pais;
    
    
    
  // Construtores
    
    public Destino() {
		
	}
	
	public Destino (int id, String cidade, String pais) {
		this.id = id;
		this.cidade = cidade;
		this.pais = pais;
	}

    
	//Getters e Setters
	
    public int getId() {
        return id;
    }
   
  public void setId(Integer id) {
        this.id = id;
    }
    
    
   public String getCidade() {
        return cidade;
    }
    
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
   public String getPais() {
        return this.pais;
    }
    
  
   public void setPais(String pais) {
        this.pais = pais;
    }
    
 //ToString

	@Override
	public String toString() {
		return "Destino [id=" + id + ", cidade=" + cidade + ", pais= " + pais +"]";
	}

	public static void add(Destino destino) {
		// TODO Auto-generated method stub
		
	}

	
		
	}	

