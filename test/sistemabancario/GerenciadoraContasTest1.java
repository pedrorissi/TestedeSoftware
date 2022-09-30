package sistemabancario;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraContasTest1 {
	
	private GerenciadoraContas gerContas;
	
	@Test
	public void testTransfereValor() {
		/*Montagem do cenário*/
		ContaCorrente conta01 = new ContaCorrente(1, 200, true);
		ContaCorrente conta02 = new ContaCorrente(2, 0, true);
		
		List<ContaCorrente> contaDoBanco = new ArrayList<>();
		contaDoBanco.add(conta01);
		contaDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contaDoBanco); 
		
		/* Execução do Negócio selecionado para o teste */
		gerContas.transfereValor(1, 100, 2);
		
		/* Verificações e análise*/
		assertThat(conta01.getSaldo(), is(100.0));
		assertThat(conta02.getSaldo(), is(100.0));
		
	}
	
}
