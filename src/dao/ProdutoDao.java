/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Produto;

/**
 *
 * @author euzebio
 */
public class ProdutoDao {
    
    private Connection con = null;
    private String sql;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    List<Produto> produtos = new ArrayList<Produto>();
    
    public void inserir(Produto produto){
        try{
            con = bd.ConnectionFactory.getConnection();
            sql = "insert into produto (nome, descricao, codigo, preco) values (?, ? , ? ,?)";
            pstmt = con.prepareStatement(sql);
        
            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getDescricao());
            pstmt.setString(3, produto.getCodigo());
            pstmt.setDouble(4, produto.getPreco());
    
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
            
        }catch(SQLException e){
            throw new RuntimeException();
        }
    }
    public void alterar(Produto produto){
        try{
            con = bd.ConnectionFactory.getConnection();
            sql = "update produto set nome = ?, descricao = ?, codigo =?, preco =? where id = ?";
            pstmt = con.prepareStatement(sql);
        
            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getDescricao());
            pstmt.setString(3, produto.getCodigo());
            pstmt.setDouble(4, produto.getPreco());
            pstmt.setInt(5, produto.getId());
    
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
            
        }catch(SQLException e){
            throw new RuntimeException();
        }
    }
    public void excluir(Integer id){
        try{
            con = bd.ConnectionFactory.getConnection();
            sql = "delete from produto where id = ?";
            pstmt = con.prepareStatement(sql);
        
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
            
        }catch(SQLException e){
            throw new RuntimeException();
        }
    }
    public Produto pesquisarPorId(Integer id){
        try{
            con = bd.ConnectionFactory.getConnection();
            sql = "select * from produto where id = ?";
            pstmt = con.prepareStatement(sql);
        
            pstmt.setInt(1, id);            
            rs = pstmt.executeQuery();
            Produto produto = new Produto();
            while(rs.next()){
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setCodigo(rs.getString("codigo"));
                produto.setPreco(rs.getDouble("preco"));
            }            
            pstmt.close();
            con.close();
            return produto;
            
        }catch(SQLException e){            
            throw new RuntimeException();
        }
        
    }
    public List<Produto> listar(){
        try{
            con = bd.ConnectionFactory.getConnection();
            sql = "select * from produto";
            pstmt = con.prepareStatement(sql);
                    
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setCodigo(rs.getString("codigo"));
                produto.setPreco(rs.getDouble("preco"));
                produtos.add(produto);
            }            
            pstmt.close();
            con.close();
            return produtos;
            
        }catch(SQLException e){            
            throw new RuntimeException();
        }
        
    }
    public List<Produto> listarPor(String campo, String busca){
        try{
            con = bd.ConnectionFactory.getConnection();
            sql = "select * from produto where ? like '%?%'";
            pstmt = con.prepareStatement(sql);
                    
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setCodigo(rs.getString("codigo"));
                produto.setPreco(rs.getDouble("preco"));
                produtos.add(produto);
            }            
            pstmt.close();
            con.close();
            return produtos;
            
        }catch(SQLException e){            
            throw new RuntimeException();
        }
        
    }

}
