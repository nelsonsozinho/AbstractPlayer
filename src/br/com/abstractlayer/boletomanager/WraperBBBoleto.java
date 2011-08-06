package br.com.abstractlayer.boletomanager;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.abstractlayer.persistence.pojo.EmissorAdapter;
import br.com.abstractlayer.persistence.pojo.SacadoAdapter;
import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.BoletoGenerator;

public class WraperBBBoleto {

	private EmissorAdapter emissor;
	private SacadoAdapter sacado;
	
	private Banco banco;
	private Datas datas;
	private Boleto boleto;
	
	private Date dataDocumento;
	private Date dataProcessamento;
	private Date dataVencimento;
	
	private List<String> descricoes;
	private List<String> instrucoes;
	
	private Double valorBoleto;
	private String numeroDocumento;
	private String localPagamento;
	private String numDocumento;	
	
	public WraperBBBoleto() {
		//contruindo os objetos
		banco = new BancoDoBrasil();
		datas = Datas.newDatas();
		boleto = Boleto.newBoleto();
		
		//indico que o boleto pertence a esse banco
		boleto.withBanco(banco);
		boleto.withDatas(datas);
		boleto.withAceite(true);
		
	}
	
	
	public EmissorAdapter getEmissor() {
		return emissor;
	}

	public void setEmissor(EmissorAdapter emissor) {
		boleto.withEmissor(emissor.buildEmissor());
		this.emissor = emissor;
	}

	public SacadoAdapter getSacado() {
		return sacado;
	}

	public void setSacado(SacadoAdapter sacado) {
		boleto.withSacado(sacado.buildSacado());
		this.sacado = sacado;
	}

	public Date getDataDocumento() {
		return dataDocumento;
	}

	public void setDataDocumento(Date dataDocumento) {
		includeDateInDatas(dataDocumento,"documento");
		this.dataDocumento = dataDocumento;
	}

	public Date getDataProcessamento() {
		return dataProcessamento;
	}

	public void setDataProcessamento(Date dataProcessamento) {
		includeDateInDatas(dataProcessamento,"processamento");
		this.dataProcessamento = dataProcessamento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		includeDateInDatas(dataVencimento,"vencimento");
		this.dataVencimento = dataVencimento;
	}
	
	public Double getValorBoleto() {
		return valorBoleto;
	}

	public void setValorBoleto(Double valorBoleto) {
		boleto.withValorBoleto(valorBoleto);
		this.valorBoleto = valorBoleto;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		boleto.withNoDocumento(numeroDocumento);
		this.numeroDocumento = numeroDocumento;
	}

	public String getLocalPagamento() {
		return localPagamento;
	}

	public void setLocalPagamento(String localPagamento) {
		boleto.withLocaisDePagamento(localPagamento);
		this.localPagamento = localPagamento;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		boleto.withNoDocumento(numDocumento);
		this.numDocumento = numDocumento;
	}

	public List<String> getDescricoes() {
		return descricoes;
	}

	public void setDescricoes(List<String> descricoes) {
		if(descricoes != null && descricoes.size() == 4)  {
			boleto.withDescricoes(
					descricoes.get(0),
					descricoes.get(1),
					descricoes.get(2),
					descricoes.get(3));
		}
		
		this.descricoes = descricoes;
	}



	public List<String> getInstrucoes() {
		return instrucoes;
	}



	public void setInstrucoes(List<String> instrucoes) {
		if(instrucoes != null && instrucoes.size() == 4)  {
			boleto.withInstrucoes(
					instrucoes.get(0),
					instrucoes.get(1),
					instrucoes.get(2),
					instrucoes.get(3));
		}
		
		this.instrucoes = instrucoes;
	}



	/**
	 * Inclui as datas no documento conforme seus tipos
	 * 
	 * @param data
	 * @param type
	 */
	private void includeDateInDatas(Date data, String type) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		
		int dia = calendar.get(Calendar.DATE);
		int mes = calendar.get(Calendar.MONTH);
		int ano = calendar.get(Calendar.YEAR);
		
		if(type.equals("documento"))
			this.datas.withDocumento(dia, mes, ano);
		else if(type.equals("processamento")) 
			this.datas.withProcessamento(dia, mes, ano);
		else 
			this.datas.withVencimento(dia, mes, ano);
	}
	
	public byte[] gerarPdfByte() { 
		BoletoGenerator gerador = new BoletoGenerator(boleto);
		byte[] arquivo = gerador.toPDF();
		return arquivo;
	}
	
	public byte[] gerarPngByte() { 
		BoletoGenerator gerador = new BoletoGenerator(boleto);
		byte[] arquivo = gerador.toPNG();
		return arquivo;
	}
	
	public void gerarPdf() { 
		BoletoGenerator gerador = new BoletoGenerator(boleto);
		gerador.toPDF("boleto.pdf");
	}
	
}
