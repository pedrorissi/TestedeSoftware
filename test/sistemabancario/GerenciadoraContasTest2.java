package sistemabancario;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraContasTest2 {
	
	private GerenciadoraContas gerContas;
	
	@Test
	public void testTransfereValor() {
		
		int idConta01 = 1;
		int idConta02 = 2;
		/*Montagem do cenário*/
		ContaCorrente conta01 = new ContaCorrente(idConta01, 100, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
		
		List<ContaCorrente> contaDoBanco = new ArrayList<>();
		contaDoBanco.add(conta01);
		contaDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contaDoBanco); 
		
		/* Execução do Negócio selecionado para o teste */
		boolean succeso = gerContas.transfereValor(idConta01, 200, idConta02);
		
		/* Verificações e análise*/
		assertTrue(succeso); //caixa preta
		assertThat(conta01.getSaldo(), is(100.0));
		assertThat(conta02.getSaldo(), is(100.0));
		
	}
	
}
