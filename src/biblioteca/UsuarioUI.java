/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.awt.event.*;
import java.sql.*;

public class UsuarioUI {
    
    private UsuarioDAO usuarioDAO;
    
    public UsuarioUI(UsuarioDAO dao){
        this.usuarioDAO = dao;
    }

    public void abrirJanelaDeBusca(){

    String inputId = JOptionPane.showInputDialog(null, "Digite o ID do usuario", "Buscar Usuario",
            JOptionPane.QUESTION_MESSAGE);
    
        if (inputId != null && !inputId.isEmpty()){
            try{
                int id = Integer.parseInt(inputId);
                Usuario usuario = usuarioDAO.buscarUsuarioPorId(id);
                
                if(usuario != null){
                    exibirJanelaDeEdicao(usuario);
                }else{
                    JOptionPane.showMessageDialog(null, "Usuário nao encontrado com id " + id);
                }
            }catch(NumberFormatException | SQLException ex ){
                JOptionPane.showMessageDialog(null, "Erro" + ex.getMessage());
            }
        }
}
    public void exibirJanelaDeEdicao(Usuario usuario){
        JFrame frame = new JFrame("Editar ou Deletar Usuario");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(350, 300);
        frame.setLayout(new GridLayout(6,2,5,5));
        
        JTextField txtNome = new JTextField(usuario.getNome());
        JTextField txtEmail = new JTextField(usuario.getEmail());
        JTextField txtTelefone = new JTextField(usuario.getTelefone());
        JTextField txtTipo = new JTextField(usuario.getTipo_usuario());
        
        JButton btnAtualizar = new JButton("Atualizar");
        JButton btnDeletar = new JButton("Deletar");
        
        frame.add(new JLabel("nome: "));
        frame.add(txtNome);
        frame.add(new JLabel("Email: "));
        frame.add(txtEmail);
        frame.add(new JLabel("Telefone: "));
        frame.add(txtTelefone);
        frame.add(new JLabel("Tipo de Usuario: "));
        frame.add(txtTipo);
        frame.add(btnAtualizar);
        frame.add(btnDeletar);
        
        btnAtualizar.addActionListener(e ->{
            try{
                usuario.setNome(txtNome.getText());
                usuario.setEmail(txtEmail.getText());
                usuario.setTelefone(txtTelefone.getText());
                usuario.setTipo_usuario(txtTipo.getText());
                
                usuarioDAO.atualizarUsuario(usuario);
                JOptionPane.showMessageDialog(frame, "Usuario atualizado com sucesso. ");
                frame.dispose(); 
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(frame, "Erro ao atualizar "+ ex.getMessage());
            }
        });
        
        btnDeletar.addActionListener(e ->{
            int confirm = JOptionPane.showConfirmDialog(frame,
                    "Deseja realmente deletar este usuario?",
                    "Confirmacao",JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                try{
                    usuarioDAO.deletarUsuario(usuario.getId());
                    JOptionPane.showMessageDialog(frame, "Usuario deletado com sucesso");
                    frame.dispose();
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(frame, "Erro ao deletar: "+ ex.getMessage());
                }
            }
        });
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
    
}
