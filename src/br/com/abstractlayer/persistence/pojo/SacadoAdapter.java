package br.com.abstractlayer.persistence.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import br.com.abstractlayer.persistence.AbstractEntity;

@Entity()
@Table(name = "fin_sacado")
public class SacadoAdapter extends AbstractEntity {

	//sacado
	private String nome;
	private String cpf;
	private String endereco;
	private String bairro;
	private String cep;
	private String cidade;
	private String uf;
	
	@Id
	@Column(name = "sacadoId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Override
	public Long getId() {
		return super.getId();
	}
	@Override
	public void setId(Long id) {
		super.setId(id);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
	public br.com.caelum.stella.boleto.Sacado buildSacado() {
		br.com.caelum.stella.boleto.Sacado sacado = br.com.caelum.stella.boleto.Sacado.newSacado().
		withNome(getNome()).
		withCpf(getCpf()).
		withEndereco(getEndereco()).
		withBairro(getBairro()).
		withCep(getCep()).
		withCidade(getCidade()).
		withUf(getUf());
		
		return sacado;
	}
	
}
