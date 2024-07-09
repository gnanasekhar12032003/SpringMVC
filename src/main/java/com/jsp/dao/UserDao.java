package com.jsp.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsp.Controller.User;

import antlr.collections.List;

@Repository
public class UserDao {
	@Autowired
    EntityManagerFactory emf;
	
	@Autowired
	EntityManager em;
	
	@Autowired
	EntityTransaction et;
	
	public void saveUser(User u) {
		et.begin();
		em.persist(u);
		et.commit();
	}
	
	public User login(String email,String password) {
		Query query=em.createQuery("select u from User u where u.email=?1 and u.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		try {
			User u=(User) query.getSingleResult();
			return u;
		}catch (Exception e) {
			return null;
		}
	}
	
	public java.util.List<User> findAllUser(){
		Query query=em.createQuery("select u from User u");
		java.util.List<User> user=query.getResultList();
		return user;
	}
	
	public void deleteUserById(int id) {
		User user=em.find(User.class, id);
		et.begin();
		em.remove(user);
		et.commit();
	}
	
}
