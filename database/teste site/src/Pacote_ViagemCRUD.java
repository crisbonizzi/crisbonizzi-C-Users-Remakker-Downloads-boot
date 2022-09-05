import java.util.Scanner;

public class Pacote_ViagemCRUD {

	public static void main(String[] args) {

		PassagensDAO passagensDAO = new PassagensDAO();
		CompraDAO compraDAO = new CompraDAO();

		Pacote_ViagemDAO pacote_viagemDAO = new Pacote_ViagemDAO();

		Scanner s = new Scanner(System.in);
		int opcao = 0;

		int id = 0;
		String hoteis = "";
		String acomodacao = "";
		double preco_pacote = 0;
		int id_passagem = 0;
		int id_compra = 0;

		do {
			System.out.println("=== PACOTE VIAGEM===");
			System.out.println("1 - Cadastrar pacote de viagens");
			System.out.println("2 - Consultar pacote de viagens");
			System.out.println("3 - Atualizar pacote de viagens");
			System.out.println("4 - Deletar o pacote de viagens");
			System.out.println("5 - Buscar por id");
			System.out.println("0 - Sair");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				// CREATE
				System.out.println("Digite o hotel referente ao pacote: ");
				hoteis = s.nextLine();

				System.out.println("Digite a acomodaçao escolhida ");
				acomodacao = s.next();

				System.out.println("Digite o preco do novo pacote");
				preco_pacote = s.nextDouble();

				System.out.println("Digite o id da passagem: ");
				id_passagem = s.nextInt();
				s.nextLine();

				System.out.println("Digite o valor da nova compra ");
				id_compra = s.nextInt();
				s.nextLine();

				
				Passagens passagens = passagensDAO.getPassagensById(id_passagem);
				Compra compra = compraDAO.getCompraById(id_compra);

				Pacote_Viagem pct1 = new Pacote_Viagem(id, hoteis, acomodacao, preco_pacote,passagens, compra);

				pacote_viagemDAO.save(pct1);

				System.out.println("\n***  Cadastrou  ***\n");

				break;
			case 2:
				// READ
				for (Pacote_Viagem pct : pacote_viagemDAO.getPacote_Viagem()) {
					System.out.println("Id: " + pct.getId() + " Hoteis: " + pct.getHoteis() + " Acomodacao: " + pct.getAcomodacao()
							+ " Preco_Pacote" + pct.getPreco_pacote() + " Passagens:" + pct.getPassagens() + " compra:" + pct.getCompra());
				}

				System.out.println("consultou");
				break;

			case 3:
				// UPDATE
				System.out.println("Digite o id do pacote de viagens ");
				id = s.nextInt();
				s.nextLine();
				
				System.out.println("Digite o hotel escolhido ");
				hoteis= s.nextLine();

				System.out.println("Digite a acomodacao escolhida ");
				acomodacao = s.next();

				System.out.println("Digite o novo preco do pacote de viagens");
				preco_pacote = s.nextDouble();

				System.out.println("Digite o id da passagem: ");
				id_passagem = s.nextInt();
				s.nextLine();

				System.out.println("Digite o id da compra ");
				id_compra = s.nextInt();
				s.nextLine();

				Passagens passagens1 = passagensDAO.getPassagensById(id_passagem);
				Compra compras = compraDAO.getCompraById(id_compra);

				Pacote_Viagem pct2 = new Pacote_Viagem (id, hoteis, acomodacao, preco_pacote, passagens1, compras);

				pacote_viagemDAO.update(pct2);

				System.out.println("atualizou");
				break;

			case 4:
				// DELETE
				System.out.println("Digite o id do pacote de viagem ");
				id = s.nextInt();

				compraDAO.deleteById(id);

				break;
			case 5:
				// buscar por id
				System.out.println("Digite o id do pacote de viagem: ");
				id = s.nextInt();

				Pacote_Viagem pct3 = pacote_viagemDAO.getPacote_ViagemById(id);

				System.out.println("Id: " + pct3.getId() + " Hoteis: " + pct3.getHoteis() + " Acomodacao: " + pct3.getAcomodacao()
				+ " Preco_Pacote" + pct3.getPreco_pacote() + " Passagens:" + pct3.getPassagens() + " compra:" + pct3.getCompra());

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
