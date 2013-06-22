package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.text.Bidi;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncaoMax {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		Conta conta = manager.find(Conta.class, 3);
		
		TypedQuery<BigDecimal> query = manager.createQuery("Select max(m.valor) FROM Movimentacao m where m.conta = :pConta",BigDecimal.class);
		query.setParameter("pConta", conta);
		
		BigDecimal valor =  query.getSingleResult();
		
		System.out.println("Valor total da conta " + valor);
	}

}
