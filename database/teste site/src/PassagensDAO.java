import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PassagensDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar

	public void save(Passagens passagens) {

		String sql = "INSERT INTO passagens (preco_passagem, data_ida_passagem, data_volta_passagem, origem_passagem, id_compra, id_destino, id_pacote_viagem) values(?,?,?,?,?,?,?);";

		try {

			conn = connection.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			
			// Adicionar o valor do primeiro parametro da sql
			
			pstm.setDouble(1, passagens.getPreco_passagem());

			pstm.setString(2, passagens.getData_ida_passagem());
			
			pstm.setString(3, passagens.getData_volta_passagem());
			
			pstm.setString(4, passagens.getOrigem_passagem());

			pstm.setInt(5, passagens.getCompra().getId());

			pstm.setInt(6, passagens.getDestino().getId());
			
			pstm.setInt(7, passagens.getPacote_Viagem().getId());

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
	
		public List <Passagens> getPassagens() {
			
			String sql = "select * from passagens;";

			List<Passagens> passagens = new ArrayList<Passagens>();

			// Classe que vai recuperar os dados do banco de dados
			
			ResultSet rset = null;

			try {
				conn = connection.createConnectionToMySQL();

				pstm = conn.prepareStatement(sql);

				rset = pstm.executeQuery();

				// Enquanto existir dados no banco de dados, faça

				while (rset.next()) {
					
					Passagens passagem = new Passagens();
					Compra compra = new Compra();
					Destino destino = new Destino();
					Pacote_Viagem pacote_viagem = new Pacote_Viagem();
					
					passagem.setPreco(rset.getDouble("preco_passagem"));

					passagem.setData_ida_passagem(rset.getString("data_ida_passagem"));
					
					passagem.setData_volta_passagem(rset.getString("data_volta_passagem"));
					
					passagem.setOrigem_passagem(rset.getString("origem_passagem"));

					compra.setId(rset.getInt("id_compra"));

					passagem.setCompra(compra);

					destino.setId(rset.getInt("id_destino"));

					passagem.setDestino(destino);
					
					pacote_viagem.setId(rset.getInt("id_pacote_viagem"));

					passagem.setPacote_Viagem(pacote_viagem);

					passagens.add(passagem);

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

			return passagens;
		}
		
		
		// Metodo pra atualizar

		public void update(Passagens passagens) {
			
			String sql = "UPDATE passagens SET preco_passagem = ?, data_ida_passagem = ?, data_volta_passagem = ?, origem_passagem = ?, id_compra= ?,id_destino = ?, id_pacote_viagem = ?,  WHERE id_passagem = ?;";

			try {
				conn = connection.createConnectionToMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setDouble(1, passagens.getPreco_passagem());

				pstm.setString(2, passagens.getData_ida_passagem());
				
				pstm.setString(3, passagens.getData_volta_passagem());
				
				pstm.setString(4, passagens.getOrigem_passagem());
				
				
				pstm.setInt(5, passagens.getCompra().getId());

				pstm.setInt(6, passagens.getDestino().getId());
				
				pstm.setInt(7, passagens.getPacote_Viagem().getId());

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
			String sql = "DELETE FROM livros WHERE id_passagem = ?";

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

		public Passagens getPassagensById(int id) {
			
			String sql = "select * from passagens WHERE id_passagem = ?;";

			Passagens passagem = new Passagens();
			Compra compra = new Compra();
			Destino destino = new Destino();
			Pacote_Viagem pacote_viagem = new Pacote_Viagem();

			ResultSet rset = null;


			try {
				conn = connection.createConnectionToMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setInt(1, id);

				rset = pstm.executeQuery();

				rset.next();

				passagem.setPreco(rset.getDouble("preco_passagem"));

				passagem.setData_ida_passagem(rset.getString("data_ida_passagem"));
				
				passagem.setData_volta_passagem(rset.getString("data_volta_passagem"));
				
				passagem.setOrigem_passagem(rset.getString("origem_passagem"));

				
				
				compra.setId(rset.getInt("id_compra"));

				passagem.setCompra(compra);

				destino.setId(rset.getInt("id_destino"));

				passagem.setDestino(destino);
				
				pacote_viagem.setId(rset.getInt("id_pacote_viagem"));

				passagem.setPacote_Viagem(pacote_viagem);
				
				
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

			return passagem;
		}
}
