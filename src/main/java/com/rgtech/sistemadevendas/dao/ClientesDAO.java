/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rgtech.sistemadevendas.dao;

import com.rgtech.sistemadevendas.jdbc.ConnectionFactory;
import com.rgtech.sistemadevendas.model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
}
