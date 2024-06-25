/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rgtech.sistemadevendas.jdbc;

import javax.swing.JOptionPane;

/**
 *
 * @author Rafae
 */
public class TestaConexao {
    
    public static void main(String[] args) {
        
        try {
           new ConnectionFactory().getConnection();
           JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Ocorreu o erro: " + e);
        }
    }
}
