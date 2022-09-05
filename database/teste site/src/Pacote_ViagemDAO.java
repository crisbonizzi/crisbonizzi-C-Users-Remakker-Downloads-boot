import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Pacote_ViagemDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar

	public void save(Pacote_Viagem pacote_viagem) {

		String sql = "INSERT INTO pacote_viagem (hoteis, acomodacao, preco_pacote, id_passagem, id_compra) values(?,?,?,?,?);";

		try {

			conn = connection.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			
			// Adicionar o valor do primeiro parametro da sql
			
			pstm.setString(1, pacote_viagem.getHoteis());

			pstm.setString(2, pacote_viagem.getAcomodacao());
			
			pstm.setDouble(3, pacote_viagem.getPreco_pacote());

			pstm.setInt(4,pacote_viagem.getPassagens().getId());
			
			pstm.setInt(5,pacote_viagem.getCompra().getId());


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
	
		public List <Pacote_Viagem> getPacote_Viagem() {
			
			String sql = "select * from pacote_viagem;";

			List<Pacote_Viagem> pacote_viagem = new ArrayList<Pacote_Viagem>();

			// Classe que vai recuperar os dados do banco de dados
			
			ResultSet rset = null;

			try {
				conn = connection.createConnectionToMySQL();

				pstm = conn.prepareStatement(sql);

				rset = pstm.executeQuery();

				// Enquanto existir dados no banco de dados, faça

				while (rset.next()) {
					
					Pacote_Viagem pacote_viagens = new Pacote_Viagem();
					
					Passagens passagens = new Passagens();
					
					Compra compra = new Compra();
					
					pacote_viagens.setHoteis(rset.getString("hoteis"));

					pacote_viagens.setAcomodacao(rset.getString("acomodacao"));
					
					pacote_viagens.setPreco_pacote(rset.getDouble("preco_pacote"));
					
					compra.setId(rset.getInt("id_compra"));

					pacote_viagens.setCompra(compra);

					passagens.setId(rset.getInt("id_passagem"));

					pacote_viagens.setPassagem(passagens);
					
					pacote_viagem.add(pacote_viagens);
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

			return pacote_viagem;
		}
		
		
		// Metodo pra atualizar

		public void update(Pacote_Viagem pacote_viagem) {
			
			String sql = "UPDAT pacote_viagem SET hoteis = ?, acomodacao = ?, preco_pacote = ?, id_compra= ?, id_passagem = ?,  WHERE id_pacote_viagem = ?;";

			try {
				conn = connection.createConnectionToMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setString(1, pacote_viagem.getHoteis());

				pstm.setString(2, pacote_viagem.getAcomodacao());
				
				pstm.setDouble(3, pacote_viagem.getPreco_pacote());

				pstm.setInt(4,pacote_viagem.getPassagens().getId());
				
				pstm.setInt(5,pacote_viagem.getCompra().getId());

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
			String sql = "DELETE FROM livros WHERE id_pacote_viagem = ?";

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

		public Pacote_Viagem getPacote_ViagemById(int id) {
			
			String sql = "select * from passagens WHERE id_pacote_viagem = ?;";
			
			Pacote_Viagem pacote_viagens = new Pacote_Viagem();
			
			Passagens passagens = new Passagens();
			
			Compra compra = new Compra();

			ResultSet rset = null;


			try {
				conn = connection.createConnectionToMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setInt(1, id);

				rset = pstm.executeQuery();

				rset.next();
				
			
				pacote_viagens.setHoteis(rset.getString("hoteis"));

				pacote_viagens.setAcomodacao(rset.getString("acomodacao"));
				
				pacote_viagens.setPreco_pacote(rset.getDouble("preco_pacote"));
				
				compra.setId(rset.getInt("id_compra"));

				pacote_viagens.setCompra(compra);

				passagens.setId(rset.getInt("id_passagem"));

				pacote_viagens.setPassagem(passagens);
				
				
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

			return pacote_viagens;
		}
}
