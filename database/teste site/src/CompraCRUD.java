import java.sql.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;


public class CompraCRUD {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cliente_CadastroDAO cliente_cadastroDAO = new Cliente_CadastroDAO();
		PassagensDAO passagensDAO = new PassagensDAO();
		Pacote_ViagemDAO pacote_viagemDAO = new Pacote_ViagemDAO();
		
				CompraDAO compraDAO = new CompraDAO();
				
				Scanner s = new Scanner(System.in);
				int opcao = 0;
				

				int id = 0;
				double valor= 0;
				String data ="";
				String qtd_itens ="";
				
				int id_cliente_cadastro = 0;
				int id_passagem = 0;
				int id_pacote_viagem = 0;
				
				
				do {
					System.out.println("=== COMPRA ===");
					System.out.println("1 - Cadastrar compra");
					System.out.println("2 - Consultar compra");
					System.out.println("3 - Atualizar compra");
					System.out.println("4 - Deletar compra");
					System.out.println("5 - Buscar por id");
					System.out.println("0 - Sair");
					opcao = s.nextInt();
					s.nextLine();

					switch (opcao) {
					case 1:
						// CREATE
						System.out.println("Digite o valor da compra: ");
						valor = s.nextDouble();
						
						System.out.println("Digite a data de compra ");
						data = s.next();
						
						System.out.println("Digite a quantidade de itens");
						qtd_itens= s.next();
					
					
						System.out.println("Digite o id do cliente: ");
						id_cliente_cadastro = s.nextInt();
						s.nextLine();
						
						System.out.println("Digite o id da passagem: ");
						id_passagem= s.nextInt();
						s.nextLine();
						
						System.out.println("Digite o id do pacote de viagem: ");
						id_pacote_viagem = s.nextInt();
						s.nextLine();
						
						Cliente_Cadastro cliente_cadastro = cliente_cadastroDAO.getCliente_CadastroById(id_cliente_cadastro);
						Passagens passagens = passagensDAO.getPassagensById(id_passagem);
						Pacote_Viagem pacote_viagem = pacote_viagemDAO.getPacote_ViagemById(id_pacote_viagem);
						
						
						Compra cp1 = new Compra (id, valor, data, qtd_itens, cliente_cadastro, pacote_viagem, passagens);
						
						compraDAO.save(cp1);
						
						System.out.println("\n***  Cadastrou  ***\n");
						
						break;
					case 2:
						// READ
						for (Compra cp: compraDAO.getCompra()) {
							System.out.println("Id: " + cp.getId() + " Valor: " + cp.getValor() + " Data: " + cp.getData()
							+ " Qtd_itens: " + cp.getQtd_itens() 
							+ " Cliente_Cadastro: "+ cp.getCliente_Cadastro() +" Pacote_Viagem:" + cp.getPacote_Viagem() + " Passagens:" + cp.getPassagens());
						}
						
						System.out.println("consultou");
						break;
						
					case 3:
						// UPDATE
						System.out.println("Digite o id da compra ");
						id = s.nextInt();
						s.nextLine();
						System.out.println("Digite o valor da compra: ");
						valor = s.nextDouble();
						
						System.out.println("Digite a data de compra ");
						data = s.next();
						
						System.out.println("Digite a quantidade de itens");
						qtd_itens= s.next();
					
					
						System.out.println("Digite o id do cliente: ");
						id_cliente_cadastro = s.nextInt();
						s.nextLine();
						
						System.out.println("Digite o id da passagem: ");
						id_passagem= s.nextInt();
						s.nextLine();
						
						System.out.println("Digite o id do pacote de viagem: ");
						id_pacote_viagem = s.nextInt();
						s.nextLine();
						
						Cliente_Cadastro cliente_cadastros = cliente_cadastroDAO.getCliente_CadastroById(id_cliente_cadastro);
						Passagens passagens1 = passagensDAO.getPassagensById(id_passagem);
						Pacote_Viagem pacote_viagens = pacote_viagemDAO.getPacote_ViagemById(id_pacote_viagem);
						
						Compra cp2 = new Compra (id, valor, data, qtd_itens, cliente_cadastros, pacote_viagens, passagens1);
					
						compraDAO.update(cp2);
			
						System.out.println("atualizou");
						break;
						
					case 4:
						// DELETE
						System.out.println("Digite o id da compra: ");
						id = s.nextInt();
						
						compraDAO.deleteById(id);
						
						break;	
					case 5:
						// buscar por id
						System.out.println("Digite o id da compra: ");
						id = s.nextInt();
						
						Compra cp3 = compraDAO.getCompraById(id);
						
						System.out.println("Id: " + cp3.getId() + " Valor: " + cp3.getValor() + " Data: " + cp3.getData()
						+ " Qtd_itens: " + cp3.getQtd_itens() 
						+ " Cliente_Cadastro: "+ cp3.getCliente_Cadastro() +" Pacote_Viagem:" + cp3.getPacote_Viagem() + " Passagens:" + cp3.getPassagens());
						
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


