package sistemabancario;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraClienteTest {
	
	@Test
	public void testpesquisaCliente(){
		
		/*Criando clientes*/
		//Definição e inicialização do cenário.
		Cliente cliente01 = new Cliente(1, "Guilherme", 30, "guilherme@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Gabriel", 23, "gabriel@gmail.com", 2, true);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente01);
		clientes.add(cliente02);
		
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		//Fim do cenário
		
		//Execução
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
		//Análise do resultado esperado
		assertThat(cliente.getId(), is(1));
		assertThat(cliente.getEmail(), is("guilherme@gmail.com"));
		
		Cliente cliente2 = gerClientes.pesquisaCliente(2);
		assertThat(cliente2.getId(), is(2));
		assertThat(cliente2.getEmail(), is("gabriel@gmail.com"));
		
		
	}
	

	@Test
	public void testeRemoveCliente() {
		//Montagem do cenário
		Cliente cliente05 = new Cliente(5, "Pedro", 40, "pedroC@gmail.com", 3, true);
		Cliente cliente06 = new Cliente(6, "Katarina", 41, "katarinaP@gmail.com", 4, true);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente05);
		clientes.add(cliente06);
		
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		
		//Fase de execução
		boolean clienteRemovido01 = gerClientes.removeCliente(5);
		
		//Análise do resultado esperado
		assertThat(clienteRemovido01, is(true));//Retorna que o cliente foi remvido.		
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));//Esse método verifica o tamanho da lista e se o cliente realmente foi removido.
		assertNull(gerClientes.pesquisaCliente(5));//Esse método verifica se o cliente excluído está na lista.
		
		//Fase de execução
		boolean clienteRemovido02 = gerClientes.removeCliente(6);
		
		//Análise do resultado esperado
		assertThat(clienteRemovido02, is(true));//Retorna que o cliente foi remvido.		
		assertThat(gerClientes.getClientesDoBanco().size(), is(0));//Esse método verifica o tamanho da lista e se o cliente realmente foi removido.
		assertNull(gerClientes.pesquisaCliente(6));//Esse método verifica se o cliente excluído está na lista.
	}
	
	
} 


