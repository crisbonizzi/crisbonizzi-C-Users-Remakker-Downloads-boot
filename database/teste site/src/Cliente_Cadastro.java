

public class Cliente_Cadastro {
// Atributos

	private Integer id;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	
	
	// Construtores

	public Cliente_Cadastro() {

	}

	public Cliente_Cadastro(int id, String nome, String cpf, String telefone, String email) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
	}

	// Getters e Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	// ToString

	@Override
	public String toString() {
		return "Cliente_Cadastro [id=" + id + ", nome=" + nome + ", cpf= " + cpf + ", telefone=" + telefone + ", email="
				+ email + "]";
	}

	public static void add(Cliente_Cadastro cliente) {
		
	
	}

	
		
	}

