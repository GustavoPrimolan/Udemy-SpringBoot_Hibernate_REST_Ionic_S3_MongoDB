package br.com.cursomc.domain;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

import br.com.cursomc.domain.enums.EstadoPagamento;

@Entity
//COM ESSA ANOTAÇÃO SERÁ ENVIADO O TIPO DO OBJETO QUE FOI INSTANCIADO DA CLASSE PAI (Pagamento)
//O VALOR DESSA ANOTAÇÃO SERÁ ENVIADO NO CAMPO COLOCADO NA CLASSE PAGAMENTO (@type)
@JsonTypeName("pagamentoComCartao")
public class PagamentoComCartao extends Pagamento{
	private static final long serialVersionUID = 1L;
	private Integer numeroDeParcelas;
	
	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
	
}
