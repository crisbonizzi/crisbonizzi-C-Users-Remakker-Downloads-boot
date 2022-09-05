
import java.util.Scanner;


public class PassagensCRUD {



	public static void main(String[] args) {
		
		CompraDAO compraDAO = new CompraDAO();
		DestinoDAO destinoDAO = new DestinoDAO();
		Pacote_ViagemDAO pacote_viagemDAO = new Pacote_ViagemDAO();
		
				PassagensDAO passagensDAO = new PassagensDAO();
				
				Scanner s = new Scanner(System.in);
				int opcao = 0;
				

				int id = 0;
				double preco_passagem = 0;
				String data_ida_passagem ="";
				String data_volta_passagem ="";
				String origem_passagem = ""; 
				int id_compra = 0;
				int id_destino = 0;
				int id_pacote_viagem = 0;
				
				
				do {
					System.out.println("=== PASSAGENS ===");
					System.out.println("1 - Cadastrar passagens");
					System.out.println("2 - Consultar passagens");
					System.out.println("3 - Atualizar passagens");
					System.out.println("4 - Deletar passagens");
					System.out.println("5 - Buscar por id");
					System.out.println("0 - Sair");
					opcao = s.nextInt();
					s.nextLine();

					switch (opcao) {
					case 1:
						// CREATE
						System.out.println("Digite o preco da passagem: ");
						preco_passagem = s.nextDouble();
						
						System.out.println("Digite a data de ida da passagem ");
						data_ida_passagem = s.next();
						
						System.out.println("Digite a data da volta ");
						data_volta_passagem= s.next();
						
						System.out.println("Digite a origem da passagem ");
						origem_passagem = s.next();
					
						System.out.println("Digite o id da compra: ");
						id_compra = s.nextInt();
						s.nextLine();
						
						System.out.println("Digite o id do destino: ");
						id_destino= s.nextInt();
						s.nextLine();
						
						System.out.println("Digite o id do pacote de viagem: ");
						id_pacote_viagem = s.nextInt();
						s.nextLine();
						
						Compra compra = compraDAO.getCompraById(id_compra);
						Destino destino = destinoDAO.getDestinoById(id_destino);
						Pacote_Viagem pacote_viagem = pacote_viagemDAO.getPacote_ViagemById(id_pacote_viagem);
						
						
						Passagens p1 = new Passagens (id, preco_passagem, data_ida_passagem, data_volta_passagem, origem_passagem, compra, destino, pacote_viagem);
						
						passagensDAO.save(p1);
						
						System.out.println("\n***  Cadastrou  ***\n");
						
						break;
					case 2:
						// READ
						for (Passagens p : passagensDAO.getPassagens()) {
							System.out.println("Id: " + p.getId() + " Preco: " + p.getPreco_passagem() + " Data_ida: " + p.getData_ida_passagem()
							+ " Data_volta: " + p.getData_volta_passagem() + " Origem: " + p.getOrigem()
							+ " Compra: "+ p.getCompra() +" Destino:" + p.getDestino() + " Pacote_Viagem:" + p.getPacote_Viagem());
						}
						
						System.out.println("consultou");
						break;
						
					case 3:
						// UPDATE
						System.out.println("Digite o id da passagem: ");
						id = s.nextInt();
						s.nextLine();
						
						System.out.println("Digite o preco: ");
						preco_passagem = s.nextDouble();
	
						System.out.println("Digite a data_ida: ");
						data_ida_passagem = s.nextLine();
						
						System.out.println("Digite a data_volta ");
						data_volta_passagem = s.nextLine();
						
						System.out.println("Digite a origem da passagem: ");
						origem_passagem = s.nextLine();
						
						System.out.println("Digite o id da compra: ");
						id_compra = s.nextInt();
						s.nextLine();
						
						System.out.println("Digite o id do destino ");
						id_destino = s.nextInt();
						s.nextLine();
						
						System.out.println("Digite o id do pacote de viagem ");
						id_pacote_viagem = s.nextInt();
						s.nextLine();
						
						Compra compras = compraDAO.getCompraById(id_compra);
						Destino destinos = destinoDAO.getDestinoById(id_destino);
						Pacote_Viagem pacote_viagens = pacote_viagemDAO.getPacote_ViagemById(id_pacote_viagem);
						
						Passagens p2 = new Passagens(id, preco_passagem, data_ida_passagem, data_volta_passagem, origem_passagem, compras, destinos, pacote_viagens);
					
						passagensDAO.update(p2);
			
						System.out.println("atualizou");
						break;
						
					case 4:
						// DELETE
						System.out.println("Digite o id da passagem: ");
						id = s.nextInt();
						
						passagensDAO.deleteById(id);
						
						break;	
					case 5:
						// buscar por id
						System.out.println("Digite o id da passagem: ");
						id = s.nextInt();
						
						Passagens p3 = passagensDAO.getPassagensById(id);
						
						System.out.println("Id: " + p3.getId() + " Preco " + p3.getPreco_passagem() + " Data_ida: " + p3.getData_ida_passagem()
						+ " Data_volta: " + p3.getData_volta_passagem() + " Origem: " + p3.getOrigem()
						+ " Compra: "+ p3.getCompra() +" Destino:" + p3.getDestino() + " Pacote_Viagem:" + p3.getPacote_Viagem());
						
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


