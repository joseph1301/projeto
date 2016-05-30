package br.edu.fasete.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import br.edu.fasete.principais.Aluguel;
import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Roupa;


public class RegistroDaoJdbc implements RegistroDao{

	public void InserirRegistro(Aluguel a) {		   
	try {											  
		PreparedStatement  stmt =  (PreparedStatement) Conexao.getConnection()
		  .prepareStatement("insert into loja.aluguel  (codCliente,dataLoca,dataDevo,preco,precoFinal) values (?,?,?,?,?)") ;
			 stmt.setInt(1, a.getCodCliente());
			 stmt.setString(2, a.getDataLoca());
			 stmt.setString(3,a.getDataEntre());
			 stmt.setFloat(4,a.getPreco());
			 stmt.setFloat(5, a.getPrecoTotal());
			 stmt.executeUpdate();
			 JOptionPane.showMessageDialog(null,"Registro cadastrado!");
			 a.setErro(false);
		}catch(Exception es){
			a.setErro(true);
							  JOptionPane.showMessageDialog(null,es);
		}
	try {
		 PreparedStatement  stmt =  (PreparedStatement) Conexao.getConnection()
				    .prepareStatement("update loja.cliente set registrado = ? where codCliente = ?");
		 Cliente c = new Cliente();
		 c.setRegistrado(true);
	   stmt.setBoolean(1,c.isRegistrado());
	   stmt.setInt(2, a.getCodCliente());
	   c.setRegistrado(false);
	   
	   stmt.executeUpdate();
		 
	  
	   
	  }catch(Exception e){
	    JOptionPane.showMessageDialog(null,"Dados invalidos!");
	  }
	 
	
	
	}
	
	public void dispinibilidade( Roupa r){
		
						 try {
							 PreparedStatement  stmt =  (PreparedStatement) Conexao.getConnection()
									    .prepareStatement("update loja.roupa set disponibilidade = ? where codRoupa = ?");
							 
							 r.setDisponibilidade(true);
						   stmt.setBoolean(1,r.isDisponibilidade());
						   stmt.setInt(2, r.getCodRoupa());
						   r.setDisponibilidade(false);
						   
						   stmt.executeUpdate();
							 
		
	  }catch(Exception e){
		  JOptionPane.showMessageDialog(null,e);
	  } 
		
	}

	public Vector<Cliente> listarClientesReg() {
		Vector<Cliente> lista = new Vector<Cliente>();
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement("select * from loja.Cliente where registrado = 1 ");
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				Cliente c = new Cliente();
				
				c.setNome(resultado.getString("nome"));
				c.setCPF(resultado.getString("CPF"));
				c.setRG(resultado.getString("RG"));
				c.setTelefone(resultado.getString("telefone"));
				c.setEstado(resultado.getString("estado"));
				c.setCidade(resultado.getString("cidade"));
				c.setBairro(resultado.getString("bairro"));
				c.setEndereco(resultado.getString("endereco"));
				c.setNumero(resultado.getString("numero"));
				c.setCodCliente(resultado.getInt("codCliente"));
				
				lista.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public Vector<Roupa> listarRoupaListaFim(Cliente c) {
		Vector<Roupa> lista = new Vector<Roupa>();
		
		
		try {
			
			
			PreparedStatement stmt = Conexao.getConnection().prepareStatement("select * from loja.listafinal WHERE codCliente = ?");
			
			    stmt.setInt(1,c.getCodCliente());
			 
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				Roupa r = new Roupa();
				
				r.setCodRoupa(resultado.getInt("codRoupa"));
				r.setTipo(resultado.getString("tipo"));
				r.setModelo(resultado.getString("modelo"));
				r.setTamanho(resultado.getString("tamanho"));
				r.setGenero(resultado.getString("genero"));
				r.setCor(resultado.getString("cor"));
				r.setDisponibilidade(resultado.getBoolean("disponibilidade"));
				r.setPreco(resultado.getFloat("preco"));
				lista.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	
	}
}

