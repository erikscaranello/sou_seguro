package br.com.sousuperseguro.repositoryImpl;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import br.com.sousuperseguro.connection.CriarConexao;
import br.com.sousuperseguro.entities.Proposta;
import br.com.sousuperseguro.repository.PropostaRepository;

@Repository
public class PropostaRepositoryImpl implements PropostaRepository{

	private CriarConexao criarConexao;
	private Session session;
	
	public PropostaRepositoryImpl() {
    	criarConexao = new CriarConexao();
 	}
	
	
	@Override
	public Proposta selecionarUltimo() {
		
		this.session = criarConexao.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Criteria criteria = this.session.createCriteria(Proposta.class);
			criteria.addOrder(Order.desc("id"));
			criteria.setMaxResults(1);
			Proposta proposta = (Proposta) criteria.uniqueResult();
		
			return proposta;
		} catch (HibernateException e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
		
	}


	@Override
	public void insert(Proposta propostaNova) {
		
		this.session = criarConexao.getSession();
    	Transaction tx = null;
    	
    	try{
    	
    		tx = session.beginTransaction();
    		session.saveOrUpdate(propostaNova); 
    		tx.commit();
    	
    	} catch (HibernateException e) {
    		e.printStackTrace();
    		if (tx!=null) {
    			tx.rollback();
    			throw e;
    		}
    		
    	} finally {
    		session.close(); 
    	}
		
	}
	
}
