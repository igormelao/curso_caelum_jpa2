package br.com.caelum.financas.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;

public class MovimentacaoDao {
	EntityManager manager;
	
	public MovimentacaoDao(EntityManager manager)
	{
		this.manager= manager;
	}
	
	public Double mediaDaConta(Conta conta){
		TypedQuery<Double> query = manager.createQuery("Select avg(m.valor) FROM Movimentacao m where m.conta = :pConta " +
												"and m.tipoMovimentacao = 'SAIDA'", Double.class);
		query.setParameter("pConta", conta);
		
		Double media = query.getSingleResult();
		
		return media;
	}
	
	public Long totalDeMovimentacoes(Conta conta) {
		 
	    TypedQuery<Long> query = manager.createNamedQuery("totalDeMovimentacoes", Long.class);
	    query.setParameter("pConta", conta);
	 
	    return query.getSingleResult();
	}
}
