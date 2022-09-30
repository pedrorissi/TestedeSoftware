package sistemabancario;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GerenciadoraClienteTest2 {
	
	private GerenciadoraClienteTest2 gerClientes;
	
	private int idCliente01 = 1;
	private int idCliente02 = 2;
	
	//Acontece antes de todos os testes
	@Before
	public void setUp() {
		//*********** Montagem do cenário global ***********  
		Cliente cliente01 = new Cliente(idCliente01, "Guilherme", 30, "guilherme@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCliente02, "Gabriel", 23, "gabriel@gmail.com", 2, true);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente01);
		clientes.add(cliente02);
		
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		
	}
	
	@After
	public void tearDown() {
		//*********** Montagem do cenário global ***********
		gerClientes.clear();
	}
	
	private void clear() {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testpesquisaCliente(){
		
		
		/*Criando clientes*/
		//Definição e inicialização do cenário.
		//Cliente cliente01 = new Cliente(idCliente01, "Guilherme", 30, "guilherme@gmail.com", 1, true);
		//Cliente cliente02 = new Cliente(idCliente02, "Gabriel", 23, "gabriel@gmail.com", 2, true);
		
		//inserindo os clientes criados na lista de clientes do banco
		//List<Cliente> clientes = new ArrayList<>();
		//clientes.add(cliente01);
		//clientes.add(cliente02);
		
		//GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		//Fim do cenário
		
		//Execução
		Cliente cliente = gerClientes.pesquisaCliente(idCliente01);
		
		//Análise do resultado esperado
		assertThat(cliente.getId(), is(idCliente01));
		assertThat(cliente.getEmail(), is("guilherme@gmail.com"));
		
		Cliente cliente2 = gerClientes.pesquisaCliente(idCliente02);
		assertThat(cliente2.getId(), is(idCliente02));
		assertThat(cliente2.getEmail(), is("gabriel@gmail.com"));
		
		
	}
	

	@Test
	public void testeRemoveCliente() {
		
		//int idCliente01 = 1;
		//int idCliente02 = 2;
		//Montagem do cenário
//		Cliente cliente05 = new Cliente(idCliente01, "Pedro", 40, "pedroC@gmail.com", 3, true);
//		Cliente cliente06 = new Cliente(idCliente02, "Katarina", 41, "katarinaP@gmail.com", 4, true);
//		
//		List<Cliente> clientes = new ArrayList<>();
//		clientes.add(cliente05);
//		clientes.add(cliente06);
//		
//		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		
		//Fase de execução
		boolean clienteRemovido01 = gerClientes.removeCliente(idCliente01);
		
		//Análise do resultado esperado
		assertThat(clienteRemovido01, is(true));//Retorna que o cliente foi remvido.		
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));//Esse método verifica o tamanho da lista e se o cliente realmente foi removido.
		assertNull(gerClientes.pesquisaCliente(idCliente01));//Esse método verifica se o cliente excluído está na lista.
		
		//Fase de execução
		boolean clienteRemovido02 = gerClientes.removeCliente(idCliente02);
		
		//Análise do resultado esperado
		assertThat(clienteRemovido02, is(true));//Retorna que o cliente foi remvido.		
		assertThat(gerClientes.getClientesDoBanco().size(), is(0));//Esse método verifica o tamanho da lista e se o cliente realmente foi removido.
		assertNull(gerClientes.pesquisaCliente(idCliente02));//Esse método verifica se o cliente excluído está na lista.
	}
	
	
} 


