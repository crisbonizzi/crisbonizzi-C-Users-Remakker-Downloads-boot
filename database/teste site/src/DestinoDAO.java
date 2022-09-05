import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DestinoDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar

	public void save(Destino destino) {

		String sql = "INSERT INTO destino (cidade_destino, pais_destino) values(?,?);";

		try {

			conn = connection.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, destino.getCidade());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, destino.getPais());

			// Executa a sql para inserção dos dados
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

	public List<Destino> getdestino() {

		String sql = "select * from destino;";

		List<Destino> destinos = new ArrayList<Destino>();

		// Classe que vai recuperar os dados do banco de dados

		ResultSet rset = null;

		try {
			conn = connection.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça

			while (rset.next()) {

				Destino destino = new Destino();

				destino.setId(rset.getInt("id"));

				destino.setCidade(rset.getString("cidade"));

				destino.setPais(rset.getString("pais"));

				Destino.add(destino);
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

		return destinos;

	}
	// Metodo pra atualizar

	public void update(Destino destino) {
		String sql = "UPDATE destino set cidade = ? pais = ? WHERE id_destino = ?;";

		try {
			conn = connection.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destino.getCidade());

			pstm.setString(2, destino.getPais());
			
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

		String sql = "DELETE FROM destino WHERE id_destino = ?";

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

	public Destino getAutorById(int id) {

		String sql = "SELECT * FROM destino WHERE id = ?;";

		Destino destino = new Destino();

		ResultSet rset = null;

		try {
			conn = connection.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			destino.setId(rset.getInt("id_destino"));

			destino.setCidade(rset.getString("cidade_destino"));

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

		return destino;
	}

	public Destino getDestinoById(int id_destino) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
