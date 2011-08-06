package br.com.abstractlayer.boletomanager;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.bancos.Bradesco;
import br.com.caelum.stella.boleto.bancos.Itau;
import br.com.caelum.stella.boleto.bancos.LinhaDigitavelGenerator;
import br.com.caelum.stella.boleto.bancos.Real;
import br.com.caelum.stella.boleto.transformer.BoletoGenerator;

public class TestGenerateBoleAvulso {

	@Test
	public void testGenerate() {
		Datas datas = Datas.newDatas().withDocumento(1, 5, 2008)
				.withProcessamento(1, 5, 2008).withVencimento(2, 5, 2008);

		Emissor emissor = Emissor.newEmissor().withCedente("Fulano de Tal")
				.withAgencia(1824).withDvAgencia('4').withContaCorrente(76000)
				.withNumConvenio(1207113).withDvContaCorrente('5')
				.withCarteira(18).withNossoNumero(9000206);

		Sacado sacado = Sacado.newSacado().withNome("Fulano da Silva")
				.withCpf("111.222.333-12")
				.withEndereco("Av dos testes, 111 apto 333")
				.withBairro("Bairro Teste").withCep("01234-111")
				.withCidade("S�o Paulo").withUf("SP");

		Banco banco = new Itau();

		Boleto boleto = Boleto
				.newBoleto()
				.withBanco(banco)
				.withDatas(datas)
				.withQtdMoeda(new BigDecimal(3))
				.withDescricoes("descricao 1", "descricao 2", "descricao 3",
						"descricao 4", "descricao 5")
				.withEmissor(emissor)
				.withSacado(sacado)
				.withValorBoleto("200.00")
				.withNoDocumento("1234")
				.withInstrucoes("instrucao 1", "instrucao 2", "instrucao 3",
						"instrucao 4", "instrucao 5")
				.withLocaisDePagamento("local 1", "local 2")
				.withNoDocumento("4343");

		BoletoGenerator gerador = new BoletoGenerator(boleto);

		// Para gerar um boleto em PDF
		gerador.toPDF("itau.pdf");

		// Para gerar um boleto em PNG
		gerador.toPNG("itau.png");

		// Para gerar um array de bytes a partir de um PDF
		@SuppressWarnings("unused")
		byte[] bPDF = gerador.toPDF();

		// Para gerar um array de bytes a partir de um PNG
		@SuppressWarnings("unused")
		byte[] bPNG = gerador.toPNG();
	}

	@Test
	public void getBoletoBancoDoBrasil() {
		Datas datas = Datas.newDatas().withDocumento(1, 5, 2008)
				.withProcessamento(1, 5, 2008).withVencimento(2, 5, 2008);

		Emissor emissor = Emissor.newEmissor().withCedente("Fulano de Tal")
				.withAgencia(2345).withDvAgencia('6').withContaCorrente(12345)
				.withNumConvenio(1234567).withDvContaCorrente('1')
				.withCarteira(18).withNossoNumero(9050987);

		Sacado sacado = Sacado.newSacado().withNome("Fulano da Silva")
				.withCpf("111.222.333-12")
				.withEndereco("Av dos testes, 111 apto 333")
				.withBairro("Bairro Teste").withCep("01234-111")
				.withCidade("S�o Paulo").withUf("SP");

		Banco banco = new BancoDoBrasil();

		Boleto boleto = Boleto
				.newBoleto()
				.withBanco(banco)
				.withDatas(datas)
				.withDescricoes("descricao 1", "descricao 2", "descricao 3",
						"descricao 4", "descricao 5")
				.withEmissor(emissor)
				.withSacado(sacado)
				.withValorBoleto("200.00")
				.withNoDocumento("1234")
				.withInstrucoes("instrucao 1", "instrucao 2", "instrucao 3",
						"instrucao 4", "instrucao 5")
				.withLocaisDePagamento("local 1", "local 2")
				.withNoDocumento("4343");

		BoletoGenerator gerador = new BoletoGenerator(boleto);

		// Para gerar um boleto em PDF
		gerador.toPDF("Boletos.pdf");
	}

