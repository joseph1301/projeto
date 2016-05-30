package br.edu.fasete.dao;

import java.util.Vector;

import br.edu.fasete.principais.Aluguel;
import br.edu.fasete.principais.Cliente;
import br.edu.fasete.principais.Roupa;


public interface RegistroDao {
	
	public void InserirRegistro(Aluguel a);
	public void dispinibilidade( Roupa r);
	public Vector<Cliente> listarClientesReg();
	public Vector<Roupa> listarRoupaListaFim(Cliente c);

}