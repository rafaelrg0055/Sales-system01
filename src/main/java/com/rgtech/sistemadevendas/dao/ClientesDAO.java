/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rgtech.sistemadevendas.dao;

import com.rgtech.sistemadevendas.jdbc.ConnectionFactory;
import com.rgtech.sistemadevendas.model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafae
 */
public class ClientesDAO {
    
    private Connection con;
    
    
    // CONSTRUCTOR ----------------------------------------
    public ClientesDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
          
    // ----------------------------------------------------
    
    
    
    // Método de Cadastrar Cliente
    public void cadastrarCliente(Clientes obj) {
        
        try {
            
            // 1° passo - criar o comando SQL
            String sql = "insert into tb_clientes (nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            // 2° passo - conectar o banco de dados e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getEstado());
            
            // 3° passo - Executar o comando SQL
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
        }
        
    }
    
    
    // Método de Alterar Cliente
    public void alterarCliente() {
        
    }
    
    
    // Método de Excluir Cliente
    public void excluirCliente() {
        
    }
    
    
    // Método de Listar Cliente
    public List<Clientes> listarClientes() {
        try {
            // 1° passo: Criar a lista
            List<Clientes> lista = new ArrayList<>();
            
            
            // 2° passo: Criar o comando SQL, organizar e executar
            String sql = "select * from tb_clientes";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            // 3° passo: Pegar o resultado e adicionar na lista
            while(rs.next()){
                Clientes obj = new Clientes();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                
                lista.add(obj);  
            }
            return lista;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }
    
}
