package dao;

import model.Cliente;
import util.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public List<Cliente> consultaGeral() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Connection conn = Conexao.conecta();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));

                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return lista;
    }

    public List<Cliente> consultaPorNome(String nome) {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente WHERE nome LIKE ?";
        try (Connection conn = Conexao.conecta();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return lista;
    }

    public Cliente consultaPorId(int id) {
        Cliente c = null;
        String sql = "SELECT * FROM cliente WHERE id = ?";
        try (Connection conn = Conexao.conecta();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return c;
    }

    public boolean cadastrar(Cliente c) {
        String sql = "INSERT INTO cliente (nome, sobrenome, email, telefone, funcao, area_departamento, nome_organizacao, pais_regiao, cep, interesse_principal) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.conecta();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNome());
            ps.setString(2, c.getSobrenome());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getTelefone());
            ps.setString(5, c.getFuncao());
            ps.setString(6, c.getAreaDepartamento());
            ps.setString(7, c.getNomeOrganizacao());
            ps.setString(8, c.getPaisRegiao());
            ps.setString(9, c.getCep());
            ps.setString(10, c.getInteressePrincipal());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            return false;
        }
    }

    public boolean atualizar(Cliente c) {
        String sql = "UPDATE cliente SET nome=?, sobrenome=?, email=?, telefone=?, funcao=?, area_departamento=?, nome_organizacao=?, pais_regiao=?, cep=?, interesse_principal=? WHERE id=?";
        try (Connection conn = Conexao.conecta();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNome());
            ps.setString(2, c.getSobrenome());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getTelefone());
            ps.setString(5, c.getFuncao());
            ps.setString(6, c.getAreaDepartamento());
            ps.setString(7, c.getNomeOrganizacao());
            ps.setString(8, c.getPaisRegiao());
            ps.setString(9, c.getCep());
            ps.setString(10, c.getInteressePrincipal());
            ps.setInt(11, c.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
            return false;
        }
    }

    public boolean deletar(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (Connection conn = Conexao.conecta();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
            return false;
        }
    }
}
