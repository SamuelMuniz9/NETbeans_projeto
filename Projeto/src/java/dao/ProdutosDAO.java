package dao;

import model.Produtos;
import util.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {

    public List<Produtos> consultaEstoque() {
        List<Produtos> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        try (Connection conn = Conexao.conecta();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Produtos p = new Produtos();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return lista;
    }

    public List<Produtos> consultaPorNome(String nome) {
        List<Produtos> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos WHERE nome LIKE ?";
        try (Connection conn = Conexao.conecta();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produtos p = new Produtos();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return lista;
    }

    public Produtos consultaPorId(int id) {
        Produtos p = null;
        String sql = "SELECT * FROM produtos WHERE id = ?";
        try (Connection conn = Conexao.conecta();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = new Produtos();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return p;
    }

    public boolean cadastrar(Produtos p) {
        String sql = "INSERT INTO produtos (nome, preco, validade, quantidade ) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.conecta();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNome());
            ps.setDouble(2, p.getPreco());
            ps.setString(3, p.getValidade());
            ps.setInt(4, p.getQuantidade());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
            return false;
        }
    }

    public boolean atualizar(Produtos p) {
        String sql = "UPDATE produtos SET nome=?, preco=?, data_v=?, qtd=? WHERE id=?";
        try (Connection conn = Conexao.conecta();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNome());
            ps.setDouble(2, p.getPreco());
            ps.setString(3, p.getValidade());
            ps.setInt(4, p.getQuantidade());
            ps.setInt(5, p.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
            return false;
        }
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM produtos WHERE id = ?";
        try (Connection conn = Conexao.conecta();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
            return false;
        }
    }
}