	@Test
	public void generateBradesco() {
		Datas datas = Datas.newDatas().withDocumento(1, 5, 2008)
				.withProcessamento(1, 5, 2008).withVencimento(2, 5, 2008);

		Emissor emissor = Emissor.newEmissor().withCedente("Fulano de Tal")
				.withAgencia(2345).withDvAgencia('6').withContaCorrente(12345)
				.withNumConvenio(1234567).withDvContaCorrente('1')
				.withCarteira(22).withNossoNumero(9050987);

		Sacado sacado = Sacado.newSacado().withNome("Fulano da Silva")
				.withCpf("111.222.333-12")
				.withEndereco("Av dos testes, 111 apto 333")
				.withBairro("Bairro Teste").withCep("01234-111")
				.withCidade("S�o Paulo").withUf("SP");

		Banco banco = new Bradesco();

		Boleto boleto = Boleto
				.newBoleto()
				.withBanco(banco)
				.withDatas(datas)
				.withDescricoes("descricao 1", "descricao 2", "descricao 3",
						"descricao 4", "descricao 5")
				.withEmissor(emissor)
				.withSacado(sacado)
				.withValorBoleto("200.00")
				.withNoDocumento("1234")
				.withInstrucoes("instrucao 1", "instrucao 2", "instrucao 3",
						"instrucao 4", "instrucao 5")
				.withLocaisDePagamento("local 1", "local 2")
				.withNoDocumento("4343");

		BoletoGenerator gerador = new BoletoGenerator(boleto);

		// Para gerar um boleto em PDF
		gerador.toPDF("BoletoBradesco.pdf");

		// Para gerar um array de bytes a partir de um PDF
		@SuppressWarnings("unused")
		byte[] bPDF = gerador.toPDF();

	}

	@Test
	public void generateReal() {
		Datas datas = Datas.newDatas().withDocumento(1, 5, 2008)
				.withProcessamento(1, 5, 2008).withVencimento(2, 5, 2008);

		Emissor emissor = Emissor.newEmissor().withCedente("Fulano de Tal")
				.withAgencia(2345).withDvAgencia('6').withContaCorrente(12345)
				.withNumConvenio(1234567).withDvContaCorrente('1')
				.withCarteira(22).withNossoNumero(9050987);

		Sacado sacado = Sacado.newSacado().withNome("Fulano da Silva")
				.withCpf("111.222.333-12")
				.withEndereco("Av dos testes, 111 apto 333")
				.withBairro("Bairro Teste").withCep("01234-111")
				.withCidade("S�o Paulo").withUf("SP");

		Banco banco = new Real();

		Boleto boleto = Boleto
				.newBoleto()
				.withBanco(banco)
				.withDatas(datas)
				.withDescricoes("descricao 1", "descricao 2", "descricao 3",
						"descricao 4", "descricao 5")
				.withEmissor(emissor)
				.withSacado(sacado)
				.withValorBoleto("200.00")
				.withNoDocumento("1234")
				.withInstrucoes("instrucao 1", "instrucao 2", "instrucao 3",
						"instrucao 4", "instrucao 5")
				.withLocaisDePagamento("local 1", "local 2")
				.withNoDocumento("4343");

		BoletoGenerator gerador = new BoletoGenerator(boleto);

		// Para gerar um boleto em PDF
		gerador.toPDF("BoletoReal.pdf");

		// Para gerar um array de bytes a partir de um PDF
		@SuppressWarnings("unused")
		byte[] bPDF = gerador.toPDF();

	}

	@Test
	public void testGerarLinhaDigitavel() {
		Datas datas = Datas.newDatas().withDocumento(1, 5, 2008)
				.withProcessamento(1, 5, 2008).withVencimento(2, 5, 2008);

		Emissor emissor = Emissor.newEmissor().withCedente("Fulano de Tal")
				.withAgencia(2345).withDvAgencia('6').withContaCorrente(12345)
				.withNumConvenio(1234567).withDvContaCorrente('1')
				.withCarteira(22).withNossoNumero(9050987);

		Sacado sacado = Sacado.newSacado().withNome("Fulano da Silva")
				.withCpf("111.222.333-12")
				.withEndereco("Av dos testes, 111 apto 333")
				.withBairro("Bairro Teste").withCep("01234-111")
				.withCidade("S�o Paulo").withUf("SP");

		Banco banco = new Real();

		Boleto boleto = Boleto
				.newBoleto()
				.withBanco(banco)
				.withDatas(datas)
				.withDescricoes("descricao 1", "descricao 2", "descricao 3",
						"descricao 4", "descricao 5")
				.withEmissor(emissor)
				.withSacado(sacado)
				.withValorBoleto("200.00")
				.withNoDocumento("1234")
				.withInstrucoes("instrucao 1", "instrucao 2", "instrucao 3",
						"instrucao 4", "instrucao 5")
				.withLocaisDePagamento("local 1", "local 2")
				.withNoDocumento("4343");

		BoletoGenerator gerador = new BoletoGenerator(boleto);
		LinhaDigitavelGenerator linhaDigitavel = new LinhaDigitavelGenerator();
		String linha = linhaDigitavel.geraLinhaDigitavelPara(boleto);
		
		System.out.println(linha);
		
	}

}
