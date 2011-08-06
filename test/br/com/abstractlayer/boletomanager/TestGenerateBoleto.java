package br.com.abstractlayer.boletomanager;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.abstractlayer.persistence.pojo.EmissorAdapter;
import br.com.abstractlayer.persistence.pojo.SacadoAdapter;

public class TestGenerateBoleto {

	@Test
	public void testSimpleBBGenerator() {
		EmissorAdapter emissor = new EmissorAdapter();
		SacadoAdapter sacado = new SacadoAdapter();
		
		WraperBBBoleto boleto = new WraperBBBoleto();
		
		emissor.setCarteira("76000");
		emissor.setCedente("Fulano de Tal");
		emissor.setNumeroAgencia("1824");
		emissor.setDvAgencia("4");
		emissor.setContaCorrente("76000");
		emissor.setNumConvenio("1207113");
		emissor.setDvContaCorrente("5");
		emissor.setCarteira("18");
		emissor.setNossoNumero("9000206");
		
		sacado.setNome("Fulano da Silva");
		sacado.setCpf("111.222.333-12");
		sacado.setEndereco("Av dos testes, 111 apto 333");
		sacado.setBairro("Bairro Teste");
		sacado.setCep("01234-111");
		sacado.setCidade("São Paulo");
		sacado.setUf("SP");
		
		List<String> descricoes = new ArrayList<String>();
		List<String> instrucoes = new ArrayList<String>();
		
		descricoes.add("Descricao 1");
		descricoes.add("Descricao 2");
		descricoes.add("Descricao 3");
		descricoes.add("Descricao 4");
		
		instrucoes.add("Instrucao 1");
		instrucoes.add("Instrucao 2");
		instrucoes.add("Instrucao 3");
		instrucoes.add("Instrucao 4");
		
		boleto.setDataProcessamento(new Date());
		boleto.setDataDocumento(new Date());
		boleto.setDataVencimento(new Date());
		boleto.setInstrucoes(instrucoes);
		boleto.setDescricoes(descricoes);
		boleto.setEmissor(emissor);
		boleto.setSacado(sacado);
		boleto.setValorBoleto(new Double(12.56));
		boleto.setNumDocumento("1234");
		
		
		byte[] pdfByte = boleto.gerarPdfByte();
		boleto.gerarPdf();
		
		assertNotNull(pdfByte);
	}
	
}
