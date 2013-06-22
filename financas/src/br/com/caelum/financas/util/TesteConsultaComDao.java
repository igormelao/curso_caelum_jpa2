package br.com.caelum.financas.util;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;

public class TesteConsultaComDao {

	public static void main(String[] args) {
		
		EntityManager manager =  new JPAUtil().getEntityManager();
		Conta conta = manager.find(Conta.class, 4);
		
		MovimentacaoDao movimentacaoDao = new MovimentacaoDao(manager);
		Double media = movimentacaoDao.mediaDaConta(conta);

		System.out.println("Valor medio da conta "  + media);
	}
}
