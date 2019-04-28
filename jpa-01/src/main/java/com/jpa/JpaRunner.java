package com.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		Account account = new Account();
		
		//01. 엔티티 매니저로 저장
		//account.setUsername("keesun");
		//account.setPassword("jap");
		entityManager.persist(account);
		
		//02. 세션으로 저장
		account.setUsername("keesun");
		account.setPassword("hibernate");
		
		Session session = entityManager.unwrap(Session.class);
		session.save(account);
	}
	
}
