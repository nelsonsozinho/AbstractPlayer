package br.com.abstractlayer.persistence.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.abstractlayer.persistence.AbstractEntity;
import br.com.caelum.stella.boleto.Emissor;

@Entity()
@Table(name = "fin_emissor")
public class EmissorAdapter extends AbstractEntity {

	//emissor
	private String cedente;
	private String numeroAgencia;
	private String dvAgencia;
	private String contaCorrente;
	private String numConvenio;
	private String dvContaCorrente;
	private String carteira;
	private String nossoNumero;
	
	private Emissor emissor;

	
	@Id
	@Column(name = "emissorId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Override
	public Long getId() {
		return super.getId();
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}
	
	public String getCedente() {
		return cedente;
	}

	public void setCedente(String cedente) {
		this.cedente = cedente;
	}

	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public String getDvAgencia() {
		return dvAgencia;
	}

	public void setDvAgencia(String dvAgencia) {
		this.dvAgencia = dvAgencia;
	}

	public String getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public String getNumConvenio() {
		return numConvenio;
	}

	public void setNumConvenio(String numConvenio) {
		this.numConvenio = numConvenio;
	}

	public String getDvContaCorrente() {
		return dvContaCorrente;
	}

	public void setDvContaCorrente(String dvContaCorrente) {
		this.dvContaCorrente = dvContaCorrente;
	}

	public String getCarteira() {
		return carteira;
	}

	public void setCarteira(String carteira) {
		this.carteira = carteira;
	}

	public String getNossoNumero() {
		return nossoNumero;
	}

	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}
	
	@Transient
	public Emissor getEmissor() {
		return emissor;
	}

	public void setEmissor(Emissor emissor) {
		this.emissor = emissor;
	}	
	
	/**
	 * Constroi um emissor para 
	 * 
	 * @return
	 */
	public Emissor buildEmissor() {
		Emissor emissor = Emissor.newEmissor().
			withCedente(getCedente()).
			withAgencia(Integer.parseInt(getNumeroAgencia())).
			withContaCorrente(Long.parseLong(getContaCorrente())).
			withNumConvenio(Long.parseLong(getNumConvenio())).
			withDvContaCorrente(getDvContaCorrente().charAt(0)).
			withCarteira(Integer.parseInt(getCarteira())).
			withNossoNumero(Long.parseLong(getNossoNumero()));
		return emissor;
	}
	
}
