package sistemabancario;

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
	
	
} 


