import java.util.Scanner;


public class Cliente_CadastroCRUD {

	public static void main(String[] args) {
		
	
		// TODO Auto-generated method stub
		
		Cliente_CadastroDAO cliente_cadastroDAO = new Cliente_CadastroDAO();
		
		Scanner s = new Scanner(System.in);
		int opcao = 0;
		int posicao = 0;

		int id = 0;
		String nome = "";
		String cpf = "";
		String telefone = "";
		String email = ""; 
		
		do {
			System.out.println("=== CLIENTES ===");
			System.out.println("1 - Cadastrar clientes");
			System.out.println("2 - Consultar clientes");
			System.out.println("3 - Atualizar clientes");
			System.out.println("4 - Deletar clientes");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				// CREATE
				System.out.println("Digite o nome do cliente: ");
				nome = s.nextLine();

				Cliente_Cadastro c1 = new Cliente_Cadastro (id, nome, cpf, telefone, email);
				
				cliente_cadastroDAO.save(c1);
				
				System.out.println("\n***  Cadastrou  ***\n");
				
				break;
			case 2:
				// READ
				for (Cliente_Cadastro a : cliente_cadastroDAO.getcliente_cadastro()) {
					System.out.println("Id: " + a.getId() + " Nome: " + a.getNome() + " CPF: " + a.getCpf() + " Telefone: " + a.getTelefone() + " Email: " + a.getEmail());
				}
				
				System.out.println("consultou");
				break;
				
			case 3:
				// UPDATE
				System.out.println("Digite o id do cliente: ");
				posicao = s.nextInt();
				s.nextLine();
				System.out.println("Digite o nome do cliente: ");
				nome = s.nextLine();
				System.out.println("Digite o cpf do cliente: ");
				nome = s.nextLine();
				System.out.println("Digite o telefone do cliente: ");
				nome = s.nextLine();
				System.out.println("Digite o email do cliente: ");
				nome = s.nextLine();
				
				Cliente_Cadastro c2 = new Cliente_Cadastro(posicao, nome, cpf, telefone, email);
			
				cliente_cadastroDAO.update(c2);
	
				System.out.println("atualizou");
				break;
				
			case 4:
				// DELETE
				System.out.println("Digite o id do cliente: ");
				posicao = s.nextInt();
				
				cliente_cadastroDAO.deleteById(posicao);
				
				break;	
			case 5:
				// buscar por id
				System.out.println("Digite o id do cliente: ");
				posicao = s.nextInt();
				
				Cliente_Cadastro c3 = cliente_cadastroDAO.getAutorById(posicao);
				
				System.out.println("Id: " + c3.getId() + " Nome: " + c3.getNome() + " CPF: " + c3.getCpf() + " Telefone: " + c3.getTelefone() + " Email: " + c3.getEmail());
				
				break;
				
			default:
				System.out.println(opcao != 0 ? "opcao invalida, digite novamente." : "");
				break;
			}
				
			} while (opcao != 0);
			
			System.out.println("Até mais!");
			s.close();
		}
		
	}
