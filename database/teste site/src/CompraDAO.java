import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CompraDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar

	public void save(Compra compra) {

		String sql = "INSERT INTO compra (valor_compra, data_compra, qtd_itens_compra, id_cliente_cadastro, id_passagem, id_pacote_viagem) values(?,?,?,?,?,?);";

		try {

			conn = connection.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			
			// Adicionar o valor do primeiro parametro da sql
			
			pstm.setDouble(1, compra.getValor());

			pstm.setString(2, compra.getData());
			
			pstm.setString(3, compra.getQtd_itens());
			
			

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

			pstm.setInt(5, compra.getCliente_Cadastro().getId());

			pstm.setInt(6, compra.getPassagens().getId());
			
			pstm.setInt(7, compra.getPacote_Viagem().getId());

			// Executar a sql para inser��o dos dados
			
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
		
	// Metodo para Ler
	
		public List <Compra> getCompra() {
			
			String sql = "select * from compra;";

			List<Compra> compra = new ArrayList<Compra>();

			// Classe que vai recuperar os dados do banco de dados
			
			ResultSet rset = null;

			try {
				conn = connection.createConnectionToMySQL();

				pstm = conn.prepareStatement(sql);

				rset = pstm.executeQuery();

				// Enquanto existir dados no banco de dados, faça

				while (rset.next()) {
					
					Compra compras = new Compra();
					Cliente_Cadastro cliente_cadastro = new Cliente_Cadastro();
					Passagens passagens = new Passagens();
					Pacote_Viagem pacote_viagem = new Pacote_Viagem();
					
					compras.setValor(rset.getDouble("valor_compra"));

					compras.setData(rset.getString("data"));
					
					compras.setQtd_itens(rset.getString("qtd_itens"));
					
					

					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					

					cliente_cadastro.setId(rset.getInt("id_cliente_cadastro"));

					compras.setCliente_Cadastro(cliente_cadastro);

					passagens.setId(rset.getInt("id_passagem"));

					compras.setPassagens(passagens);
					
					pacote_viagem.setId(rset.getInt("id_pacote_viagem"));

					compras.setPacote_Viagem(pacote_viagem);

					compra.add(compras);

				}

			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				try {
					if (rset != null) {
						rset.close();
					}
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			return compra;
		}
		
		
		// Metodo pra atualizar

		public void update(Compra compra) {
			
			String sql = "UPDATE compra SET valor_compra = ?, data_compra = ?, qtd_itens_compra = ?, id_cliente_cadastro ?, id_passagens= ?,id_pacote_viagem = ?,   WHERE id_compra = ?;";

			try {
				conn = connection.createConnectionToMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setDouble(1, compra.getValor());

				pstm.setString(2, compra.getData());
				
				pstm.setString(3, compra.getQtd_itens());
				
				

				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

				pstm.setInt(5, compra.getCliente_Cadastro().getId());

				pstm.setInt(6, compra.getPassagens().getId());
				
				pstm.setInt(7, compra.getPacote_Viagem().getId());

				pstm.execute();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		// Metodo para deletar
		public void deleteById(int id) {
			
			String sql = "DELETE FROM livros WHERE id_compra = ?";

			try {
				conn = connection.createConnectionToMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setInt(1, id);

				pstm.execute();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		public Compra getCompraById(int id) {
			
			String sql = "select * from passagens WHERE id_compra = ?;";

			Compra compras = new Compra();
			Cliente_Cadastro cliente_cadastro = new Cliente_Cadastro();
			Passagens passagens = new Passagens();
			Pacote_Viagem pacote_viagem = new Pacote_Viagem();

			ResultSet rset = null;


			try {
				conn = connection.createConnectionToMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setInt(1, id);

				rset = pstm.executeQuery();

				rset.next();

				compras.setValor(rset.getDouble("valor_compra"));

				compras.setData(rset.getString("data"));
				
				compras.setQtd_itens(rset.getString("qtd_itens"));
				
				

				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				

				cliente_cadastro.setId(rset.getInt("id_cliente_cadastro"));

				compras.setCliente_Cadastro(cliente_cadastro);

				passagens.setId(rset.getInt("id_passagem"));

				compras.setPassagens(passagens);
				
				pacote_viagem.setId(rset.getInt("id_pacote_viagem"));

				compras.setPacote_Viagem(pacote_viagem);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			return compras;
		}
}
