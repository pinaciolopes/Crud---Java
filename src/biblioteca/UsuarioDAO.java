
package biblioteca;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class UsuarioDAO {
    
    private Connection connection;

    public UsuarioDAO() {
        this.connection = new ConnectionFactory().conetaBD();
    }
    
    public void criarUsuario(Usuario usuario)throws SQLException{
        String sql = "INSERT INTO usuarios(nome,email,telefone,tipo_usuario)VALUES(?,?,?,?)";
        PreparedStatement pstm = null; 
        
        try{
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getEmail());
            pstm.setString(3, usuario.getTelefone());
            pstm.setString(4, usuario.getTipo_usuario());
            
            pstm.executeUpdate();
            System.out.println("Deu bom");
        }catch(SQLException e){
            System.out.println("Deu ruim"+e.getMessage());
        } 
         finally{
            if(pstm != null)pstm.close();
        }
      }
    
    public Usuario buscarUsuarioPorId (int id)throws SQLException{
        String sql = "SELECT * FROM usuarios where id = ?";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Usuario usuario = null;
        
    try{
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
        if(rs.next()){
            usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));
            usuario.setTelefone(rs.getString("Telefone"));
            usuario.setTipo_usuario(rs.getString("tipo_usuario"));
            }
    }catch (SQLException e){
            System.out.println("Deu ruim"+e.getMessage());
    }
        finally{
            if(rs!=null)rs.close();
            if(pstm !=null)pstm.close();
    }
        return usuario;
    }
    public List<Usuario> listarUsuarios()throws SQLException{
        List <Usuario> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM usuarios";
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try{
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));
            usuario.setTelefone(rs.getString("telefone"));
            usuario.setTipo_usuario(rs.getString("tipo_usuario"));
            lista.add(usuario);
            }
        }catch (SQLException e){
            System.out.println("Deu ruim"+ e.getMessage());
        }
        finally{
            if(rs != null) rs.close();
            if(pstm != null)pstm.close();
        }
        return lista;
    }
    
    public void atualizarUsuario(Usuario usuario)throws SQLException{
            String sql = "UPDATE usuarios set nome =?, email =?, telefone =?, tipo_usuario =? WHERE id =?";
        PreparedStatement pstm = null;
    try{
            pstm = connection.prepareStatement(sql);
            
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getEmail());
            pstm.setString(3, usuario.getTelefone());
            pstm.setString(4, usuario.getTipo_usuario());
                pstm.setInt(5, usuario.getId());
            int linhasAfetadas = pstm.executeUpdate();
            if(linhasAfetadas > 0){
                System.out.println("Deu bom!");
            }else{
                System.out.println("Nenhum usuario encontrado");
            }
    }catch (SQLException e){
        System.out.println("Deu ruim"+ e.getMessage());
    }
    finally{
        if(pstm != null)pstm.close();
    }
    }

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }
    public void deletarUsuario (int id) throws SQLException{
        String sql = "DELETE FROM usuarios WHERE id=?";
        PreparedStatement pstm = null;
        
        try{
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
            System.out.println("Usuario deletado com sucesso!");
        }catch(SQLException e){
            System.out.println("Erro ao deletar usuario"+ e.getMessage());
        }
        finally{
            if(pstm != null)pstm.close();
        }
    }
    }


