import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Cliente_CadastroDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar

	public void save(Cliente_Cadastro cliente) {

		String sql = "INSERT INTO cliente_cadastro (nome_cliente_cadastro, cpf_cliente_cadastro, telefone_cliente_cadastro, email_cliente_cadastro) values(?,?,?,?);";

		try {

			conn = connection.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, cliente.getNome());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, cliente.getCpf());
			// Adicionar o valor do terceiro parâmetro da sql
			pstm.setString(3, cliente.getTelefone());
			// Adicionar o valor do quarto parâmetro da sql
			pstm.setString(4, cliente.getEmail());

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

	public List<Cliente_Cadastro> getcliente_cadastro() {

		String sql = "select * from cliente_cadastro;";

		List<Cliente_Cadastro> clientes = new ArrayList<Cliente_Cadastro>();

		// Classe que vai recuperar os dados do banco de dados

		ResultSet rset = null;

		try {
			conn = connection.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça

			while (rset.next()) {

				Cliente_Cadastro cliente = new Cliente_Cadastro();

				cliente.setId(rset.getInt("id"));

				cliente.setNome(rset.getString("nome"));

				cliente.setNome(rset.getString("cpf"));

				cliente.setNome(rset.getString("telefone"));

				cliente.setNome(rset.getString("email"));

				Cliente_Cadastro.add(cliente);
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

		return clientes;

	}
	// Metodo pra atualizar

	public void update(Cliente_Cadastro cliente_cadastro) {
		String sql = "UPDATE cliente_cadastro set nome = ? cpf = ? telefone = ? email = ? where id_cliente_cadastro = ?;";

		try {
			conn = connection.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cliente_cadastro.getNome());

			pstm.setString(2, cliente_cadastro.getCpf());
			pstm.setString(3, cliente_cadastro.getTelefone());
			pstm.setString(4, cliente_cadastro.getEmail());

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

		String sql = "DELETE FROM cliente_cadastro WHERE id_cliente_cadastro = ?";

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

	public Cliente_Cadastro getAutorById(int id) {

		String sql = "SELECT * FROM cliente_cadastro WHERE id = ?;";

		Cliente_Cadastro cliente_cadastro = new Cliente_Cadastro();

		ResultSet rset = null;

		try {
			conn = connection.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			cliente_cadastro.setId(rset.getInt("id_cliente_cadastro"));

			cliente_cadastro.setNome(rset.getString("nome_cliente_cadastro"));

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

		return cliente_cadastro;
	}

	public Cliente_Cadastro getCliente_CadastroById(int id_cliente_cadastro) {
		// TODO Auto-generated method stub
		return null;
	}

}
