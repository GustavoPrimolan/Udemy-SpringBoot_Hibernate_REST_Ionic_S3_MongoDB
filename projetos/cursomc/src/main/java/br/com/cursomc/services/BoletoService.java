package br.com.cursomc.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.cursomc.domain.PagamentoComBoleto;

@Service
public class BoletoService {
	
	//EM UM PROJETO REAL DEVE CHAMAR UM WEBSERVICE PARA QUE ESSE PREENCHIMENTO SEJA FEITO
	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instanteDoPedido){
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		//7 DIAS A FRENTE
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataVencimento(cal.getTime());
	}
	
}
