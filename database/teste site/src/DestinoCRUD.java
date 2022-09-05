import java.util.Scanner;

public class DestinoCRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		DestinoDAO destinoDAO = new DestinoDAO();

		Scanner s = new Scanner(System.in);
		int opcao = 0;
		int posicao = 0;

		int id = 0;
		String cidade = "";
		String pais = "";
		

		do {
			System.out.println("=== Destino ===");
			System.out.println("1 - Cadastrar destino");
			System.out.println("2 - Consultar destino");
			System.out.println("3 - Atualizar destino");
			System.out.println("4 - Deletar destino");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				// CREATE
				System.out.println("Digite o id do destino: ");
				id = s.nextInt();
				
				System.out.println("Digite o nome da cidade: ");
				cidade = s.nextLine();
				
				System.out.println("Digite o pais: ");
				pais = s.next();

				Destino d1 = new Destino(id, cidade, pais);

				destinoDAO.save(d1);

				System.out.println("\n***  Cadastrou  ***\n");

				break;
			case 2:
				// READ
				for (Destino d : destinoDAO.getdestino()) {
					System.out.println("Id: " + d.getId() + " Cidade: " + d.getCidade() + " Pais: " + d.getPais());
				}

				System.out.println("consultou");
				break;

			case 3:
				// UPDATE
				System.out.println("Digite o id do destino: ");
				posicao = s.nextInt();
				s.nextLine();
				System.out.println("Digite a cidade do destino: ");
				cidade = s.nextLine();
				System.out.println("Digite o pais do destino: ");
				pais = s.nextLine();

				Destino d2 = new Destino(posicao, cidade, pais);

				destinoDAO.update(d2);

				System.out.println("atualizou");
				break;

			case 4:
				// DELETE
				System.out.println("Digite o id do destino: ");
				posicao = s.nextInt();

				destinoDAO.deleteById(posicao);

				break;
			case 5:
				// buscar por id
				System.out.println("Digite o id do destino: ");
				posicao = s.nextInt();

				Destino d3 = destinoDAO.getAutorById(posicao);

				System.out.println("Id: " + d3.getId() + " Cidade: " + d3.getCidade() + " Pais: " + d3.getPais());

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
