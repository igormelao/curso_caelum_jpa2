package br.com.caleum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteGerenciamentoJPA {

	public static void main(String[] args) {
		EntityManager manager= new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		
		Conta conta = manager.find(Conta.class, 1);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta de luz");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("123.3"));
		movimentacao.setConta(conta);
		
		manager.persist(movimentacao);
		manager.getTransaction().commit();
		
		manager.close();
	}

}
