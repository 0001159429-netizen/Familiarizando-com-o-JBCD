import java.beans.PropertyEditor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de Acesso a Dados (DAO) para a entidade Aluno.
 * Implementa todas as operações CRUD (Create, Read, Update, Delete).
 */

public class ProfessorDAO {

    /**
     * CREATE: Insere um novo aluno no BD.
     */
    public void inserir(Professor professor) {
        // Query SQL usa '?' (placeholders) para segurança (PreparedStatement).
        String sql = "INSERT INTO professores (nome, estado, cidade, email, senha, estado_civil, data_nascimento, salario, ativo, especialidade, ativo) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        // try-with-resources: Garante o fechamento automático da Conexão e do PreparedStatement.
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEstado());
            stmt.setString(3, professor.getCidade());
            stmt.setString(4, professor.getEstado_civil());
            stmt.setString(5, professor.getEspecialidade());
            stmt.setBoolean(6, professor.getAtivo());
            stmt.setDouble(7,professor.getSalario());
            stmt.setDate(8, professor.getData_nascimento());
            stmt.setString(9, professor.getSenha());
            stmt.setString( 10, professor.getEmail());

            stmt.executeUpdate();

            System.out.println("Professor inserido com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        }
    }

    //Lista de Professores
    public List<Professor> listar() {
        List<Professor> lista = new ArrayList<>();
        String sql = "SELECT * FROM professor";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             // executeQuery() retorna o ResultSet (conjunto de resultados).
             ResultSet rs = stmt.executeQuery()) {

            // Itera sobre cada linha retornada pelo banco de dados.
            while (rs.next()) {

                Professor p = new Professor(); // construtor vazio

                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setEstado(rs.getString("estado"));
                p.setCidade(rs.getString("cidade"));
                p.setEstado_civil(rs.getString("estado_civil"));
                p.setData_nascimento(rs.getDate("data_nascimento"));
                p.setSalario(rs.getDouble("salario"));
                p.setEspecialidade(rs.getString("especialidade"));
                p.setAtivo(rs.getBoolean("ativo"));
                p.setAtivo(rs.getString("email"));

                p.setData_cadastro(rs.getTimestamp("data_cadastro"));
                p.setData_atualizacao(rs.getTimestamp("data_atualizacao"));
                p.setData_remocao(rs.getTimestamp("data_remocao"));

                lista.add(p);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }

        return lista;
    }


    /**
     * UPDATE: Atualiza os dados de um aluno existente pelo ID.
     */
    public void atualizar(Professor professor) {

        String sql = "UPDATE professor SET nome = ?, email = ? WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // 1. Novos valores para Nome e Email.
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setString(3, professor.getSenha());

            // 2. ID do registro a ser atualizado (condição WHERE).
            stmt.setInt(3, professor.getId());

            stmt.executeUpdate();

            System.out.println("Professor atualizado!");

        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    /**
     * DELETE: Remove um registro do BD com base no ID.
     */
    public void deletar(int id) {
        String sql = "DELETE FROM professor WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Define o ID do aluno a ser deletado.
            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Professor deletado!");

        } catch (Exception e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }
}
